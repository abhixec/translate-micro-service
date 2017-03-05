# translate-micro-service

A spring boot microservice application.

Microservice Architecture

![](microservices.jpg)

## How to run it
* Clone the repository to your local machine

* Open a terminal and navigate to backend directory and run

```bash
$ mvn clean install tomcat7:run
```

* Open another terminal and navigate to translation-springboot directory and run

```bash
$ mvn clean install spring-boot:run -Dserver.port=80
```

Open Postman or any other rest client and make a POST request to `http://localhost/api/translate` with parameter `input` and the value the test that needs to translated.

