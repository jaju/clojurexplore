(ns clojurexplore.general.fibonacci)

(defn fib-next [[a b]]
  (vector b (+' a b)))

(defn fib []
  (map first (iterate fib-next [1 2])))

(take 10 (fib))

(take 10
      (drop 10 (fib)))