
package lambdaexpression;

interface LambdaExpression {
	int printLength(String s);
}

class SubClass {
	public static void main(String[] args) {
		LambdaExpression l1 = Demo::printLengthImp;
		System.out.println(l1.printLength("Shreyansh"));
		
		
		System.out.println(printLengthImpUsingLambda("Shreyansh"));
	}

	public static int printLengthImpUsingLambda(String string) {
		LambdaExpression l = s -> s.length();
		return l.printLength(string);
	}
}

class Demo {
	public static int printLengthImp(String s) {
		return s.length();
	}
}
