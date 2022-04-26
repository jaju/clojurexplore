(ns clojurexplore.basics.maps)

;; Literal form
(def m1 {:a :A, :b :B})
(class m1)

(def m1-1 {:a :A :b :B :c :C :d :D :e :E :f :F :g :G :h :H :i :I})
;; As of 1.11.1, this is a hash-map
(class m1-1)
;
;(->> {1 :one 2 :two 3 :three 4 :four}
;    vals
;     (map name))
;
;(keyword (name :some-keyword))


;; More functions
(def m2 (array-map :c "C" :d "D"))
(class m2)
;; And we can go above 8 entries
(def m2-1 (array-map :a :A :b :B :c :C :d :D :e :E :f :F :g :G :h :H :i :I))
(class m2-1)

;; Or, we can use hash-map for < 8 entries too
(def m3 (hash-map :e :E :f :F))
(class m3)

(class (map inc [0 1 2 3 4 5 6 7 8 9]))

(map +
 [1 2 3 4 5]
 [5 4 3 2 1]
 [10 11 12 13 14]
     [100 101])

(map str {:1 1 :2 2})

;; zipmap
;; join two sequences, 1-to-1, to create a map
(def m4 (zipmap (range 8) (map str (range 8))))


;; Lookup in a map
;; `get` is good
(get m1 :a)

;; A map can act as a function too - so, we can drop the `get`
(m1 :a)

;; Keywords are functions too and can look themselves up in maps!
;; And this is more idiomatic
(:a m1)

;; Get all keys?
(keys m1)
;; Get all vals?
(vals m1)

;; Maps are countable
(count m2)
;; And iterable
(seq m2)
;; Each is a MapEntry, which falls under java.util.Map.Entry
(map class (seq m2))

;; Of course, maps are immutable

;; This gives a new map instance. m1 is unchanged
(assoc m1 :c :C)
(assoc m1 :a :new-A)
m1

;; Reading / thinking assignment - persistent
;; data-structures
;; (1 2 3 4)

;; Merge multiple maps, left-to-right order
(merge m1 {:a "A"})
(merge {:a "A"} m1)
(merge m1 m2 {:e :E :f :F})

(def languages
  {:clojure {:dynamic?    true
             :jvm?        true
             :lisp?       true
             :functional? true}

   :haskell {:dynamic?    'nopers
             :jvm?        'ugh!
             :lisp?       'what?
             :functional? 'you-bet!}

   :scala   {:dynamic?    false
             :jvm?        true
             :lisp?       'no
             :functional? 'maybe-null}

   :kotlin  {:dynamic?    false
             :jvm?        true
             :lisp?       false
             :functional? 'trying}

   :python  {:dynamic?    'very
             :jvm?        'in-my-pocket
             :lisp?       'never-indented-to-be-one
             :functional? 'what?}})

(keys languages)
(filter (comp true? :dynamic?) (vals languages))

(select-keys languages [:clojure])



(true? 'nopers)

(json/generate-string languages)















;; JSON is a breeze
(require '[cheshire.core :as json])
(json/parse-string
  (json/generate-string m1)
  #_keyword)
