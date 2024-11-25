public class Circle implements Shape{
	public final Point center;
	public final double radius;

	public Circle(Point center, double radius) {
		this.center = center;
		this.radius = radius;
	}
	
	@Override

	public double area() {
		return Math.PI * Math.pow(radius, 2);
	}
	@Override
	public double perimeter() {
		return 2 * Math.PI * radius;
	}

	/** 
	* @return Whether point p is inside of the circle.
	*/
	@Override
	public boolean isInside(Point p) {
		return Point.distance(center, p) < radius;
	}

	/** 
	* @return Whether point p part of/on the border of the circle.
	*/
	@Override
	public boolean isOn(Point p) {
		return Point.distance(center, p) == radius;
	}

	/** 
	* @param x How much to translate the circle by in the + x direction.
	* @param y How much to translate the circle by in the + y direction.
	* @return The circle that results from the translation.
	*/
	@Override
	public Circle translate(double x, double y) {
		return new Circle(center.translateX(x).translateY(y), radius);
	}

	/** 
	* @return The circle that results from scaling by k.
	*/
	@Override
	public Circle scale(double k) {
		return new Circle(center, radius * k);
	}

	@Override
	public String toString() {
		return "(center: " + center + "; radius: " + radius + ")";
	}
	public static Circle fromPoints(Point p1, Point p2, Point p3){
		//Midpoint of AB and BC using midpoint formula
		Point midpointpAB = new Point((p1.x + p2.x)/2, (p1.y + p2.y)/2);
		Point midpointpBC = new Point((p2.x + p3.x)/2, (p2.y + p3.y)/2);
		System.out.println("Midpoint BC: " + midpointpBC);
		System.out.println("Midpoint AB: " + midpointpAB);
		// Slope of the prependicular lines of AB and BC
		Double PrependSlopeAB = getPerpenSlope(p1, p2);
		Double PrependSlopeBC = getPerpenSlope(p2, p3);
		System.out.println("Slope AB: " + PrependSlopeAB);
		System.out.println("Slope BC: " + PrependSlopeBC);
		// Caculate the circumcenter using system of equations 
		Double xpoint, ypoint;
		if (Double.isInfinite(PrependSlopeAB)){
			xpoint = midpointpAB.x;
            ypoint = PrependSlopeBC * (xpoint - midpointpBC.x) + midpointpBC.y;
		}
		else if (Double.isInfinite(PrependSlopeBC)){
			xpoint = midpointpBC.x;
            ypoint = PrependSlopeAB * (xpoint - midpointpAB.x) + midpointpAB.y;
		}
		else {
			double demo = (PrependSlopeAB - PrependSlopeBC);
			if (demo == 0) {
				// edge case where points of line are parallel
				System.out.println("Lines are Parallel, no possible interesection, use differnet points or no circle formable");
				return null;
			}
			xpoint = ((PrependSlopeBC * midpointpBC.x) - (PrependSlopeAB * midpointpAB.x) + (midpointpBC.y - midpointpAB.y)) / demo;
            System.out.println("x center: " + xpoint);

			ypoint = (PrependSlopeAB * (xpoint - midpointpAB.x)) + midpointpAB.y;
			System.out.println("y center: " + ypoint);
		}
		Point centerPoint = new Point(xpoint, ypoint);
		//Caculate the raidus using Pythagorean theorem
		Double radius =  Math.sqrt(Math.pow(centerPoint.x -p1.x, 2) + Math.pow(centerPoint.y - p1.y, 2));
		return new Circle(centerPoint, radius);
	}
	private static Double getPerpenSlope(Point p1, Point p2){
		if (p2.x - p1.x == 0  ){
			return  Double.POSITIVE_INFINITY;
		} 
		else if (p2.y - p1.y == 0){
			return 0.0;
		}
		else{
			return  -1 / ((p2.y - p1.y)/(p2.x - p1.x));
		}
	}
}