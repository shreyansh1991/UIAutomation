package interfaceconcepts;

interface A {
	default void m3()
	{
		System.out.println("inside A interface");
	}
}

interface B {
	default void m3()
	{
		System.out.println("inside B interface");
	}
}

class Test implements A,B 
{
public static void main(String[] args) {
	Test ref=new Test();
	ref.m3();
}
// First Way
public void m3()
{
// System.out.println("My own Implementation..");	
	// A.super.m3(); // InterfaceName.super.methodName
	B.super.m3();
}
}