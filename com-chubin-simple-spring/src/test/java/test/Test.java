package test;

public class Test extends Test1 {

	
	
	public static void main(String[] args) {
		Test test = new Test();
		Test1 test1 = (Test1)test;
		System.out.println(test1);
	}
}
