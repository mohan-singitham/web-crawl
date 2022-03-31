package com.crawl.url

import com.crawl.url.DataModel.{FailureInfo, Result, UrlInput}
import spray.json.DefaultJsonProtocol.{jsonFormat1, jsonFormat2}
import spray.json.DefaultJsonProtocol._

/**
 * This are for serializing and deserializing the objects
 */
object DataFormatters {
  implicit val urlInputFormatter = jsonFormat1(UrlInput)
  implicit val failureInfoFormatter = jsonFormat2(FailureInfo)
  implicit val resultFormatter = jsonFormat1(Result)
}
