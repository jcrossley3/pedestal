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

(defproject io.pedestal/pedestal.service-tools "0.3.0-SNAPSHOT"
  :description "Pedestal tools for service development"
  :plugins [[lein-modules "0.3.1"]]
  :dependencies [[io.pedestal/pedestal.service "_"]

                 ;; Auto-reload changes
                 [ns-tracker "0.2.1"]

                 ;; Logging
                 [ch.qos.logback/logback-classic "_" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jul-to-slf4j "_"]
                 [org.slf4j/jcl-over-slf4j "_"]
                 [org.slf4j/log4j-over-slf4j "_"]

                 [javax.servlet/javax.servlet-api :old-servlet :scope "test"]])

