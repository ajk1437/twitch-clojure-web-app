(ns twitch-app.core
  (:require [ring.adapter.jetty :as webserver]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]))

(defn welcome 
  "Welcome function"
  [request]
  {:status 200
   :headers {}
   :body "<h1>Hello there!</h1>"})

(defn about
  "Information about the website developer"
  [request]
  {:status 200
   :headers {}
   :body "asdas"})

(defroutes app 
  (GET "/" [] welcome)
  (GET "/about"   [] about)
  (not-found "<h1>This is not the page you are looking for</h1>
              <p>Sorry, the page you requested was not found!</p>"))

(defn -main 
  "Main function to start web server"
  [port-number]
  (webserver/run-jetty
   (wrap-reload #'app)
   {:port (Integer. port-number)}))

