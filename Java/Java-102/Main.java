
import java.util.ArrayList;

public class Main {
    static <T> String arrayToString(T[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length - 1; i++) {
            str += arr[i] + ", ";
        }
        return str + arr[arr.length - 1] + "]";
    }
    static double sumArea(Shape[] shapes) {
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.area();
        }
        return sum;
    }
    static ArrayList<Shape> scaleAll(Shape[] shapes, double k) {
        ArrayList<Shape> scaled = new ArrayList<>(shapes.length);
        for (Shape shape : shapes) {
            scaled.add(shape.scale(k));
        }
        return scaled;
    }
    public static void main(String[] args) {
        Point myPoint = new Point(3, 5);
        Point myPoint2 = new Point(0, 0);
        Point mypoint3 = new Point(1, -1);
        System.out.println("x:" + myPoint.x + " " + "y:" + myPoint.y);
        Point xTranslated = myPoint.translateX(3);
        Point Ytranslated = myPoint.translateY(-7);
        Point xytrans = myPoint.translateX(-4).translateY(-3);
        System.out.println("x transl:" + xTranslated);
        System.out.println("y transl:" + Ytranslated);
        System.out.println("xy transl:" + xytrans);
        System.out.println(Point.distance(myPoint, myPoint2));
        System.out.println(Point.angle(mypoint3));
// Grids
        Grid<Integer> grid = new Grid<>(5,0);
        grid.set(2,2,4);
        System.out.println(grid);
        Grid<String> StrGrid = new Grid<>(3,"a");
        StrGrid.set(0,0, "A");
        StrGrid.set(1,1, "A");
        StrGrid.set(2,2, "A");
        System.out.println(StrGrid.diagonal());
        System.out.println(Grid.maxSideLength());
// Arraylist
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<Boolean> condition = new ArrayList<>();
        ArrayList<Integer> intarr = new ArrayList<>();
        arr.add("Hello");
        arr.add("World");
        System.out.println(arr);
        arr.set(0, "Goodbye");
        System.out.println(arr);
        condition.add(true);
        condition.add("Hello".equals(arr.get(0)));
        condition.add(condition.get(0) || condition.get(1));
        System.out.println(condition);
        
//To string Array 
        String[] arrt = {"a", "b", "c", "d"};
        System.out.println(arrayToString(arrt));
        for (int i = 0; i < 50; i++) {
            intarr.add(0);
        }
        System.out.println(intarr);
        System.out.println(intarr.get(32));
// Shapes 
        Point center = new Point(0,0);
        Point C1 = new Point(0,1);
        Point C2 = new Point(1,0);
        Point C3 = new Point(-1,0);
        Circle unitC = new Circle(center, 1);
        System.out.println("Area of circle:" + unitC.area());
        System.out.println(unitC.translate(-5, 10).scale(3));
        Point corner = new Point(-1,-1);
        Square BSquare = new Square(corner, 5);
        System.out.println(BSquare.corners());
        Shape[] shapes = {new Circle(new Point(1.8, -20), 2),
             new Square(new Point(100, 2.1), 5.4),
             new Circle(new Point(4, 9.123), 98.32),
             new Square(new Point(-321, 0), 0.02)};
        System.out.println(sumArea(shapes));
        System.out.println(scaleAll(shapes, 10));
        System.out.println(Circle.fromPoints(C1, C2, C3));
    }
}