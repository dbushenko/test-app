(ns clj.cook.core
  (:require [immutant.web :refer :all]
            [immutant.web.javax :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.reload :as reload]
            [cheshire.core :refer :all]
            [clojure.tools.logging :as log])
  (:use [compojure.core]
        [ring.middleware.session.cookie]
        [ring.middleware.session]
        [ring.util.response])
  (:gen-class))

(defn process-gp-login []
  (-> (response (generate-string {:token "token"
                                  :user_id 42}))
      (assoc :session {:user {:id 42, :name "Shaltai-Baltai"}})))

(defroutes all-routes
  (GET "/req" req (response (str req)))
  
  (GET "/login" req (process-gp-login))

  (route/resources "/")
  (route/not-found "Not found!"))

(defn -main [& args]
  (let [servlet (create-servlet 
                 (-> all-routes
                     wrap-session
                     reload/wrap-reload))]
    (run servlet
      :host "0.0.0.0" :port "8080" :path "/")))
