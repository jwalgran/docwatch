(ns docwatch.core
  (:require [docwatch.smb :refer [dir-contents]])
  (:gen-class))

(defn -main
  [& args]
  (println "REPL only for now. Try evaling things in the docwatch.smb namespace"))
