package com.crawl.url

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Route
import com.crawl.url.PathHelpers.paths
import scala.concurrent.ExecutionContext
import akka.http.scaladsl.Http

object Server extends App {

  /**
   * Created an actor system and bind the routes so that when server
   * is running we get the routes and access the APIS
   */
  implicit val system: ActorSystem = ActorSystem("crawl")
  implicit val executor: ExecutionContext = system.dispatcher
  val routes: Route = paths
  val bindingFuture = Http().newServerAt("localhost", 8080).bind(routes)
}
