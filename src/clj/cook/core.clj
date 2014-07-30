(ns clj.cook.core
  (:require [immutant.web :refer :all]
            [immutant.web.servlet :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.reload :as reload]
            [cheshire.core :refer :all]
            [clojure.tools.logging :as log]
            [clojure.java.io :as io])
  (:use [compojure.core]
        [ring.middleware.session.cookie]
        [ring.middleware.session]
        [ring.util.response])
  (:gen-class))

(defroutes all-routes
  (GET "/" req (-> (response (slurp (io/resource "public/index.html")))
                   (assoc :session {:data "Hello, World!"})))

  
  (GET "/req" req (response (str req)))

  (route/resources "/")
  (route/not-found "Not found!"))

(def endpoint {:on-open (fn [channel]
                          (println "Opening:" (handshake-request channel))
                          (println "Session in opening:" (ring-session channel)))
               :on-message (fn [channel message]
                             (println "Message:" (handshake-request channel))
                             (println "Session in message:" (ring-session channel)))})

(defn -main [& args]
  (let [servlet (create-servlet all-routes)]
    (run (attach-endpoint servlet
                          (create-endpoint endpoint))
      :host "0.0.0.0" :port "8080" :path "/")))
