package com.crawl.url

import com.crawl.url.DataModel.{FailureInfo, Result}
import scalaj.http.Http

/**
 * This WebCrawler crawls the url and wraps to result if it is success/Fail and
 * also if there is exception that page is not present
 */

object WebCrawler {
  def getResponse(urls: List[String]): Result = {
    val response = urls.map(url => {
      try {
        val response = Http(url).asString
        if (response.isSuccess) {
          FailureInfo(url, response.body)
        }
        else FailureInfo(url, response.code.toString)
      } catch {
        case e: Exception => FailureInfo(url, e.getMessage)
      }
    })
    Result(response)
  }
}
