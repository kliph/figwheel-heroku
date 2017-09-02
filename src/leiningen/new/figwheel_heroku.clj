(ns leiningen.new.figwheel-heroku
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files project-name sanitize-ns]]
            [leiningen.core.main :as main]))

(def render (renderer "figwheel-heroku"))

(defn figwheel-heroku
  [name]
  (let [data {:raw-name name
              :name (project-name name)
              :namespace (sanitize-ns name)
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' figwheel-heroku project.")
    (->files data
             [".gitignore" (render ".gitignore" data)]
             ["LICENSE" (render "LICENSE" data)]
             ["Procfile" (render "Procfile" data)]
             ["README.org" (render "README.org" data)]
             ["src/{{sanitized}}/core.cljs" (render "core.cljs" data)]
             ["resources/public/index.html" (render "index.html" data)]
             ["project.clj" (render "project.clj" data)]
             ["dev/dev/repl.clj" (render "repl.clj" data)]
             ["resources/public/css/styles.css" (render "styles.css" data)]
             ["src/{{sanitized}}/web.clj" (render "web.clj" data)])))
