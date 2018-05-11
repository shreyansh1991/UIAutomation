package predicate;

import java.util.function.Predicate;

public class PredicateDemo {
	public static void main(String[] args) {
		// Predicate is functional interface
		// Predicate contains only one abstract method
		// Predictae interface is present in java.util.Function package
		// test method will return boolean value true or false.
		
		Predicate<Integer> i = (Integer x) -> x > 10;
		System.out.println(i.test(100));
	}
}
