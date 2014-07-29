(defproject cook "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring/ring-core "1.3.0"]
                 [ring/ring-devel "1.3.0"]
                 [compojure "1.1.8"]
                 [cheshire "5.3.1"]
                 [org.clojure/tools.logging "0.3.0"]
                 [org.slf4j/slf4j-simple "1.7.7"]
                 [org.immutant/scheduling "2.x.incremental.186"]
                 [org.immutant/caching "2.x.incremental.186"]
                 [org.immutant/messaging "2.x.incremental.186"]
                 [org.immutant/web "2.x.incremental.186"]]
  :repositories [["Immutant 2.x incremental builds"
                  "http://downloads.immutant.org/incremental/"]]

  :main clj.cook.core)
