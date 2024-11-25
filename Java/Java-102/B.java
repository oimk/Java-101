public class B extends A {
	public final String bField;
	
	public B(double field1and2, String bField) {
		super(field1and2, field1and2);
		this.bField = bField;
		System.out.println("the constructor of B has been called");
	}

	@Override 
	public void method2() {
		System.out.println("method 2 of B has been called");
	}

	public double field() {
		return super.field1;
	}
}