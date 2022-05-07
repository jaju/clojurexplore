(ns clojurexplore.basics.scratch
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as jio]
            [cheshire.core :as json]))


(defn csv->json [infilename outfilename]
  (let [rows (csv/read-csv (jio/reader (jio/file infilename)))
        header (first rows)
        data-rows (rest rows)]
    (spit outfilename
          (json/generate-string
            (map (fn [row] (zipmap header row)) data-rows)
            {:pretty true}))))



(csv->json "albumlist.csv" "sample.json")

(def r (range))

(take 10 (drop 10000 r))






































(def rows (csv/read-csv (jio/reader (jio/file "albumlist.csv"))))

(def columns ["id" "year" "title" "artist" "genres"])

(spit "albumlist.json" (json/generate-string (map (fn [row] (zipmap columns row)) rows) {:pretty true}))



