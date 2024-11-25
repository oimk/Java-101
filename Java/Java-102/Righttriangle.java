public class Righttriangle implements Shape{
    public final Point corner; //Right angle corner of triangle 
    public final double base;
    public final double height;

    public Righttriangle(Point corner, double base, double height){
        this.corner = corner;
        this.base = base;
        this.height = height;
    }
    @Override
    public double area() {
		return 0.5 * base * height;
	}
    @Override
    public Righttriangle scale(double k){
        return new Righttriangle(corner, base * k, height *k);
    }
    @Override
    public double perimeter(){
        return 0.5 * base * height;
    }
    @Override
    public boolean isInside(Point p) {
        // Calculate points A and B based on base and height
        Point A = new Point(corner.x, corner.y + height);
        Point B = new Point(corner.x + base, corner.y);
    
        // Calculate the slope of the hypotenuse
        double slope = (double)(A.y - B.y) / (A.x - B.x);
    
        // Case 1: Triangle upwards, right to left (base > 0, height > 0)
        if (base > 0 && height > 0) {
            if (p.x > corner.x && p.x < corner.x + base && p.y > corner.y && p.y < corner.y + height) {
                double hypoYVal = slope * (p.x - corner.x) + corner.y;
                return p.y < hypoYVal;
            }
        }
    
        // Case 2: Triangle upwards, left to right (base > 0, height < 0)
        else if (base > 0 && height < 0) {
            if (p.x > corner.x && p.x < corner.x + base && p.y < corner.y && p.y > corner.y + height) {
                double hypoYVal = slope * (p.x - corner.x) + corner.y;
                return p.y > hypoYVal;
            }
        }
    
        // Case 3: Triangle downwards, left to right (base < 0, height < 0)
        else if (base < 0 && height < 0) {
            if (p.x < corner.x && p.x > corner.x + base && p.y < corner.y && p.y > corner.y + height) {
                double hypoYVal = slope * (p.x - corner.x) + corner.y;
                return p.y > hypoYVal;
            }
        }
    
        // Case 4: Triangle downwards, right to left (base < 0, height > 0)
        else if (base < 0 && height > 0) {
            if (p.x < corner.x && p.x > corner.x + base && p.y < corner.y && p.y > corner.y + height) {
                double hypoYVal = slope * (p.x - corner.x) + corner.y;
                return p.y < hypoYVal;
            }
        }
    
        // If none of the conditions match, return false
        return false;
    }
    
    @Override 
    public boolean isOn(Point p){
        double xDist = p.x - corner.x;
		double yDist = p.y - corner.y;
        if (0 <= xDist && xDist <= xDist + base){
           return true;
        }
        else if (0 <= yDist && yDist <= yDist + height){
            return true; 
        }
        else return p.y == (height/base) * (p.x - corner.x) + corner.y;
    }
    @Override
    public Shape translate(double x, double y){
        return new Righttriangle(corner.translateX(x).translateY(y), base, height);
    }
    @Override 
    public String toString(){
        return "(" + "Corner:"+ corner + "; Base: " + base + "; Height: " + height; 
    }
}