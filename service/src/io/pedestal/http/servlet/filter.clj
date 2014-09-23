; Copyright 2014 Cognitect, Inc.

; The use and distribution terms for this software are covered by the
; Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0)
; which can be found in the file epl-v10.html at the root of this distribution.
;
; By using this software in any fashion, you are agreeing to be bound by
; the terms of this license.
;
; You must not remove this notice, or any other, from this software.

(ns io.pedestal.http.servlet.filter
  "Servlet filter support"
  (:import (java.util EnumSet UUID)
           (javax.servlet Servlet ServletConfig ServletContext
             Filter FilterRegistration DispatcherType)))

(def dispatch-types {:forward DispatcherType/FORWARD
                     :include DispatcherType/INCLUDE
                     :request DispatcherType/REQUEST
                     :async   DispatcherType/ASYNC
                     :error   DispatcherType/ERROR})

(defn ^EnumSet dispatcher-set
  "Return a dispatch EnumSet given one of:
   - an EnumSet (no-op)
   - servlet DispatcherType
   - a keyword representation of DispatcherType (see `dispatch-types`)
   - `:all` which generates an EnumSet of all DispatcherTypes"
  [dispatches]
  (cond
    (instance? EnumSet dispatches) dispatches
    (instance? DispatcherType dispatches) (EnumSet/of dispatches)
    (= :all dispatches) (EnumSet/allOf DispatcherType)
    (dispatch-types dispatches) (EnumSet/of (dispatch-types dispatches))
    :else (throw
            (ex-info
              (str "You can only dispatch on an established dispatch type,
                   EnumSet thereof, or shorthand keyword.
                   Unaccepted: " dispatches)
              {:accepted-keywords (keys dispatch-types)
               :attempted dispatches}))))

(defn ^ServletContext add-servlet-filter
  "Add a ServletFilter to a ServletContext,
  given the context and a map that contains:
    :filter - A Filter instance, a Class, or class name
    :path - The pathSpec string that applies to the filter [\"/*\"]
    :dispatches - A keyword denoting the dispatcher type [:request]
    :name - A string identifier for the filter [random uuid]
    :init-params - A map of strings to strings [{}]"
  [^ServletContext context
   {:keys [name filter path dispatches init-params]
    :or {path "/*" dispatches :request init-params {}}}]
  (let [name (or name (str (UUID/randomUUID)))
        ^FilterRegistration registration
        (cond
          (class? filter)
          (.addFilter context ^String name ^Class filter)

          (instance? Filter filter)
          (.addFilter context ^String name ^Filter filter)

          (string? filter)
          (.addFilter context ^String name ^String filter)

          :else
          (throw (IllegalArgumentException. "Must be a Filter instance, a Class, or class name")))]
    (doto registration
      (.addMappingForUrlPatterns
        (dispatcher-set dispatches)
        true
        (into-array String [path]))
      (.setInitParameters init-params))
    context))

(defn ^ServletContext add-server-filters
  [context & more-filter-opts]
  (doseq [filter-opts more-filter-opts]
    (add-servlet-filter context filter-opts)))

(defn filter->init
  "A helper to create a valid Servlet init fn"
  [options]
  (fn [^Servlet servlet ^ServletConfig config]
    (add-servlet-filter (.getServletContext config) options)))

