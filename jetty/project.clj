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

(defproject io.pedestal/pedestal.jetty "0.3.0-SNAPSHOT"
  :description "Embedded Jetty adapter for Pedestal HTTP Service"
  :plugins [[lein-modules "0.3.1"]]
  :dependencies [[org.clojure/clojure "_"]
                 [org.eclipse.jetty/jetty-server :old-jetty]
                 [org.eclipse.jetty/jetty-servlet :old-jetty]
                 [javax.servlet/javax.servlet-api "_"]]
  :global-vars {*warn-on-reflection* true})

