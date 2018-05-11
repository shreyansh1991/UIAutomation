package interfaceconcepts;



// Difference between Interface with default method and abstract class
public interface InterfaceExample {
	/*int a=10; // public,static and final
	// In interface we cant declare instance variable
	public default void defaultMethod()
	{
		a=20;
	}*/
	
	/*InterfaceExample() // not allowed in interface
	{
		
	}*/
	// we cant not override object class method in interface.
	
	
}

abstract class AbsClass
{
	
	// we cant override object class method in abstract class.
		public  String toString() { 
	      System.out.println("My own implementation");
	      return "s";
	    }
	
	static
	{
		System.out.println("static block.");
	}
	
	{
		System.out.println("non- static block");
		
	}
	
	public AbsClass() {
		System.out.println("Inside cons"); // constructors are allowed inside abstract class.
	}
int x=10; // instance variable
public void demoMethod()
{
x=20; // we can change the value in case of instance variable.	
}
}