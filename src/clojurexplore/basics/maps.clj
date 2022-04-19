(ns clojurexplore.basics.maps)

(def m1 {:a :A :b :B})
(class m1)
(def m2 (array-map :c :C :d :D))
(class m2)
(def m3 (hash-map :e :E :f :F))
(class m3)

(def m4 (zipmap (range 8) (map str (range 8))))
(class m4)

(def m5 (zipmap (range 10) (map str (range 10))))
(class m5)

(get m1 :a)
(m1 :a)
(:a m1)

(count m2)
(seq m2)
(map class (seq m2))

(merge m1 {:a "A"})
(merge {:a "A"} m1)
























;; JSON is a breeze
(require '[cheshire.core :as json])
(json/parse-string
  (json/generate-string m1)
  #_keyword)
