import java.util.ArrayList;

public class Square implements Shape{
	public final Point corner;
	public final double sideLength;

	/**
	* @param corner The bottom left corner of the square
	* @param sideLength
	*/
	public Square(Point corner, double sideLength) {
		this.corner = corner;
		this.sideLength = sideLength;
	}
    @Override
    public double area() {
		return Math.pow(sideLength, 2);
	}
	
	public double perimeter() {
		return sideLength * 4;
	}
	
	/** 
	* @return Whether point p is inside of the square.
	*/
	public boolean isInside(Point p) {
		double xDist = p.x - corner.x;
		double yDist = p.y - corner.y;
		return 0 < xDist && xDist < sideLength &&
			   0 < yDist && yDist < sideLength;
	}

	/** 
	* @return Whether point p part of/on the border of the square.
	*/
	public boolean isOn(Point p) {
		double xDist = p.x - corner.x;
		double yDist = p.y - corner.y;
        return (0 == xDist || xDist == sideLength) &&
			   (0 == yDist || yDist == sideLength);
	}
	
	/** 
	* @param x How much to translate the sqaure by in the + x direction.
	* @param y How much to translate the squarer by in the + y direction.
	* @return The sqaure that results from the translation.
	*/
	public Square translate(double x, double y) {
		return new Square(corner.translateX(x).translateY(y), sideLength);
	}

	/** 
	* @return The sqaure that results from scaling the side length and maintaining the bottom left corner
	*/
	public Square scale(double k) {
		return new Square(corner, sideLength * k);
	}
    /* Added Arraylist as return types as orginial type only returns array string and not the values in the array.
     * Requires Forloop in main function to get values, arraylist makes it more clean.
     */
    public  ArrayList<String> corners() {
        ArrayList<String> arr = new ArrayList<>();
		Point[] corners = {new Point(corner.x, corner.y + sideLength), 
            new Point(corner.x + sideLength, corner.y + sideLength),
            new Point(corner.x + sideLength , corner.y),
            new Point(corner.x, corner.y)};
        for (Point p : corners) {
            arr.add("(" + p.x + "," + p.y + ")");
        }
        return arr;
	}

	@Override
	public String toString() {
		return "(corner: " + corner + "; side length: " + sideLength + ")";
	}
    
}