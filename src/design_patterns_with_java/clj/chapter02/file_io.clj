(ns design-patterns-with-java.clj.chapter02.file-io
  (:import
   (java.io
    FileInputStream
    FileOutputStream)
   (java.util
    Properties)))

(defn file-properties []
  (let [properties (Properties.)]
    {:read-from-file
     (fn [filename]
       (.. properties (load (FileInputStream. filename))))
     :write-to-file
     (fn [filename]
       (.. properties (store (FileOutputStream. filename)
                             "written by FileProperties")))
     :set-value
     (fn [key value]
       (.. properties (setProperty key value)))
     :get-value
     (fn [key]
       (.. properties (getProperty key)))}))

(defn -main []
  ;; map of closures
  (let [{:keys [read-from-file set-value write-to-file]}
        (file-properties)]
    (read-from-file "file.txt")
    (set-value "month" "4")
    (set-value "day" "21")
    (write-to-file "newfile1.txt")
    (set-value "year" "2004")
    (write-to-file "newfile2.txt")))
