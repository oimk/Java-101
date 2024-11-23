public class Main {
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
    }
}