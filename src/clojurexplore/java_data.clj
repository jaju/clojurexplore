(ns clojurexplore.java-data
  (:require [clojure.repl :refer [dir dir-fn]]
            [clojure.java.data :refer :all]))





(dir clojure.java.data)
(dir-fn 'clojure.java.data)

(-> (Thread.) to-java)
(bean (Thread. "Hello"))

(bean "hello")
(->> (Thread/currentThread)
  bean
  :contextClassLoader
  bean






  )
