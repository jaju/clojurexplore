(clojure.pprint/pprint (do (ns clojurexplore.ccore
  (:require [clojure.repl :refer [dir dir-fn doc]]))))

(clojure.pprint/pprint (do ))

(clojure.pprint/pprint (do *clojure-version*))

(clojure.pprint/pprint (do {:major 1, :minor 10, :incremental 1, :qualifier }))

(clojure.pprint/pprint (do (count (dir-fn 'clojure.core))))

(clojure.pprint/pprint (do 659))

(clojure.pprint/pprint (do Inst))

(clojure.pprint/pprint (do {:on clojure.core.Inst,
 :on-interface clojure.core.Inst,
 :sigs {:inst-ms* {:name inst-ms*, :arglists ([inst]), :doc }},
 :var #'clojure.core/Inst,
 :method-map {:inst-ms* :inst-ms*},
 :method-builders
 {#'clojure.core/inst-ms* #function[clojure.core/fn--8399]},
 :impls
 {java.util.Date {:inst-ms* #function[clojure.core/fn--8410]},
  java.time.Instant {:inst-ms* #function[clojure.core/fn--8414]}}}))

(clojure.pprint/pprint (do (->> 'clojure.core
  dir-fn
  (map name)
  (filter #(.startsWith % "with-")))))

(clojure.pprint/pprint (do ("with-bindings"
 "with-bindings*"
 "with-in-str"
 "with-loading-context"
 "with-local-vars"
 "with-meta"
 "with-open"
 "with-out-str"
 "with-precision"
 "with-redefs"
 "with-redefs-fn")))

(clojure.pprint/pprint (do (->> 'clojure.core
  dir-fn
  (map (comp meta resolve))
  (filter :macro)
  (map :name))))

(clojure.pprint/pprint (do (->
 ->>
 ..
 amap
 and
 areduce
 as->
 assert
 binding
 bound-fn
 case
 comment
 cond
 cond->
 cond->>
 condp
 declare
 definline
 definterface
 defmacro
 defmethod
 defmulti
 defn
 defn-
 defonce
 defprotocol
 defrecord
 defstruct
 deftype
 delay
 doseq
 dosync
 dotimes
 doto
 extend-protocol
 extend-type
 fn
 for
 future
 gen-class
 gen-interface
 if-let
 if-not
 if-some
 import
 io!
 lazy-cat
 lazy-seq
 let
 letfn
 locking
 loop
 memfn
 ns
 or
 proxy
 proxy-super
 pvalues
 refer-clojure
 reify
 some->
 some->>
 sync
 time
 vswap!
 when
 when-first
 when-let
 when-not
 when-some
 while
 with-bindings
 with-in-str
 with-loading-context
 with-local-vars
 with-open
 with-out-str
 with-precision
 with-redefs)))

(clojure.pprint/pprint (do (def core-vars
 (->> 'clojure.core
  dir-fn
  (map (comp meta resolve))))

(filter (fn [v] (= 'Inst (:name v))) core-vars)))
