package com.dataapplab.springboot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dataapplab.springboot.file.StorageProperties;
import com.dataapplab.springboot.file.StorageService;
import com.dataapplab.springboot.order.Order;
import com.dataapplab.springboot.order.OrderItem;
import com.dataapplab.springboot.order.OrderService;
import com.dataapplab.springboot.product.ProductSKU;

/**
 * 
 * @author joshuaz
 * 
 * @SpringBootApplication  can be used to enable those three features, that is:
 * @EnableAutoConfiguration
 * @ComponentScan
 * @Configuration
 *
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties(StorageProperties.class)
@MapperScan({"com.dataapplab.springboot.product"
	,"com.dataapplab.springboot.order","com.dataapplab.springboot.security",
	"com.dataapplab.springboot.shipment"})
public class SpringbootApplication {
	@Autowired
	private Environment environment;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
	
	/*help thymeleaf find message source*/
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename(environment.getRequiredProperty("message.source.basename"));
		messageSource.setUseCodeAsDefaultMessage(
				Boolean.parseBoolean(environment.getRequiredProperty("message.source.use.code.as.default.message")));
		return messageSource;
	}
	
    @Bean
    CommandLineRunner init(OrderService orderService) {
        return (args) -> {
            //storageService.deleteAll();
            //storageService.init();
    		List<OrderItem> items = new ArrayList<OrderItem>();
    		
    		OrderItem item1 = new OrderItem(new ProductSKU(1),1500,3);
    		item1.setOrder(new Order(1));
    		OrderItem item3 = new OrderItem(new ProductSKU(2),3000,2);	
    		item3.setOrder(new Order(1));
    		
    		items.add(item1);
    		items.add(item3);
    		
    		orderService.addToShoppingCart(items);
        };
    }	
	
    /*@Bean
	public CookieSerializer cookieSerializer() {
		DefaultCookieSerializer serializer = new DefaultCookieSerializer();
		serializer.setCookieName("JSESSIONID"); 
		serializer.setCookiePath("/"); 
		serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$"); 
		return serializer;
	}*/
    /*
    @Bean
	public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter(){
	    FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new RequestResponseLoggingFilter());
	    registrationBean.addUrlPatterns("/users/*");
	         
	    return registrationBean;    
	}
     
    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);

        dataSource.setUsername("sa");
        dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        dataSource.setPassword("");

        // create a table and populate some data
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("Creating tables");
        jdbcTemplate.execute("drop table users if exists");
        jdbcTemplate.execute("create table users(id serial, firstName varchar(255), lastName varchar(255), email varchar(255))");
        jdbcTemplate.update("INSERT INTO users(firstName, lastName, email) values (?,?,?)", "Mike", "Lanyon", "lanyonm@gmail.com");

        return dataSource;
    }	
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }*/
}
