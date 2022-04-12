(ns clojurexplore.jvm.classpath
  (:require [clojure.repl :refer [dir doc]]
            [clojure.java.classpath :as cp])
  (:import [java.util.jar JarFile]
           [java.io File]))


(dir cp)


(cp/classpath)


(bean (first (cp/classpath)))


(bean (last (cp/classpath)))


(cp/classpath-directories)


(def cp-jar-files (filter cp/jar-file? (cp/classpath)))


(cp/filenames-in-jar
  (JarFile. ^File (-> cp-jar-files first bean :canonicalFile)))
