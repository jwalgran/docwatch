(ns docwatch.smb
  (:require [pantomime.mime :refer [mime-type-of]])
  (:import [jcifs.smb SmbFile NtlmPasswordAuthentication])
  (:gen-class))

(def ^:dynamic *auth* {:domain ""
                       :username ""
                       :password ""})

(defn make-auth []
  (let [{:keys [domain username password]} *auth*]
    (NtlmPasswordAuthentication. domain username password)))

(defn uri->file [uri]
  (SmbFile. uri (make-auth)))

(defn file->hash-map [file]
  {:name (.getName file)
   :path (.getPath file)
   :directory? (.isDirectory file)
   :mime-type (if (not (.isDirectory file))
                (mime-type-of (.getName file)))
   :last-modified (.getLastModified file)})

(defn interesting? [file]
  (not (or (= (.getName file) ".DS_Store")
           (= (.getName file) "Thumbs.db")
           (= (first (.getName file)) \~))))

(defn dir-contents [uri]
  (->> (uri->file uri)
       (.listFiles)
       (filter interesting?)
       (map file->hash-map)))
