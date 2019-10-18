# MyBatis
#angelapper/teaching/万门/JavaEE/Springboot

### 什么是MyBatis
MyBatis is a Java persistence framework that couples objects with stored procedures or SQL statements using an XML descriptor or annotations. Unlike ORM frameworks, MyBatis does not map Java objects to database tables but Java methods to SQL statements. MyBatis allows to use all database functionality like stored procedures, views, queries of any complexity and vendor proprietary features.

### MyBatis解决了什么问题？
- 自带缓存机制
- 建议了JDBC方法书写，增加了代码编写效率
- 分离了SQL与Java

JDBC
Java Database Connectivity（JDBC，Java数据库连接）是Java语言中用来规范客户端程序如何来访问数据库的应用程序接口，提供了诸如查询和更新数据库中数据的方法。JDBC也是Sun Microsystems的商标。JDBC是面向关系型数据库的。

### ORM的基本思想
在Java 对象和 数据库之间有做映射。

### 回顾数据库操作
数据定义语言（Data Definition Language，DDL）
数据操作语言（Data Manipulation Language， DML）
数据控制语言（Data Control Language ，DCL）

```sql
CREATE TABLE `user` (
  `id`     int(100) unsigned NOT NULL AUTO_INCREMENT,
  `name`   varchar(32) NOT NULL DEFAULT '' COMMENT '姓名',
  `sex`    tinyint(32) NOT NULL DEFAULT 0  COMMENT '性别：0,保密；1,男；2,女',
  `mobile` varchar(20) NOT NULL DEFAULT '' COMMENT '手机',
  PRIMARY KEY (`id`)
);
```

对于网站来说，最常见的数据库操作就是CRUD对应数据库SQL的Create, Select, Insert, Delete


### 数据库Query操作
#### One to One

#### One-to-Many 


### 数据库插入操作
数据完整性

Transaction


### 数据库删除操作


