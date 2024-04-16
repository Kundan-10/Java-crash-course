package Que3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringOper {
	public static void main(String[] args) {
		 List<String> strings = Arrays.asList("apple", "banana", "orange", "grape", "kiwi", "mango");

	        System.out.println("Original list:");
	        strings.forEach(System.out::println);

	        List<String> transformedList = strings.stream()
	                                              .filter(s -> s.length() >= 4)
	                                              .map(String::toUpperCase)
	                                              .collect(Collectors.toList());

	        System.out.println("\nTransformed list:");
	        transformedList.forEach(System.out::println);
	}

}
