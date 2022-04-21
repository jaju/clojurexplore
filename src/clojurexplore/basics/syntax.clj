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

;; zipmap takes 1-to-1 elements from two collections and pairs them
;; Final size is that of the shorter collection
;; Below, the second collection (range) is an infinite lazy thing
(zipmap (range 10) (range))
(class (zipmap (range 10) (range)))

;; Map tidbits
;; Smaller maps are array-maps for efficiency reasons
;; Beyond a threshold, hash-maps are used

;; How do we refer to values?
;; Named handle to values - var-s

;; Example 1
(def foo-a :a)

;; What is it? Evaluate each form
foo-a
(class 'foo-a)
(class foo-a)
(class :a)

;; Another example
(def foo-b "b")
foo-b
(class foo-b)

;; And another...
(def foo-map {1 :one 2 :two 3 :three 4 :4})
foo-map

;; def creates a namespace-wide reference

;; Comments
;; This is a comment

;; The following expression too is a comment - the entire top expression
;; encompassed by `comment`
(comment
  (+ 1 1)
  (:entire :blocks :of :code :can :be :commented :this :way))

#_ (+ 1 2 #_(+ 2 3 (+ 4 5)))

#_#_ "The next two forms" "are commented" "This one is fine"

;; Checkpoint -- session 2

;; All def-s have namespace level scope
(for [i (range 10)]
  (def i-am-inside-a-for i))

;; Accessible here
i-am-inside-a-for

;; def-s are to be handled carefully - use them for referring to constants or
;; non-varying data. And think twice before using them

;; Local variables - scope controlled

(let [a 10
      b b]
  ;; The above vector form has an even number of elements, and is called a binding
  ;; Binds symbols to values and these symbols are only available within the
  ;; let block
  (+ a b))
;; No a and b here

;; While literally let allows you to declare bindings, it is a basic mechanism for
;; all kinds of scoped bindings. Internally, all other forms use `let` underneath
;; where bindings are a thing
(loop [a 10
       b 20]
  (+ a b))

;; What loop? We did not recur, so it ends
(loop [a 10]
  (when (pos? a)
    (println a)
    (recur (dec a))))


;; Well, it was pointless. Another kind
(loop [sum 0
       ;; Need an accumulator - which is the sum above - to thread through
       current 10
       ;; 10 is the initial value
       ;; both sum and current get updated values with each (recur ...)
       ]
  (if (pos? current)
    (recur (+ sum current) (dec current))
    sum))

(reduce + (range 10))

;; Let bindings are important to know and understand, as they are
;; used implicitly in many places.



;; require-ing (akin to Java importing)
(require '[clojure.set :as s])
(s/difference #{1 2 3} #{2 3 4})