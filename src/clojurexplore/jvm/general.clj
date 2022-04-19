(ns clojurexplore.jvm.general
  (:require [clojure.repl :refer [dir dir-fn]]
            [clojure.java.data :refer :all])
  (:import [java.util HashMap ArrayList List]))

(class "Hello")
(class (String. "Hello"))

(= "Hello" (String. "Hello"))

(= (doto (HashMap.)
     (.put "a" "A")
     (.put "b" "B"))
   {"a" "A" "b" "B"})

(= (List/of 1 2 3)
   (list 1 2 3)
   '(1 2 3))

;; java - by default, java.lang classes are available
;; static method call appears like a namespace qualified invocation
(Math/sqrt 2)

(new String "abc")
;; Ergonomics
(String. "abc")

;; import-ing Java
(import '[java.util ArrayList HashMap])
(class (ArrayList. [1 2]))
;; But the following is different
(class [1 2])

;; More ergonomics
(doto (HashMap.)
  (.put :a :A)
  (.put :b :B)
  (.put :c :C))

(class (into-array [1 2 3]))
(class (into-array [1 2 "3"]))
(class (into-array Object [1 2 "3"]))
(class (into-array String ["1" "2" "3"]))

(class (to-array [1 2 3]))


(dir clojure.java.data)
(dir-fn 'clojure.java.data)

(to-java Thread (bean (Thread. "Hello")))

(bean "hello")
(->> (Thread/currentThread)
  bean
  :contextClassLoader
  bean)
