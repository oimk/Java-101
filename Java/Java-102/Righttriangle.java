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
    public boolean isInside(Point p){
        if (corner.x < p.x && p.x <  corner.x + base && corner.y < p.y &&  p.y < corner.y + height){
            System.out.println("TRUE");
            double hypoY = (height / base) * (p.x - corner.x) + corner.y;
            return p.y < hypoY;
    }
    else {
        return false;
    }
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
}