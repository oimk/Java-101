public class PracticeProblems {
	static int countOccurrences(int[] arr, int n){
        int occurence = 0;
        for (int i = 0; i < arr.length; i++){
            if (n == arr[i]){
                occurence ++;
            }
        }
    return occurence;
    }
    static int[] Reversearr(int[] arr){
        int nt = arr.length;
        int[] newarr = new int[nt];
        for (int t = 0; t < arr.length; t++){
            nt --; 
            newarr[t] = arr[nt];
        }
    return newarr;
    }
}
