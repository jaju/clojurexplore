(ns clojurexplore.basics.functions
  (:import (clojure.lang IFn)))

;; Functions
(fn [x y]
  (+ x y))

((fn [x y]
   (+ x y)) 10 20)

;; The above was an anonymous function. We need def
(def add (fn [x y]
           (+ x y)))
(add 1 2)


;; The above works, but is tedious. So, we have
(defn add-v2 [x y]
  (+ x y))
(add-v2 1 2)


;; Multi-arity functions
(defn add-v3
  ([] 0)
  ([x] x)
  ([x y] (+ x y)))

;; vector [1 2 3 4]

;; vararg

(defn add-varargs [& vs]
  (reduce + vs))
(add-varargs 1 2 3 4)

;; Pre- and post-conditions on the arguments and return values
(defn divide [n d]
  {:pre [(-> d zero? not)]}
  (/ n d))

(defn to-string [a]
  {:post [(string? %)]}
  a)