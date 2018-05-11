package interfaceconcepts;

interface Default {
	 default void m3() {
		System.out.println("m3 method");

	}
}

public class DefaultInterfaceMain implements Default {
	
	public  void m3()
	{
		System.out.println("hii");
		Default.super.m3();
	}
	public static void main(String[] args) {
		//Default.super.m3();
		
		
	}
}
