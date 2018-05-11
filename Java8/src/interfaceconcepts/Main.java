package interfaceconcepts;

/*
 * 				Case 1: defining exactly same static method in implementation/child class.
 * 				Case 2: defining same method in implementaion class by changing from static to non-static
 * 				Case 3: In this case we will change the access modifier from public to private in child class.
 */

/*interface StaticMethodDemo {
	public static void staticMethod()
	{
		System.out.println("static method.");
	}
}
class Main implements StaticMethodDemo
{
	public static void staticMethod()
	{
		System.out.println("my own implemenation.");
	}
}*/
/*
interface StaticMethodDemo {
	public static void staticMethod()
	{
		System.out.println("static method.");
	}
}
class Main implements StaticMethodDemo
{
	public  void staticMethod()
	{
		System.out.println("my own implemenation.");
	}
}*/




interface StaticMethodDemo {
	public static void staticMethod()
	{
		System.out.println("static method.");
	}
}
class Main implements StaticMethodDemo
{
	private static  void staticMethod()
	{
		System.out.println("my own implemenation.");
	}
}

