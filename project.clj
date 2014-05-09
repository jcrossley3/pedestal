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

(defproject io.pedestal/pedestal "0.3.0-SNAPSHOT"
  :plugins [[lein-modules "0.3.1"]]
  :profiles {:travis {:modules {:subprocess "lein2"}}}

  :modules {:inherited
            {:min-lein-version "2.0.0"}

            :versions
            {io.pedestal                  "0.3.0-SNAPSHOT"

             org.clojure/clojure          "1.6.0"
             org.clojure/core.async       "0.1.278.0-76b25b-alpha"
             org.clojure/core.incubator   "0.1.3"
             org.clojure/tools.logging    "0.2.4"
             org.clojure/java.classpath   "0.2.0"
             org.clojure/tools.namespace  "0.2.2"

             org.eclipse.jetty            "9.1.4.v20140401"
             :old-jetty                   "9.1.3.v20140225"
             
             org.apache.tomcat.embed      "8.0.5"

             ring                         "1.2.2"
             cheshire                     "5.3.1"
             org.slf4j                    "1.7.2"
             ch.qos.logback               "1.0.13"

             javax.servlet                "3.1.0"
             :old-servlet                 "3.0.1"}})

