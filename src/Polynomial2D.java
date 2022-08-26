
public class Polynomial2D extends Polynomial {
	// data fields
	private double a;
	private double b;
	private double c;
	
	Polynomial2D(double a, double b, double c) {
		// TODO Auto-generated constructor stub
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@Override
	public double evaluate(double x) {
		// TODO Auto-generated method stub
		return a + b * x + c * Math.pow(x, 2);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return c + "x^2  + " + b + "x + " + a;
	}
}
