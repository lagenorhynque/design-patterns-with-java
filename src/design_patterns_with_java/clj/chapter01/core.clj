(ns design-patterns-with-java.clj.chapter01.core)

(defrecord Book [name])

(deftype Bookshelf
  [books]
  clojure.lang.Seqable
  (seq [_]
    (seq books)))

(defn -main [& _]
  (let [bookshelf (->Bookshelf
                   [(->Book "Around the World in 80 Days")
                    (->Book "Bible")
                    (->Book "Cinderella")
                    (->Book "Daddy-Long-Legs")])]
    (doseq [book bookshelf]
      (println (:name book)))))
