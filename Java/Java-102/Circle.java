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
		System.out.println("Midpoint AB: " + midpointpAB);
		Point midpointpBC = new Point((p2.x + p3.x)/2, (p2.y + p3.y)/2);
		System.out.println("Midpoint BC: " + midpointpBC);
		// Slope of the prependicular lines of AB and BC
		Double PrependSlopeAB;
		if (p2.x - p1.x == 0){
			PrependSlopeAB = 0.0;
		} 
		else{
			PrependSlopeAB = -1 /((p2.y - p1.y)/(p2.x - p1.x));
		}
		System.out.println("Slope AB: " +PrependSlopeAB);
		Double PrependSlopeBC;
		if (p3.x - p2.x == 0){
			PrependSlopeBC = 0.0;
		} 
		else{
			PrependSlopeBC = -1 /((p3.y - p2.y)/(p3.x - p2.x));
		}
		System.out.println("Slope BC: " + PrependSlopeBC);
		// Caculate the circumcenter using system of equations
		Double xpoint = ((PrependSlopeBC * midpointpBC.x) - (PrependSlopeAB * midpointpAB.x) + (midpointpBC.y - midpointpAB.y)) / (PrependSlopeAB - PrependSlopeBC);
		System.out.println("x center: " +xpoint);
		Double ypoint = (PrependSlopeAB * (xpoint - midpointpAB.x)) + midpointpAB.y;
		System.out.println("y center: " +ypoint);
		Point centerPoint = new Point(xpoint, ypoint);
		//Caculate the raidus using Pythagorean theorem
		Double Subradius = Math.pow((centerPoint.x - midpointpAB.x), 2) + Math.pow((centerPoint.y - midpointpAB.y), 2);
		System.out.println("subradius: " + Subradius);
		Double radius = Math.sqrt(Subradius);
		return new Circle(centerPoint, radius);
	}
	
}