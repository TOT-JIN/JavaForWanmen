# Step 10.3 AOP
#angelapper/teaching/万门/JavaEE/servlet

POM.xml
```
<!-- https://mvnrepository.com/artifact/org.springframework/spring-aspects -->
		<dependency>
		    <groupId>org.springframework</groupId>
		    <artifactId>spring-aspects</artifactId>
		    <version>5.0.7.RELEASE</version>
		</dependency>	
```

### AOP是什么
是一种编程范式，不是编程语言，是OOP的补充，不是替代

### AOP的初衷
DRY：Don’t Repeat Yourself代码重复性问题
https://en.wikipedia.org/wiki/Don%27t_repeat_yourself

SOLID
https://en.wikipedia.org/wiki/SOLID
- - - -
S	单一功能原则	认为对象应该仅具有一种单一功能的概念。
- - - -
O	开闭原则  认为“软件体应该是对于扩展开放的，对于修改封闭的”的概念。
- - - -
L	里氏替换原则	认为“程序中的对象应该是可以在不改变程序正确性的前提下被它的子类所替换的”的概念。
- - - -
I	接口隔离原则	认为“多个特定客户端接口要好于一个宽泛用途的接口” 的概念。
- - - -
D	依赖反转原则	认为一个方法应该遵从“依赖于抽象而不是一个实例” 的概念。依赖注入是该原则的一种实现方式。
- - - -

SOC：Separation of Concerns关注点分离
    -水平分离：展示层->服务层->持久层
    -垂直分离：模块划分（订单、库存等）
    -切面分离：分离功能性需求与非功能性需求

### 不适合
重要的业务逻辑放到AOP中处理
无法拦截static、final、private方法
无法拦截内部方法调用

### Aspectj注解

#### Pointcut Expressions
匹配方法 execution()
匹配注解 @target() @args() @within() @annotation()
匹配包/类型 @within()
匹配对象 this() bean() target()
匹配参数 args()

* 匹配任意数量的字符
+ 匹配指定类及其子类
.. 一般用于匹配任意参数的子包或参数

&& 与操作符
|| 或操作符
! 非操作符

execution(
    modifier-pattern? // 修饰符匹配
    ret-type-pattern // 返回值匹配
    declaring-type-pattern? // 描述值包名
    name-pattern(param-pattern) // 方法名匹配（参数匹配）
    throws-pattern?// 抛出异常匹配
)

```


Matching all methods within a class in a package
execution(* com.howtodoinjava.EmployeeManager.*(..))

Matching all methods within a class within same package
execution(* EmployeeManager.*(..))

Matching all public methods in EmployeeManager
execution(public * EmployeeManager.*(..))

```


#### Advice注解
@Before，前置通知
@After（finally），后置通知，方法执行完之后
@AfterReturning，返回通知，成功执行之后
@AfterThrowing，异常通知，抛出异常之后
@Around，环绕通知

### 植入的时机
1.编译期（AspectJ）
2.类加载时（Aspectj 5+）
3.运行时（Spring AOP）

### Spring AOP 提供的三个应用
事务：@Transactional：事务控制
[透彻的掌握 Spring 中@transactional 的使用](https://www.ibm.com/developerworks/cn/java/j-master-spring-transactional-use/index.html)

ACID，是指数据库管理系统（DBMS）在寫入或更新資料的過程中，為保證事务（transaction）是正確可靠的，所必須具備的四个特性：原子性（atomicity，或稱不可分割性）、一致性（consistency）、隔离性（isolation，又称独立性）、持久性（durability）。

原子性：一個事务（transaction）中的所有操作，要么全部完成，要么全部不完成，不会结束在中间某个环节。事务在执行过程中发生错误，会被恢復（Rollback）到事务开始前的状态，就像这个事务从来没有执行过一样。

一致性：在事务开始之前和事务结束以后，数据库的完整性没有被破坏。这表示写入的资料必须完全符合所有的预设规则，这包含资料的精确度、串联性以及后续数据库可以自发性地完成预定的工作。

隔离性：数据库允许多个并发事务同时对其数据进行读写和修改的能力，隔离性可以防止多个事务并发执行时由于交叉执行而导致数据的不一致。事务隔离分为不同级别，包括读未提交（Read uncommitted）、读提交（read committed）、可重复读（repeatable read）和串行化（Serializable）。

持久性：事务处理结束后，对数据的修改就是永久的，即便系统故障也不会丢失。

安全：进行安全控制
缓存：Cacheable进行缓存控制