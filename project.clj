(defproject heartbeat-monitor "0.1.0-SNAPSHOT"
  :description "This will ping provided endpoints for heartbeats"
  :url "http://needurl.com"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-json "0.4.0"]
                 [cheshire "5.8.0"]
                 [clj-http "3.7.0"]
                 [org.clojure/tools.logging "0.4.0"]
                 [metosin/ring-http-response "0.6.5"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler heartbeat-monitor.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
