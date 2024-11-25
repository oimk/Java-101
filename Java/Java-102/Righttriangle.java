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
        return base + height + Math.sqrt(Math.pow(base, 2) + Math.pow(height,2));
    }
    @Override
    public boolean isInside(Point p){
        Point A = new Point(corner.x, corner.y + height);
        Point B = new Point(corner.x + base, corner.y);
        // case 1: Upwards right to left Rightside up
        if (base >= 0){
            if (height > 0){
                if (p.x > corner.x && p.x < corner.x + base && p.y > corner.y && p.y < corner.y + height){
                    double hypoYVal = ((A.y - B.y)/(A.x - B.x)) * (p.x - corner.x) + corner.y;
                    return p.y < hypoYVal;
                }
            } // case 2: upwards left to right Upside dow
            else if(height < 0){
                if (p.x > corner.x && p.x < corner.x + base && p.y < corner.y && p.y > corner.y + height){
                    double hypoYVal = ((A.y - B.y)/(A.x - B.x)) * (p.x - corner.x) + corner.y;
                    return p.y > hypoYVal;
            }
            else {
                return false;
            }
            }
        }
        // case 3: Downards left to right Upside down
        if (base < 0){
            if (height < 0){
                if (p.x < corner.x && p.x > corner.x + base && p.y < corner.y && p.y > corner.y + height){
                    double hypoYVal = ((A.y - B.y)/(A.x - B.x)) * (p.x - corner.x) + corner.y;
                    return p.y > hypoYVal;
                }
            }
            //case 4: downwards left to right Rightside up
            else if (height > 0) {
                if (p.x < corner.x && p.x > corner.x + base && p.y < corner.y && p.y > corner.y + height){
                    double hypoYVal = ((A.y - B.y)/(A.x - B.x)) * (p.x - corner.x) + corner.y;
                    return p.y < hypoYVal;
                }
            }
        }
        // if everything else fails return false
        return  false;
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