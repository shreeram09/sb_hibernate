# Getting Started

### How to run project without compiling and building
`$>gradlew clean -Dorg.gradle.java.home="pathtojdkhome"` -> cleans existing build files

`$>gradlew bootRun -Dorg.gradle.java.home="pathtojdkhome"` -> compiles, tests and run the project without preparing build/jar
 - here commandline argument needed to pass , which tells build tool to consider path of required jdk home and it must be equal to 'sourceCompatibility' property mentioned in build.gradle file, without this argument gradlew build will fail with **invalid source release** error
 
### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.7/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.7/gradle-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#using-boot-devtools)
* [Spring Batch](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#howto-batch-applications)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#production-ready)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#boot-features-security)

### Guides
The following guides illustrate how to use some features concretely:

* [Creating a Batch Service](https://spring.io/guides/gs/batch-processing/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

