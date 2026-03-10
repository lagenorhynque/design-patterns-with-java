(ns design-patterns-with-java.clj.chapter02.file-io
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

(deftype FileProperties
  [properties]
  FileIO
  (read-from-file [_ filename]
    (.. properties (load (FileInputStream. filename))))
  (write-to-file [_ filename]
    (.. properties (store (FileOutputStream. filename)
                          "written by FileProperties")))
  (set-value [_ key value]
    (.. properties (setProperty key value)))
  (get-value [_ key]
    (.. properties (getProperty key))))

(defn file-properties []
  (->FileProperties (Properties.)))

(defn -main []
  ;; protocol and deftype
  (doto (file-properties)
    (read-from-file "file.txt")
    (set-value "month" "4")
    (set-value "day" "21")
    (write-to-file "newfile1.txt")
    (set-value "year" "2004")
    (write-to-file "newfile2.txt")))
