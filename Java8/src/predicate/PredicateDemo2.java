package predicate;

import java.util.function.Predicate;

public class PredicateDemo2 {
	public static void main(String[] args) {
		Predicate<String> ref =  s -> s.length()>10;

		
		System.out.println(ref.test("hi"));

	}
}
