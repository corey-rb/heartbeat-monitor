(ns heartbeat-monitor.handler
      (:use compojure.core)
      (:use cheshire.core)
      (:use ring.util.response)
      (:require [compojure.handler :as handler]
                [ring.middleware.json :as middleware]
                [compojure.route :as route]))


(defroutes app-routes
  (GET "/" [] "Hello World!")
  (GET "/ping" [url] ping-host)
  (route/not-found "Not Found"))

(def app
      (-> (handler/api app-routes)
        (middleware/wrap-json-body)
        (middleware/wrap-json-response)))

(defn ping-host
  "Send request to check status of endpoint"
  [url]
  (let [response]))