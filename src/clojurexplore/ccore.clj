(ns clojurexplore.ccore
  (:require [clojure.repl :refer [dir dir-fn doc]]))

{:major 1, :minor 11, :incremental 1, :qualifier nil}

(count (dir-fn 'clojure.core))


Inst

(->> 'clojure.core
  dir-fn
  (map name)
  (filter #(.startsWith % "with-")))

'("with-bindings"
 "with-bindings*"
 "with-in-str"
 "with-loading-context"
 "with-local-vars"
 "with-meta"
 "with-open"
 "with-out-str"
 "with-precision"
 "with-redefs"
 "with-redefs-fn")

(->> 'clojure.core
  dir-fn
  (map (comp meta resolve))
  (filter :macro)
  (map :name))

(def core-vars
 (->> 'clojure.core
  dir-fn
  (map (comp meta resolve))))

(filter (fn [v] (= '+' (:name v))) core-vars)

(println "Hello")
