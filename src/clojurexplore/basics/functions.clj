(ns clojurexplore.basics.functions)

;; Functions
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

(defn fib-next [[a b]]
  (vector b (+' a b)))

(last (map first (take 1000 (iterate fib-next [0 1]))))
(->> [0 1]
     (iterate fib-next)
     (take 1000)
     (map first)
     last)

;; vararg

;; Keep intermediate state - v1
(defn add-all-v1 [& vs]
  (def answer 0)
  (doseq [v vs]
    (def answer (+ answer v)))
  answer)

;; def is not the answer! So, a local scope
(defn add-all-v2 [& vs]
  (let [answer (atom 0)]
    (doseq [v vs]
      (swap! answer + v))
    @answer))

;; Ugh - atom, really?

(defn add-all-v3 [& vs]
  (loop [answer 0
         remaining vs]
    (if remaining
      (recur (+ answer (first remaining)) (next remaining))
      answer)))

;; Umm?

(defn add-all-v4
  ([] 0)
  ([v & vs] (+ v (apply add-all-v4 vs))))

;; Oh, finally are we applying ourselves?

(defn add-all-v5
  ([] 0)
  ([x] x)
  ([x y] (+ x y))
  ([x y & more] (apply add-all (+ x y) more)))

;; Like the above, but slightly more efficient for a few cases. Why?

(defn add-all-v6 [& vs]
  (reduce + vs))

;; Pre- and post-conditions on the arguments and return values
(defn divide [n d]
  {:pre [(-> d zero? not)]}
  (/ n d))

(defn to-string [a]
  {:post [(string? %)]}
  a)