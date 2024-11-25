
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
    public static void returnAll(LibaryItems[] items) {
        for (LibaryItems Items: items) {
            Items.returnItem();
        }
    }
    public static ArrayList<LibaryItems> availableItems(LibaryItems[] items) {
        ArrayList<LibaryItems> AvilableItm = new ArrayList<>();
        for (LibaryItems Items : items){
          if (Items.available()){
           AvilableItm.add(Items);
        }  
    }
    return AvilableItm; 
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
        Point center = new Point(3,2);
        Point C1 = new Point(-0.32,-2.33);
        Point C2 = new Point(-2.50,0.42);
        Point C3 = new Point(-7.20,-6.74);
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
        Righttriangle Tri = new Righttriangle(center, 5, 5);
        Point C4 = new Point(2,2);
        Point C5 = new Point(1,1);
        Point C6 = new Point(2,1);
        System.out.println(Tri.isInside(C4)); 
        System.out.println(Tri.isInside(C5));  
        System.out.println(Tri.isInside(C6));
        // Inheritance 
        A a = new A(12.3, 430);
        B b = new B(-12.31, "hello");
        a.method1();
        b.method1();
        b.method2();
        A bInDisguise = new B(1002.013, "world");
        bInDisguise.method2();
        // Libary 
        LibaryItems[] items = new LibaryItems[10];

        // Adding LibraryItems objects to the array
        items[0] = new book("1984", "B001", "George Orwell", 328);
        items[1] = new book("Pride and Prejudice", "B002", "Jane Austen", 279);
        items[2] = new book("The Catcher in the Rye", "B003", "J.D. Salinger", 277);
        items[3] = new book("Moby Dick", "B004", "Herman Melville", 635);
        items[4] = new book("The Great Gatsby", "B005", "F. Scott Fitzgerald", 180);
        items[5] = new book("War and Peace", "B006", "Leo Tolstoy", 1225);
        items[6] = new book("To Kill a Mockingbird", "B007", "Harper Lee", 281);
        items[7] = new book("The Odyssey", "B008", "Homer", 500);
        items[8] = new book("The Lord of the Rings", "B009", "J.R.R. Tolkien", 1216);
        items[9] = new book("Catch-22", "B010", "Joseph Heller", 453);
        items[0].checkOut(); 
        items[2].checkOut();  
        items[4].checkOut();
        System.out.println(availableItems(items));
    }
}