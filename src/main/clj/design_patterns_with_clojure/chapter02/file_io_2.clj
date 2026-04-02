(ns design-patterns-with-clojure.chapter02.file-io-2
  (:import
   (java.io
    FileInputStream
    FileOutputStream)
   (java.util
    Properties)))

(defprotocol FileIO
  (read-from-file [this filename])
  (write-to-file [this filename])
  (set-value [this key value])
  (get-value [this key]))

(extend-protocol FileIO
  Properties
  (read-from-file [this filename]
    (.load this (FileInputStream. filename)))
  (write-to-file [this filename]
    (.store this (FileOutputStream. filename)
            "written by FileProperties"))
  (set-value [this key value]
    (.setProperty this key value))
  (get-value [this key]
    (.getProperty this key)))

(defn -main []
  ;; protocol extension
  (doto (Properties.)
    (read-from-file "file.txt")
    (set-value "month" "4")
    (set-value "day" "21")
    (write-to-file "newfile1.txt")
    (set-value "year" "2004")
    (write-to-file "newfile2.txt")))
