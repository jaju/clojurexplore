(ns clojurexplore.ccore
  (:require [clojure.repl :refer [dir dir-fn doc]]))

{:major 1, :minor 10, :incremental 1, :qualifier }

(count (dir-fn 'clojure.core))

Inst

{:on clojure.core.Inst,
 :on-interface clojure.core.Inst,
 :sigs {:inst-ms* {:name inst-ms*, :arglists ([inst]), :doc }},
 :var #'clojure.core/Inst,
 :method-map {:inst-ms* :inst-ms*},
 :method-builders
 {#'clojure.core/inst-ms* #function[clojure.core/fn--8399]},
 :impls
 {java.util.Date {:inst-ms* #function[clojure.core/fn--8410]},
  java.time.Instant {:inst-ms* #function[clojure.core/fn--8414]}}}

(->> 'clojure.core
  dir-fn
  (map name)
  (filter #(.startsWith % "with-")))

("with-bindings"
 "with-bindings*"
 "with-in-str"
 "with-loading-context"
 "with-local-vars"
 "with-meta"
 "with-open"
 "with-out-str"
 "with-precision"
 "with-redefs"
 "with-redefs-fn")

(->> 'clojure.core
  dir-fn
  (map (comp meta resolve))
  (filter :macro)
  (map :name))

(->
 ->>
 ..
 amap
 and
 areduce
 as->
 assert
 binding
 bound-fn
 case
 comment
 cond
 cond->
 cond->>
 condp
 declare
 definline
 definterface
 defmacro
 defmethod
 defmulti
 defn
 defn-
 defonce
 defprotocol
 defrecord
 defstruct
 deftype
 delay
 doseq
 dosync
 dotimes
 doto
 extend-protocol
 extend-type
 fn
 for
 future
 gen-class
 gen-interface
 if-let
 if-not
 if-some
 import
 io!
 lazy-cat
 lazy-seq
 let
 letfn
 locking
 loop
 memfn
 ns
 or
 proxy
 proxy-super
 pvalues
 refer-clojure
 reify
 some->
 some->>
 sync
 time
 vswap!
 when
 when-first
 when-let
 when-not
 when-some
 while
 with-bindings
 with-in-str
 with-loading-context
 with-local-vars
 with-open
 with-out-str
 with-precision
 with-redefs)

(def core-vars
 (->> 'clojure.core
  dir-fn
  (map (comp meta resolve))))

(filter (fn [v] (= '+' (:name v))) core-vars)

({:added "1.0",
  :ns #namespace[clojure.core],
  :name +',
  :file "clojure/core.clj",
  :inline-arities #function[clojure.core/>1?],
  :column 1,
  :line 972,
  :arglists ([] [x] [x y] [x y & more]),
  :doc
  "Returns the sum of nums. (+') returns 0. Supports arbitrary precision.\n  See also: +",
  :inline #function[clojure.core/nary-inline/fn--5541]})
