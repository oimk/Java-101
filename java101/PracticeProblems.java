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
}