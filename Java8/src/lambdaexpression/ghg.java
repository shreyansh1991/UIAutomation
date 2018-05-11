package lambdaexpression;

interface bb {
	void mm();
}

public class ghg {
	public static void main(String[] args) {
		bb b = ghg::nn;
		b.mm();
	}

	static void nn() {

//		try {
//			System.out.println("inside mm impl");
//			System.out.println("jihihi");
//		} catch (Exception e) {
//		}
		
		bb b=	()->
		{
			System.out.println("inside mm impl");
//			System.out.println("jihihi");
		};
b.mm();
	}
}
