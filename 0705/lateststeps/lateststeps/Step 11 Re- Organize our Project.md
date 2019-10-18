# Step 11 Re- Organize our Project
#angelapper/teaching/万门/JavaEE/servlet

### Problem
需要考虑一下集中的请求处理机制
这种 request  直接打交道的方式，会有很多地方代码会重复。
比如，认证部分

另外，非法访问越早拒绝越好

Common system services processing completes per request
Logic that is best handled in one central location is instead replicated within numerous views.

Centralizes Control 
Improves Manageability of Security 
Improves Reusability 

http://www.oracle.com/technetwork/java/frontcontroller-135648.html

[15. Web MVC framework](https://docs.spring.io/spring/docs/3.0.x/spring-framework-reference/html/mvc.html#mvc-servlet)
![](Step%2011%20Re-%20Organize%20our%20Project/66944746-5E24-424E-8A2D-0C41EEECB6A4.png)

https://orangeslate.com/2006/11/10/12-benefits-of-spring-mvc-over-struts/
https://blog.csdn.net/jianyuerensheng/article/details/51258942

https://en.wikipedia.org/wiki/Front_controller

It is "a controller that handles all requests for a website",
which is a useful structure for web application developers to achieve the flexibility and reuse without code redundancy.

A front controller centralizes functions such as view selection, security, and templating, and applies them consistently across all pages or views. Consequently, when the behavior of these functions need to change, only a small part of the application needs to be changed: the controller and its helper classes.


https://msdn.microsoft.com/en-us/library/ff648617.aspx

前端控制器模式（Front Controller Pattern）是用来提供一个集中的请求处理机制，所有的请求都将由一个单一的处理程序处理。该处理程序可以做认证/授权/记录日志，或者跟踪请求，然后把请求传给相应的处理程序。以下是这种设计模式的实体。

前端控制器（Front Controller） - 处理应用程序所有类型请求的单个处理程序，应用程序可以是基于 web 的应用程序，也可以是基于桌面的应用程序。
调度器（Dispatcher） - 前端控制器可能使用一个调度器对象来调度请求到相应的具体处理程序。
视图（View） - 视图是为请求而创建的对象。


MVC
You have decided to use the Model-View-Controller(MVC) pattern to separate the user interface logic from the business logic

### Problem
How do you best structure the controller for very complex Web applications so that you can achieve reuse and flexibility while avoiding code duplication?

If common logic is replicated in different views in the system, you need to centralize this logic to reduce the amount of code duplication. Removing the duplicated code is critical to improving the overall maintainability of the system.

Front Controller solves the decentralization problem present in Page Controller by channeling all requests through a single controller.


![](Step%2011%20Re-%20Organize%20our%20Project/A2BAD411-53E6-43A5-B556-E8122F69173C.png)


![](Step%2011%20Re-%20Organize%20our%20Project/131D6A4B-4468-44F6-B513-145499DD158C.png)

### Benefits
Centralized control. Front Controller coordinates all of the requests that are made to the Web application. 

Thread-safety. Because each request involves creating a new command object, the command objects themselves do not need to be thread safe. 

Configurability. Only one front controller needs to be configured into the Web server

Servlet线程安全

关于线程安全想必大家都练习过这样一个多线程取钱的练习。多线程操作一个变量会导致数据异常，最好不要在Servlet中声明全局变量。