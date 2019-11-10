interface Any {
	public void dostuff(String name);
}

//class B implements Any {
//	public void dostuff(String name) {
//		System.out.println("Hi " + name);
//	}
//}


public class LambdaFunction {

	public static void main(String[] args) {
		
		Any obj = (name)->System.out.println("Hi " + name);
		

		obj.dostuff("Nemo");

	}

}
