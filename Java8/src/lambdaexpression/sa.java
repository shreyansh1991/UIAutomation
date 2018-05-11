package lambdaexpression;

import java.util.function.Function;

public class sa {
	public static void main(String[] args) {
		Function<String, String> ref = (String arg0) -> {
			System.out.println(100);
			return null;
		};

		ref.apply("h");
	}
}
