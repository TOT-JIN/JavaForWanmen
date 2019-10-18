# Step 10 IoC and DispatchServlet  Setup
#angelapper/teaching/万门/JavaEE/servlet

### 解放View, Model, 和 Controller
1. 解耦，这种 request ， 页面，数据逻辑都混合在一起的，会不利于维护，
2. 分离角色

![](Step%2010%20IoC%20and%20DispatchServlet%20%20Setup/EFD8C714-ED3C-4BB4-B535-8F682F2ED0E1.png)

集中的请求处理机制  Front Controller Pattern
![](Step%2010%20IoC%20and%20DispatchServlet%20%20Setup/56ADB31C-13FE-4404-AC10-7305E48CD72F.png)

[Spring Framework Documentation](https://docs.spring.io/spring/docs/5.0.x/spring-framework-reference/index.html)


java.sql.SQLException: No suitable driver found for jdbc:mysql:/ /localhost:3306/ecommerce

### Add DispatchServlet
```
<!-- webapp/WEB-INF/web.xml -->
<web-app xmlns="http://java.sun.com/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
	version="4.0">

	<display-name>Data Application Lab</display-name>

	<welcome-file-list>
	    <welcome-file>/index.html</welcome-file>
	</welcome-file-list>

	    <servlet>
	        <servlet-name>dispatcher</servlet-name>
	        <servlet-class>
	            org.springframework.web.servlet.DispatcherServlet
	        </servlet-class>
	        <init-param>
	            <param-name>contextConfigLocation</param-name>
	            <param-value>/WEB-INF/ecommerce.xml</param-value>
	        </init-param>
	        <load-on-startup>1</load-on-startup>
	    </servlet>
	
	    <servlet-mapping>
	        <servlet-name>dispatcher</servlet-name>
	        <url-pattern>/mvc/*</url-pattern>
	    </servlet-mapping>	
	    
  <context-param>
    <param-name>tempfile.dir</param-name>
    <param-value>tmpfiles</param-value>
  </context-param>		

</web-app>
```

或者
```
import org.springframework.web.WebApplicationInitializer;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        appContext.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");

        ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet(appContext));
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
```

### POM
```
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>5.0.7.RELEASE</version>
		</dependency>
```


### Hello World
```
package com.dataapplab.ecommerce;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
	@RequestMapping(value = "/hello")
	@ResponseBody
	public String sayHello() {
		return "Hello World dummy";
	}
}
```