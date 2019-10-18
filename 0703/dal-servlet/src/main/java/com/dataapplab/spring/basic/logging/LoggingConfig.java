package com.dataapplab.spring.basic.logging;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Bean;

/**
 * 
 * @author joshuaz
 * 默认扫描配置类相同的包
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class LoggingConfig {

	// java configuration, detail control or you can use auto scan
	/*@Bean
	public BubbleSortAlgorithm algBean(){
		return new BubbleSortAlgorithm();
	}
	
    @Bean
    public BinarySearchImpl searchBean() {
        return new BinarySearchImpl(algBean());
    }*/

}
