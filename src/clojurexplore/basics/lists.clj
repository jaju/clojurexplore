(ns clojurexplore.basics.lists)

(def l1 '(1 2 3 4 5))
(class l1)

(def l2 (list 6 7 8 9 10))
(class l2)

(def l3 (range 11 16))
(class l3)

(first l1)
(second l2)

(rest l1)
(next l1)
(next '())
(rest '())

(last l1)
(butlast l1)
(ffirst (list l1 l2))

(doseq [i l1]
  (println i))

(for [i l1]
  (inc i))

(nth l1 2)

;; JSON is a breeze
(require '[cheshire.core :as json])
(json/parse-string (json/generate-string l1))