(ns clojurexplore.4clojure)

(def ^:dynamic __)

(defn f44 [shift coll]
  (let [c (count coll)
        shift (mod shift c)]
    (take c (drop shift (concat coll coll)))))


(binding [__ f44]
  (every? true? [(= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2))
                 (= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3))
                 (= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1))
                 (= (__ 1 '(:a :b :c)) '(:b :c :a))
                 (= (__ -4 '(:a :b :c)) '(:c :a :b))]))     ;; seq


(defn f46 [f] #(f %2 %))
(binding [__ f46]
  (map identity [(= 3 ((__ nth) 2 [1 2 3 4 5]))
                 (= true ((__ >) 7 8))
                 (= 4 ((__ quot) 2 8))
                 (= [1 2 3] ((__ take) [1 2 3 4 5] 3))]))

(def f47 4)
(binding [__ f47]
  (map identity [(contains? #{4 5 6} __)
                 (contains? [1 1 1 1 1] __)
                 (contains? {4 :a 2 :b} __)
                 (not (contains? [1 2 4] __))]))


