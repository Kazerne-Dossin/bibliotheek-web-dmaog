# bibliotheek-web-dmaog
This is the main repository for the code of the Kazerne Dossin's library website (https://bibliotheek.kazernedossin.eu). 
The application is mainly based on Spring Boot using Thymeleaf as the template rendering engine following a 
Model-View-Controller (MVC) architecture. Additionally, the model and the whole persistence layer heavily rely on 
[DMAOG](https://github.com/herminiogg/dmaog) which encapsulates the access to a SPARQL endpoint and the construction of the 
prescriptive SPARQL queries.

## Local development
You can deploy a local server for development purposes with the following command:
```
$ mvn spring-boot:run
```

## Build
To build a WAR package you can simply use:
```
$ mvn package
```
The resulting WAR file can be directly run in the JVM or deployed in a Java application server.