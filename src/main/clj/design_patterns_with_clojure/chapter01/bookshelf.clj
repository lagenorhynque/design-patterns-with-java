(ns design-patterns-with-clojure.chapter01.bookshelf)

(defrecord Book [name])

(deftype Bookshelf
  [books]
  clojure.lang.Seqable
  (seq [_]
    (seq books)))

(defn -main []
  ;; Seqable
  (let [bookshelf (->Bookshelf
                   [(->Book "Around the World in 80 Days")
                    (->Book "Bible")
                    (->Book "Cinderella")
                    (->Book "Daddy-Long-Legs")])]
    (doseq [book bookshelf]
      (println (:name book)))))
