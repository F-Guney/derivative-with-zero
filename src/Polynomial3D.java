
public class Polynomial3D extends Polynomial {
	// data fields
	private double a;
	private double b;
	private double c;
	private double d;

	Polynomial3D(double a, double b, double c, double d) {
		// TODO Auto-generated constructor stub
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	@Override
	public double evaluate(double x) {
		// TODO Auto-generated method stub
		return a + b * x + c * Math.pow(x, 2) + d * Math.pow(x, 3);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return d + "x^3 + " + c + "x^2  + " + b + "x + " + a;
	}
}
