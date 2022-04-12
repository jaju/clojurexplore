(ns clojurexplore.basics.syntax)

;; Literals - they evaluate to themselves

;; Numbers
1
1.0
1e10
0x10
010
10/2

;; Characters
\a
\=
\7

;; Strings
"abc"
"this
is
a
multi-line
string"

;; Keywords
:a
:hello-clojure
;; Different from above
:a/b
::hello-clojure

;; Symbols. Also, note the ergonomics
'a
'clojure's-a-great-language

;; Lists
'(1 2)
'(1 :b :c 10 '(9 0 '(:foo :bar)))
'('a 'b 'c)

;; Vectors
[]
[1 2 3 4 5]
[1 2 [3 4] '(5 6)]

;; Sets
#{10 20 30}
#{1 :two "three" 'FOUR}
#{1 1 1 :this-set-is-invalid-and-can't-be-evaluated}

;; Maps
{:k1 :v1, :k2 :v2, :k3 :v3, :k4 :v4}
{1 :one 2 :two 3 :three 4 :four}

;; Named handle to values - var-s
(def foo-a :a)
foo-a
(def foo-b "b")
foo-b
(def foo-map {1 :one 2 :two 3 :three 4 :four})
foo-map

;; Function invocation
(+ 1 1 1 1 1)

;; Getting a handle to a named var
(meta #'+)
(meta #'foo-a)

;; Comments
;; This is a comment
(comment
  (+ 1 1)
  (:entire :blocks :of :code :can :be :commented :this :way))
#_#_ "The next two forms" "are commented" "This one is fine"

;; Functions
(fn [arg1 arg2]
  (+ arg1 arg2))
;; The above was an anonymous function. We need def
(def add (fn [arg1 arg2]
           (+ arg1 arg2)))
(add 1 2)
;; The above works, but is tedious. So, we have a more efficient syntax
(defn add-2 [arg1 arg2]
  (+ arg1 arg2))
(add-2 1 2)

;; require-ing (akin to Java importing)
(require '[clojure.set :as s])
(s/difference #{1 2 3} #{2 3 4})

;; java - by default, java.lang classes are available
;; static method call appears like a namespace qualified invocation
(Math/sqrt 2)

(new String "abc")
;; Ergonomics
(String. "abc")

;; import-ing Java
(import '[java.util ArrayList HashMap])
(class (ArrayList. [1 2]))
;; But the following is different
(class [1 2])

;; More ergonomics
(doto (HashMap.)
  (.put :a :A)
  (.put :b :B)
  (.put :c :C))