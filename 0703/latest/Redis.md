# Redis
#angelapper/teaching/万门/JavaEE/Springboot

https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-caching.html
https://spring.io/guides/gs/caching/

31.1.7 Redis
If Redis is available and configured, a RedisCacheManager is auto-configured. It is possible to create additional caches on startup by setting the spring.cache.cache-names property and cache defaults can be configured by using spring.cache.redis.* properties. For instance, the following configuration creates cache1 and cache2 caches with a time to live of 10 minutes:

spring.cache.cache-names=cache1,cache2
spring.cache.redis.time-to-live=600000