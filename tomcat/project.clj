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

(defproject io.pedestal/pedestal.tomcat "0.3.0-SNAPSHOT"
  :description "Embedded Tomcat adapter for Pedestal HTTP Service"
  :plugins [[lein-modules "0.3.1"]]
  :dependencies [[org.clojure/clojure "_"]
                 [org.apache.tomcat.embed/tomcat-embed-logging-juli "_"]
                 [org.apache.tomcat.embed/tomcat-embed-jasper "_"]
                 [org.apache.tomcat.embed/tomcat-embed-core "_"]
                 [javax.servlet/javax.servlet-api :servlet]]
  :global-vars {*warn-on-reflection* true})

