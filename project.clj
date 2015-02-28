(defproject docwatch "0.1.0-SNAPSHOT"
  :description "Poll for changes in a Samba share and log them."
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.samba.jcifs/jcifs "1.3.3"]
                 [com.novemberain/pantomime "2.4.0"]]
  :main ^:skip-aot docwatch.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
