package com.dataapplab.spring.basic.algorithm;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@Component
//@Qualifier("bubble")
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode= ScopedProxyMode.INTERFACES)
public class BubbleSortAlgorithm implements SortAlgorithm {
	public int[] sort(int[] numbers) {
		// Logic for Bubble Sort
		return numbers;
	}
}
