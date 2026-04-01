(ns design-patterns-with-java.clj.chapter02.print-banner
  (:require
   [design-patterns-with-java.clj.chapter02.banner :as banner]))

(defn print-weak [s]
  (banner/show-with-paren s))

(defn print-strong [s]
  (banner/show-with-aster s))

(defn -main []
  ;; functions
  (let [s "Hello"]
    (print-weak s)
    (print-strong s)))
