# Step 10.2 Change for multiple beans
#angelapper/teaching/万门/JavaEE/servlet

试一下，去除component，和 配置， 是否会出错？
或者都添加上，是否会出错
expected single matching bean but found 3

解决duplication component
@Primary
或者用
@Qualifier("quick")
@Qualifier("bubble")

或者 auto wired  by name
