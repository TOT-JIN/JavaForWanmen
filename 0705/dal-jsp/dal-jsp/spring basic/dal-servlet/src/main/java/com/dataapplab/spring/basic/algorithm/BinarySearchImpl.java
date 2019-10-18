package com.dataapplab.spring.basic.algorithm;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;

@Component
public class BinarySearchImpl {
	
	@Autowired
	//@Qualifier("bubble")  //by qualifier
	//private SortAlgorithm sortAlgorithm;
	private SortAlgorithm bubbleSortAlgorithm; //autowired by name
		
   /* public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}
*/
    
	public int binarySearch(int[] numbers, int numberToSearchFor) {

		//BubbleSortAlgorithm sortAlgorithm = new BubbleSortAlgorithm();
		int[] sortedNumbers = this.bubbleSortAlgorithm.sort(numbers);
		
		System.out.println(bubbleSortAlgorithm);
		
		// Search the array
		return 3;
	}
}