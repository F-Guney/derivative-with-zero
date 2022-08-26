import java.util.ArrayList;

public class Polynomial {
	// data fields
	private ArrayList<Double> x = new ArrayList<Double>();
	private ArrayList<Double> y = new ArrayList<Double>();
	private double h;

	Polynomial() {
		// TODO Auto-generated constructor stub
		setX(x);
		setY(y);
		setH(h);

	}
	
	public double evaluate(double x) {
		return 0.0;
	}
	// getter-setter methods 
	public void setX(ArrayList<Double> x) {
		this.x = x;
	}

	public void setY(ArrayList<Double> y) {
		this.y = y;
	}

	public void setH(double h) {
		this.h = h;
	}

	public ArrayList<Double> getX() {
		return x;
	}
	// drawing the graphs
	public void draw() {
		for (int i = 0; i < x.size(); i++) {
			StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
			StdDraw.setPenRadius(0.0042);
			StdDraw.point(x.get(i), y.get(i));
		}

	}

	public ArrayList<Double> derivative(double xmin, double xmax) {
		ArrayList<Double> xValues = new ArrayList<Double>();
		setH(0.0001);
		for (double i = xmin; i < xmax; i += 0.005) {
			double value1 = evaluate(i + h);
			double value2 = evaluate(i);
			if ((value1 - value2) / h >= -0.0025 && (value1 - value2) / h <= 0.0025) {
				xValues.add(i);
			}

		}

		return xValues;

	}

}
