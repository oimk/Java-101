public class Main {
    public static void main(String[] args) {
        int[][] array = {
            {1, 2, 3},
            {4, 5, 6, 7},
            {8, 9}
        };
        int[] arty = {1,2,3,4,5,6,7,8};
        System.out.println(PracticeProblems.countOccurrences(new int[]{1, 2, 2, 4, 2, 2, 10},  2));
        System.out.println(PracticeProblems.sumGrid(array));
        PracticeProblems.Reversearr(arty);
        PracticeProblems.fib(5);
    }
}

