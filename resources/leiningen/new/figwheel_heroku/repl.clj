(ns dev.repl
  (:require [figwheel-sidecar.repl-api :as repl-api]))

(defn figwheel-up []
  (do (repl-api/start-figwheel!)
      (repl-api/cljs-repl)))
