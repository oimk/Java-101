public class PracticeProblems {
    static int countOccurrences(int[] arr, int n){
        int occurrence = 0;
        for (int i = 0; i < arr.length; i++){
            if (n == arr[i]){
                occurrence ++;
            }
        }
    return occurrence;
    }
    static void Reversearr(int[] arr){
        int lengtharr = arr.length;
        int[] newarray = new int[lengtharr];
        for (int i = 0; i < arr.length;i++){
            newarray[i] = arr[lengtharr - 1];
            lengtharr --;
            System.out.print(newarray[i] + ",");
        }
    }
    static int sumGrid(int[][] arr){
        int sum = 0;
        for (int a = 0; a < arr.length; a++){
            for (int b = 0; b < arr[a].length; b++){
                sum = arr[a][b] + sum;
            }
        }
        return sum;
    }
}


