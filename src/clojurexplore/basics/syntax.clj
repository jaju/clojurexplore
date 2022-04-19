(ns clojurexplore.basics.syntax)

;; Literals - they evaluate to themselves

;; Numbers
1
1.0
1e10
0x10
010
(* 3 10/3)

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

;; Symbols.
'a
(quote a)
;; An apostrophe within the symbol is all good
;; The one in the beginning is special - it's the `quote`
'clojure's-a-great-language

;; Lists.
;; Since we use parens, quoting prevents the first member from being treated as a
;; function, and the form from being evaluated
'(1 2 3)
'(1 :b :c 10 (9 0 (:foo :bar)))
'(a b c)
(list 1 2 3)

;; Vectors
[]
[1 2 3 4 5 '(6 7)]
'[1 2 [3 4] (5 6)]
(vector 1 2 3)
(vec (range 10))
;; Not very pleasing, but notice vec vs vector.

;; Sets
#{10 20 30}
(class #{10 20 30})
#{1 :two "three" 'FOUR}
;; Literal set - since we know members beforehand, seems logical it throws when
;; duplicates are encountered
#{1 1 1
  :this-set-is-invalid-and-can't-be-evaluated}
;; Inconsistency! set takes another collection to convert into a set
(set [1 1 1 1])
(class (set [1 1 1 1]))
;; But hash-set is varargs
(hash-set 1 1 1 1)
(class (hash-set 1 1 1 1))
;; And so is sorted-set. But it is created explicitly.
;; Hash-set is the default type
(sorted-set 2 4 5 10 1)
(class (sorted-set 2 4 5 10 1))

;; Maps
{:k1 :v1, :k2 :v2, :k3 :v3, :k4 :v4}
(class {:k1 :v1, :k2 :v2, :k3 :v3, :k4 :v4})
{1 :one 2 :two 3 :three 4 :four}

(zipmap (range 10) (range))
(class (zipmap (range 10) (range)))

;; Smaller maps are array-maps for efficiency reasons
;; Beyond a threshold, hash-maps are used

;; Named handle to values - var-s
(def foo-a :a)
foo-a
(class 'foo-a)
(class foo-a)
(class :a)

(def foo-b "b")
foo-b
(class foo-b)

(def foo-map {1 :one 2 :two 3 :three 4 :4})
foo-map

;; Comments
;; This is a comment

;; The following expression too is a comment - the entire top expression
;; encompassed by `comment`
(comment
  (+ 1 1)
  (:entire :blocks :of :code :can :be :commented :this :way))

#_#_ "The next two forms" "are commented" "This one is fine"

;; Checkpoint -- session 2

;; require-ing (akin to Java importing)
(require '[clojure.set :as s])
(s/difference #{1 2 3} #{2 3 4})