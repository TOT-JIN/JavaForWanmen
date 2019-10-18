# Step 10.1 Loose Coupling
#angelapper/teaching/万门/JavaEE/servlet

如果我想实现一个Search的功能
BinarySearchImpl
BubbleSortAlgorithm

```
package com.dataapplab.spring.basic;


public class BinarySearchImpl {
		
	public int binarySearch(int[] numbers, int numberToSearchFor) {

		BubbleSortAlgorithm sortAlgorithm = new BubbleSortAlgorithm();
		int[] sortedNumbers = sortAlgorithm.sort(numbers);
		
		System.out.println(sortAlgorithm);
		
		// Search the array
		return 3;
	}
}
```

```
package com.dataapplab.spring.basic;

public class BubbleSortAlgorithm {
	public int[] sort(int[] numbers) {
		// Logic for Bubble Sort
		return numbers;
	}
}
```

要想解耦合如何解？定义接口，并继承实现

```
public class QuickSortAlgorithm implements SortAlgorithm {
	public int[] sort(int[] numbers) {
		// Logic for Quick Sort
		return numbers;
	}
}
```

```
public class BubbleSortAlgorithm implements SortAlgorithm {
	public int[] sort(int[] numbers) {
		// Logic for Bubble Sort
		return numbers;
	}
}

public class QuickSortAlgorithm implements SortAlgorithm {
	public int[] sort(int[] numbers) {
		// Logic for Quick Sort
		return numbers;
	}
}

package com.dataapplab.spring.basic;
public class BinarySearchImpl {
	private SortAlgorithm sortAlgorithm;
		
    public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}

    
	public int binarySearch(int[] numbers, int numberToSearchFor) {

		//BubbleSortAlgorithm sortAlgorithm = new BubbleSortAlgorithm();
		int[] sortedNumbers = this.sortAlgorithm.sort(numbers);
		
		System.out.println(sortAlgorithm);
		
		// Search the array
		return 3;
	}
}

package com.dataapplab.spring.basic;
import com.dataapplab.spring.basic.algorithm.*;
/**
 * 
 * @author joshuaz
 * 组装你的Application
 */
public class SpringAlgorithmApplication {
	public static void main(String[] args){
       
      // ask spring to initial beans !!
		// what are beans
		// what are the dependency of beans
		// where to search beans
		
		//BinarySearchImpl search = new BinarySearchImpl(new BubbleSortAlgorithm());

		int result = search.binarySearch(new int[]{12,4,6, 3}, 3);

		System.out.println(result);
		
	}
}

```



Spring如何帮你做
SpringAlgorithmApplication.java
```
package com.dataapplab.spring.basic;

import com.dataapplab.spring.basic.algorithm.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 * @author joshuaz
 * 组装你的Application
 */
public class SpringAlgorithmApplication {
	public static void main(String[] args){
        // ask spring to initial beans !!
		// what are beans
		// what are the dependency of beans
		// where to search beans
		
		//BinarySearchImpl search = new BinarySearchImpl(new QuickSortAlgorithm());
		
		//AnnotationConfigApplicationContext
		//AnnotationConfigWebApplicationContext
		//ClassPathXmlApplicationContext 是在所有的类路径（包含JAR文件)
		//FileSystemXmlapplicationcontext 指定的文件系统路径下查找xml
		//XmlWebApplicationContext
		
        ApplicationContext context = 
                new AnnotationConfigApplicationContext(AlgorithmConfig.class);
        
        BinarySearchImpl search = context.getBean(BinarySearchImpl.class);
        BinarySearchImpl altSearch = context.getBean(BinarySearchImpl.class);

        System.out.println(search);
		System.out.println(altSearch);
		
		int result = search.binarySearch(new int[]{12,4,6, 3}, 3);

		System.out.println(result);
		
	}
}
```


```
package com.dataapplab.spring.basic.algorithm;
import org.springframework.stereotype.Component;

@Component
public class BubbleSortAlgorithm implements SortAlgorithm {
	public int[] sort(int[] numbers) {
		// Logic for Bubble Sort
		return numbers;
	}
}
```

```
package com.dataapplab.spring.basic.algorithm;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class BinarySearchImpl {
	
	@Autowired
	private SortAlgorithm sortAlgorithm;
		
    public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}

    
	public int binarySearch(int[] numbers, int numberToSearchFor) {

		//BubbleSortAlgorithm sortAlgorithm = new BubbleSortAlgorithm();
		int[] sortedNumbers = this.sortAlgorithm.sort(numbers);
		
		System.out.println(sortAlgorithm);
		
		// Search the array
		return 3;
	}
}
```


不同的配置方法：ComponentScan or Java Config
AlgorithmConfig.java
```
package com.dataapplab.spring.basic.algorithm;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

/**
 * 
 * @author joshuaz
 * 默认扫描配置类相同的包
 */
@Configuration
@ComponentScan
public class AlgorithmConfig {

	// java configuration
	/*@Bean
	public BubbleSortAlgorithm algBean(){
		return new BubbleSortAlgorithm();
	}
	
    @Bean
    public BinarySearchImpl searchBean() {
        return new BinarySearchImpl(algBean());
    }*/

}
```





