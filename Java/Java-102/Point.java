public class Point {
	public final double x;
	public final double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point translateX(double t) {
		return new Point(x + t, y);
	}
	
	public Point translateY(double t) {
		return new Point(x, y + t);
	}

    @Override

    public String toString(){
        return "(" + x + "," + y + ")";
    }
	public static double distance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}
	public static Point centerOfMass(Point[] points){
		double subtotalx = 0;
		double subtotaly = 0;
		for (int i = 0; i < points.length; i++) {
			subtotalx += points[i].x;
			subtotaly += points[i].y;
		}
		return new Point(subtotalx / points.length, subtotaly / points.length);
	}
	public static double angle(Point pt){
		double xVal = pt.x;
		System.out.println(pt.x);
		double yVal = pt.y;
		double angle = Math.toDegrees(Math.atan2(yVal, xVal));
		if (xVal == 0 && yVal == 0){
			return 0.0;
		}
		if (angle < 0){
			return angle =+ 360.0;
		}
		else{
			return 0.0;
		}
	}
}
