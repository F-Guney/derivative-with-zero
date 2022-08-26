import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.Scanner;

/**
 * @author Furkan Güney - 041801106
 * @since Apr. 19, 2019
 *
 */
public class Furkan_Guney {
	public static void main(String[] args) {
		String filename = "functions4.txt";
		File myFile = new File(filename);
		Scanner input = null;
		// reading the file
		try {
			input = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("Exiting program...");
			System.exit(1);
		}
		// scales
		int xMax = 10;
		int xMin = -10;
		int yMax = 10;
		int yMin = -10;

		int canvas_width = 1000;
		int canvas_height = 1000;

		// drawing lines
		StdDraw.setCanvasSize(canvas_width, canvas_height);
		StdDraw.setXscale(xMin, xMax);
		StdDraw.setYscale(yMin, yMax);
		StdDraw.enableDoubleBuffering();
		StdDraw.setPenColor(StdDraw.BLACK);
		// drawing the x points -10 to 10
		StdDraw.line(xMin, 0, xMax, 0);
		StdDraw.line(0, yMin, 0, yMax);

		// drawing the points from -10 to 10 on x-y coordinate system
		int current = -10;
		while (current <= Math.abs(xMax) + Math.abs(xMin)) {
			StdDraw.setPenRadius(0.0088);
			StdDraw.point(current, 0);
			StdDraw.point(0, current);
			current += 1;
		}
		ArrayList<Polynomial> polynoms = new ArrayList<Polynomial>();
		ArrayList<Double> xValues = new ArrayList<Double>();
		// adding of the all x coordinates to xValues
		for (double i = xMin; i < xMax; i += 0.005) {
			xValues.add(i);
		}

		int counter = 0;
		while (input.hasNext()) {
			ArrayList<Double> coefficients = new ArrayList<Double>();
			String[] parts = input.next().split(",");
			for (int i = 0; i < parts.length; i++) {
				coefficients.add(Double.parseDouble(parts[i]));
			}

			Polynomial p = new Polynomial();
			Polynomial myPolynom = null;
			ArrayList<Double> yValues = new ArrayList<Double>();

			// assigning polynomial according to the size of coefficients array list
			// yValues is evaluated xValues
			if (coefficients.size() == 2) {
				myPolynom = new Polynomial1D(coefficients.get(0), coefficients.get(1));
				for (double i = xMin; i < xMax; i += 0.005) {
					yValues.add(myPolynom.evaluate(i));

				}

			}

			else if (coefficients.size() == 3) {
				myPolynom = new Polynomial2D(coefficients.get(0), coefficients.get(1), coefficients.get(2));
				for (double i = xMin; i < xMax; i += 0.005) {
					yValues.add(myPolynom.evaluate(i));

				}

			}

			else if (coefficients.size() == 4) {
				myPolynom = new Polynomial3D(coefficients.get(0), coefficients.get(1), coefficients.get(2),
						coefficients.get(3));
				for (double i = xMin; i < xMax; i += 0.005) {
					yValues.add(myPolynom.evaluate(i));

				}

			}

			p.setX(xValues);
			p.setY(yValues);
			polynoms.add(p);
			
			// drawing the graphs
			polynoms.get(counter++).draw();

			// since 1 degree polynomials derivative can not equal to zero the program will give a message
			if (myPolynom instanceof Polynomial1D) {
				System.out.println("\nFunction: " + myPolynom);
				System.out.println(
						"Points with zero derivatives: " + "\nThere are no points with zero derivative in range");

			}
			// minX and maxX means minimum and maximum x values where derivative equals to
			// zero
			else {
				double minX = myPolynom.derivative(xMin, xMax).get(0);
				double maxX = myPolynom.derivative(xMin, xMax).get(0);

				for (int i = 0; i < myPolynom.derivative(xMin, xMax).size(); i++) {

					if (minX > myPolynom.derivative(xMin, xMax).get(i)) {
						minX = myPolynom.derivative(xMin, xMax).get(i);

					}

					if (maxX < myPolynom.derivative(xMin, xMax).get(i)) {
						maxX = myPolynom.derivative(xMin, xMax).get(i);
					}

				}
				// printing the information
				System.out.println("\nFunction: " + myPolynom);
				// if the y value of the coordinates first 4 digits are same then print 1 point
				if ((int) (myPolynom.evaluate(minX) * 1000) == (int) (myPolynom.evaluate(maxX) * 1000)) {
					StdDraw.setPenRadius(0.04);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.point(minX, myPolynom.evaluate(minX));
					System.out.printf("Points with zero derivatives:\n1.\tx:  %.2f,   y:  %.2f", minX,
							myPolynom.evaluate(minX));
				} else {
					StdDraw.setPenRadius(0.04);
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.point(minX, myPolynom.evaluate(minX));
					StdDraw.point(maxX, myPolynom.evaluate(maxX));
					System.out.printf(
							"Points with zero derivatives:\n1.\tx:  %.2f,   y:  %.2f\n2. \tx:  %.2f   y:  %.2f", minX,
							myPolynom.evaluate(minX), maxX, myPolynom.evaluate(maxX));
				}

			}

		}

		StdDraw.show();

	}
}
