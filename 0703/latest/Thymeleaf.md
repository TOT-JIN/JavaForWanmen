# Thymeleaf
#angelapper/teaching/万门/JavaEE/Springboot

### 什么是Thymeleaf

### Thymeleaf解决什么问题

### Quick Start例子

```html
<!DOCTYPE html>

<html>
  <head>
    <title>Data Applicat Lab</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
  <body>
    <p data-th-text="#{home.welcome}">Welcome to our Java course!</p>
  </body>

</html>
```


### Thymeleaf 标准语法
```html
<p th:utext="#{home.welcome}">Welcome to our grocery store!</p>
<p>Today is: <span th:text="${today}">13 february 2011</span></p>
```

[Tutorial: Using Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#standard-expression-syntax)

### Message
外部文本, 内容存在比如 properties 文件
```
<p th:text="'Any characters, <br>Let\'s</br> go!'"></p>

<p>
    今年是 <span th:text="2018"></span> <br>
    明年是 <span th:text="2018 + 1"></span>
</p>
```

```
<p th:text="#{index.welcome}">Welcome Message</p>
```


```
<p>选择变量表达式</p>
<div th:object="${products[1]}">
    <p th:text="*{id}"></p>
    <p th:text="*{name}"></p>
</div>
<p>等价的变量表达式</p>
<div>
    <p th:text="${products[1].id}"></p>
    <!-- 如果没有 "选择对象", 那么 * 和 $ 是等价的 -->
    <p th:text="*{products[1].name}"></p>
</div>
```

```
<p>${...} 中使用 #object 引用 "选择对象"</p>
<div th:object="products[2]">
    <!--　以下三种方式在这种情况下是等价的 -->
    <p th:text="${#object.id}"></p>
    <p th:text="*{id}"></p>
    <p th:text="${products[2].id}"></p>
</div>


<p>
    <div th:if="${products.count() > 0} == true">条件是真<div>
    <div th:if="${products.count() > 0} == false">条件是假<div>
    <div th:if="${(products.count() > 0) == true}">
    </div>
</p>

<div th:if="${products} != null">会显示</div>
<div th:if="${products != null}">用 ognl/spel 引擎, 会显示</div>

<span th:text="'Some literal text and ' + ${products[0].name}"></span>


<!-- >, <, 必须转意才能用 -->
<div th:if="${products.count()} &gt; 1">
    <span th:text="|产品数量是 ${products.count()}|"></span>
</div>
<!-- 可以用 gt, lt, ge, le 来代替, 这种比较好 -->
<div th:if="${products.count()} ge 3">
    <span>至少有 3 个部门</span>
</div>

<script type="text/javascript" th:src="@{/assets/ext/jquery-3.1.1-min.js}"></script>


<p th:class="${products[0].id % 2 == 0}? 'even'" th:text="${employees[0].name}"></p>


<li th:each="prod : ${products}">
    <div class="rg-list">
        <a href=""><img th:src="${prod.thumbnail}" height="130px" alt=""></a>
        <b>直降</b>
    </div>
    <div class="rg-name">
        <a href="" th:text="${prod.title}">Onions</a>
    </div>
    <div class="price">
        <span>京东价：</span>
        &#165;<span th:text="${prod.price}">149.09</span>
    </div>
</li>   

<div th:switch="${products.count()}">
    <p th:case="1">1 个</p>
    <p th:case="2">2 个</p>
    <p th:case="3">3 个</p>
    <p th:case="*">很多个</p>
</div>

<header id="header" th:replace="fragment :: header"></header>

<footer id="footer" th:replace="~{fragment :: footer}"></footer>            
```
