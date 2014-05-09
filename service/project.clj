; Copyright 2013 Relevance, Inc.
; Copyright 2014 Cognitect, Inc.

; The use and distribution terms for this software are covered by the
; Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0)
; which can be found in the file epl-v10.html at the root of this distribution.
;
; By using this software in any fashion, you are agreeing to be bound by
; the terms of this license.
;
; You must not remove this notice, or any other, from this software.

(defproject io.pedestal/pedestal.service "0.3.0-SNAPSHOT"
  :description "Pedestal Service"
  :plugins [[lein-modules "0.3.1"]]
  :dependencies [[org.clojure/clojure "_"]
                 ;; logging
                 [org.slf4j/slf4j-api "_"]

                 ;; route
                 [org.clojure/core.incubator "_"]

                 ;; channels
                 [org.clojure/core.async "_"]

                 ;; interceptors
                 [ring/ring-core "_"
                  :exclusions [[org.clojure/clojure]]]
                 [cheshire "_"]]
  :java-source-paths ["java"]
  :javac-options ["-target" "1.7" "-source" "1.7"]
  :global-vars {*warn-on-reflection* true}
  :aliases {"bench-log" ["trampoline" "run" "-m" "io.pedestal.log-bench"]
            "dumbrepl" ["trampoline" "run" "-m" "clojure.main/main"]}
  :profiles {:default [:dev :provided :user :base]
             :provided
             {:dependencies [[javax.servlet/javax.servlet-api :servlet]]}
             :dev
             {:source-paths ["dev" "src" "bench"]
              :dependencies [[criterium "0.3.1"]
                             [org.clojure/java.classpath "_"]
                             [org.clojure/tools.namespace "_"]
                             [clj-http "0.6.4"]
                             [io.pedestal/pedestal.jetty "_"]
                             [org.eclipse.jetty/jetty-servlets "_"]
                             [io.pedestal/pedestal.tomcat "_"]
                             [javax.servlet/javax.servlet-api :servlet]
                             ;; Logging:
                             [ch.qos.logback/logback-classic "_" :exclusions [org.slf4j/slf4j-api]]
                             [org.clojure/tools.logging "_"]
                             [org.slf4j/jul-to-slf4j "_"]
                             [org.slf4j/jcl-over-slf4j "_"]
                             [org.slf4j/log4j-over-slf4j "_"]]
              :repositories
              [["sonatype-oss"
                "https://oss.sonatype.org/content/groups/public/"]]}})
