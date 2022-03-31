package com.crawl.url

object DataModel {
  case class UrlInput(urls: List[String])
  case class FailureInfo(url: String, data: String)
  case class Result(result: List[FailureInfo])
}
