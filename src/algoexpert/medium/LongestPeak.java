package algoexpert.medium;

/**
 * Write a function that takes in an array of integers and returns the length of the longest peak in the array.
 * a peak is defined as adjacent integers in the array that area strictly increasing until they reach a highest value in the peak
 * at least three number to form a peak.
 * in other words it can be seen as sequences numbers is first increase then peak then last decrease
 */
public class LongestPeak {

    public int longestMountain(int[] A) {

        int i = 0;

        int j = A.length-1;

        boolean increasing = false;

        int largestMiountain = 0;

        int currentLength = 0 ;

        boolean isValid = false;

        while(i < j){

            if(i != 0 && A[i-1] < A[i]){
                currentLength = 2;
            }else{
                currentLength = 1;
            }

            while(i + 1 < j && A[i] < A[i+1]){
                increasing = true;

                currentLength++;
                i++;
            }

            while(i + 1 <= j && A[i] > A[i+1] && increasing){
                isValid = true;
                currentLength++;
                i++;
            }


            if(currentLength > largestMiountain &&  isValid){
                largestMiountain = currentLength;
            }

            currentLength = 0;

            increasing = false;

            isValid = false;

            i++;

        }
        return largestMiountain;
    }

        public static void main(String args[]){
            System.out.println(new LongestPeak().longestMountain(new int[]{0,1,2,3,4,5,4,3,2,1,0}));
        }
}
