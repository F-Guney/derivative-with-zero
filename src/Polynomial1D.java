
public class Polynomial1D extends Polynomial{
	// data fields
	private double a;
	private double b;
	
	Polynomial1D(double a, double b) {
		// TODO Auto-generated constructor stub
		this.a = a;
		this.b = b;
		
	}
	
	@Override
	public double evaluate(double x) {
		// TODO Auto-generated method stub
		return a + b * x;
	}
	
	public String toString() {
		return b + "x + " + a; 
	}
}
