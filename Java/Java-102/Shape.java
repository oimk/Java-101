public interface Shape {
    public double area();
    // Returns scaling of shape to k.
    public Shape scale(double k);

    public double perimeter();

	/** 
	* @return Whether point p is inside of the shape.
	*/
	public boolean isInside(Point p);
	/** 
	* @return Whether point p part of/on the border of the shape.
	*/
	public boolean isOn(Point p);

	/** 
	* @param x How much to translate the shape by in the + x direction.
	* @param y How much to translate the shape by in the + y direction.
	* @return The shape that results from the translation.
	*/
	public Shape translate(double x, double y);
	
}
