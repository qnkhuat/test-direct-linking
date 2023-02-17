(ns test-direct-linking.test-direct-linking
  (:gen-class))

(println "COMPILER OPTIONS" *compiler-options*)

(defn greet
  "Callable entry point to the application."
  [data]
  (println (str "Hello, " (or (:name data) "World") "!")))

(defn add3
  [x]
  (+ x 3))

(alter-var-root
  #'add3
  (fn [_f] (constantly nil)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "ADD3 (should returns nil)" (add3 30)))
