package com.dataapplab.spring.basic.algorithm;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

@Component
//@Qualifier("bubble")
public class BubbleSortAlgorithm implements SortAlgorithm {
	public int[] sort(int[] numbers) {
		// Logic for Bubble Sort
		return numbers;
	}
}
