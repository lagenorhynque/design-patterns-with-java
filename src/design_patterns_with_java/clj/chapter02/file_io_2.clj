(ns design-patterns-with-java.clj.chapter02.file-io-2
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
    (.. this (load (FileInputStream. filename))))
  (write-to-file [this filename]
    (.. this (store (FileOutputStream. filename)
                    "written by FileProperties")))
  (set-value [this key value]
    (.. this (setProperty key value)))
  (get-value [this key]
    (.. this (getProperty key))))

(defn -main []
  ;; protocol extension
  (doto (Properties.)
    (read-from-file "file.txt")
    (set-value "month" "4")
    (set-value "day" "21")
    (write-to-file "newfile1.txt")
    (set-value "year" "2004")
    (write-to-file "newfile2.txt")))
