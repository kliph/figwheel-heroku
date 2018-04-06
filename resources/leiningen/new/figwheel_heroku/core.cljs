(ns {{namespace}}.core
  (:require [reagent.core :as r]
            [goog.dom]))

(def by-id goog.dom.getElement)

(defn app-container []
  [:h1 {}
   "Hello World"])

(r/render-component [app-container] (by-id "app"))

;;; Install the service worker
(when (exists? js/navigator.serviceWorker)
  (-> js/navigator
      .-serviceWorker
      (.register "/sw.js")
      (.then #(js/console.log "Server worker registered."))))
