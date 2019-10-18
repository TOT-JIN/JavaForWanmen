# Step 10.X Spring Beans
#angelapper/teaching/万门/JavaEE/servlet

https://docs.spring.io/spring/docs/5.0.x/spring-framework-reference/core.html#beans-factory-metadata

Configuration metadata

### 1.2.3. Using the container
The ApplicationContext is the interface for an advanced factory capable of maintaining a registry of different beans and their dependencies. Using the method T getBean(String name, Class<T> requiredType) you can retrieve instances of your beans.
```
// create and configure beans
ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");

// retrieve configured instance
PetStoreService service = context.getBean("petStore", PetStoreService.class);

// use configured instance
List<String> userList = service.getUsernameList();
```

Java-based container configuration

### Basic concepts: @Bean and @Configuration
You can use @Bean annotated methods with any Spring @Component, however, they are most often used with @Configuration beans.

 @Configuration indicates that its primary purpose is as a source of bean definitions. 
@Configuration classes allow inter-bean dependencies to be defined by simply calling other @Bean methods in the same class. The simplest possible @Configuration class would read as follows:
```
@Configuration
public class AppConfig {

    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}
	
<beans>
    <bean id="myService" class="com.acme.services.MyServiceImpl"/>
</beans>
```

