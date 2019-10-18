# Spring Boot  介绍
#angelapper/teaching/万门/JavaEE/Springboot

Spring Boot Starter
Actuator
```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>

<dependencies>
    <dependency>
        <groupId>org.springframework.data</groupId>
        <artifactId>spring-data-rest-hal-browser</artifactId>
    </dependency>
</dependencies>

management.endpoint.beans.enabled=true
management.endpoints.web.exposure.include = *
```

不能restart
https://docs.spring.io/spring-boot/docs/current/maven-plugin/usage.html
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <version>2.0.3.RELEASE</version>
    <optional>true</optional>
  </dependency>