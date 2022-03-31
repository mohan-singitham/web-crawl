### Start running Server
Once you clone the project, Go to your terminal and enter these

1. sbt
2. once you are in sbt console, enter compile
3. run

now the server is running you can curl the API from another terminal,
and you can see the result.


### How to test:
#####
curl -H "Content-Type: application/json" -X POST -d '{"urls": ["https://google.com", "https://github.com"]}' http://localhost:8080/api/crawl

Sample response for fail scenario:
{"result":[{"data":"google2.com","url":"http://google2.com"},{"data":"github2.com","url":"https://github2.com"}]}

I am not adding response for success as it is huge.
