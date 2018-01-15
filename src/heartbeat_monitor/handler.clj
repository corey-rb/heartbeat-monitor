(ns heartbeat-monitor.handler
      (:use compojure.core)
      (:use cheshire.core)
      (:use ring.util.response)
      (:use ring.middleware.params)
      (:require [compojure.handler :as handler]
                [ring.middleware.json :as middleware]
                [compojure.route :as route]
                [clj-http.client :as client]
                [clojure.tools.logging :as log]))

(defn ping-host
  "Send request to check status of endpoint"
  [req]
  (let [url (get-in req[:params :url])] 
    (client/get url) )
)

(defroutes app-routes
  (GET "/" [] "Hello World!")
  (GET "/ping" [] ping-host)
  (route/not-found "Not Found"))

(def app
      (-> (handler/api app-routes)
          (middleware/wrap-json-body)
          (middleware/wrap-json-response)
          (wrap-params)))

