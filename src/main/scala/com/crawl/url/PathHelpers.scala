package com.crawl.url

import akka.http.scaladsl.server.Directives.{as, complete, concat, entity, get, path, post}
import com.crawl.url.DataFormatters.urlInputFormatter
import com.crawl.url.DataModel.UrlInput
import com.crawl.url.DataFormatters._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

object PathHelpers {
  val paths: Route = {
    concat(
      get {
        path("hello") {
          complete("hai")
        }
      },
      post {
        path("api" / "crawl") {
          entity(as[UrlInput]) { urlInput =>
            complete(WebCrawler.getResponse(urlInput.urls))
          }
        }
      })
  }
}
