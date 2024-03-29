(defproject clojurexplore "0.0.0-SNAPSHOT"

  :description "Explore Clojure and the JVM through Clojure"

  :url "https://github.com/jaju/clojurexplore"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments ""}

  :dependencies [
                 [org.clojure/clojure "1.11.1"]
                 [insn "0.5.4"]
                 [nrepl/nrepl "0.9.0"]
                 [org.clojure/java.jmx "1.0.0"]
                 [org.clojure/java.data "1.0.95"]
                 [org.clojure/java.classpath "1.0.0"]
                 [cheshire/cheshire "5.10.2"]
                 ]
  )
