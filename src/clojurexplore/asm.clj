(clojure.pprint/pprint (do (ns clojurexplore.asm
  (:require [insn.core :as insn]
            [insn.clojure :as ic]
            [insn.op :as op]
            [insn.util :as util]
            [insn.core :as core])
  (:import [java.lang.invoke MethodHandles MethodHandles$Lookup]))



(def adder-class-data
  {:name 'clojurexplore.asm.Adder
   :fields [{:flags #{:public :static} :name "VALUE" :type :int :value 42}]
   :methods [

             {:flags #{:public}
              :name "add"
              :desc [:int :long]
              :emit [[:getstatic :this "VALUE" :int]
                     [:iload 1]                             ;; 'this' is 0. Argument at 1.
                     [:iadd]
                     [:i2l]
                     [:lreturn]]}


             {:flags #{:public :static}
              :name "addStatic"
              :desc [:int :long]
              :emit [[:getstatic :this "VALUE" :int]
                     [:iload 0]                             ;; No 'this' at 0. Argument at 0.
                     [:iadd]
                     [:i2l]
                     [:lreturn]]}]})


(def Adder (insn/define adder-class-data))

(def empty-class-array (make-array Class 0))))

(clojure.pprint/pprint (do (-> Adder
  (.getDeclaredConstructor empty-class-array)
  (.newInstance empty-class-array)
  (.add 10))))

(clojure.pprint/pprint (do 52))

(clojure.pprint/pprint (do (.add (insn/new-instance adder-class-data) 10)))

(clojure.pprint/pprint (do 52))

(clojure.pprint/pprint (do (.add (clojurexplore.asm.Adder.) 10)))

(clojure.pprint/pprint (do 52))

(clojure.pprint/pprint (do (clojurexplore.asm.Adder/addStatic 100)))

(clojure.pprint/pprint (do 142))

(clojure.pprint/pprint (do (def ^{:arglists '(^long [^long x])}
  incr (ic/fn ^long [^long x]
         [[:lload 1]
          [:ldc2 1]
          [:ladd]
          [:lreturn]]))

(incr 10)))

(clojure.pprint/pprint (do 11))

(clojure.pprint/pprint (do (let [class-name (str "clojurexplore.asm." (gensym "cd"))
      desc [MethodHandles$Lookup String Class Object Object]
      const (fn [x]
              (util/constant-dynamic (str "foo-" x) :long
                [:invokestatic class-name "bsm" desc] [x]))]
  (def foo {:version 11
            :name class-name
            :fields []
            :methods [{:flags #{:public :static}
                       :name "bsm"
                       :desc desc
                       :emit [[:aload 3]
                              [:checkcast Long]
                              [:invokevirtual Long "longValue" [:long]]
                              [:ldc2 1]
                              [:ladd]
                              [:invokestatic Long "valueOf" [:long Long]]
                              [:areturn]]}

                      {:name "go"
                       :desc [:long]
                       :emit [[:ldc (const 42)]
                              [:ldc (const 17)]
                              [:ladd]
                              [:lreturn]]}

                      {:name "go"
                       :desc [:int :int :long]
                       :emit [[:iload 1]
                              [:iload 2]
                              [:iadd]
                              [:i2l]
                              [:lreturn]]}]}))

(def foo-instance (insn/new-instance foo))))

(clojure.pprint/pprint (do (.go foo-instance)))

(clojure.pprint/pprint (do 61))

(clojure.pprint/pprint (do (.go foo-instance 23 45)))

(clojure.pprint/pprint (do 68))
