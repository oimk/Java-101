public class A {
	protected final double field1;
	protected final double field2;

	public A(double field1, double field2) {
		System.out.println("the constructor of A has been called");
		this.field1 = field1;
		this.field2 = field2;
	}

	public void method1() {
		System.out.println("method 1 of A has been called");
	}
	
	public void method2() {
		System.out.println("method 2 of A has been called");
	}
}