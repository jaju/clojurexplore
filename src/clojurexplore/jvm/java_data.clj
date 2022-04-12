(ns clojurexplore.jvm.java-data
  (:require [clojure.repl :refer [dir dir-fn]]
            [clojure.java.data :refer :all]))

(dir clojure.java.data)
(dir-fn 'clojure.java.data)

(to-java Thread (bean (Thread. "Hello")))

(bean "hello")
(->> (Thread/currentThread)
  bean
  :contextClassLoader
  bean)
