import java.util.ArrayList;

public class MyMain {
    // **************************
    // In-class Practice Problems
    // **************************

    // Write a method that uses recursion to search for a value in
    // an array using binary search!

    // Examples:
    // binarySearch([5, 2, 4, 3], 4) => true
    // binarySearch([6, 7, 1, 2, 8], 5) => false

    // Wrapper Method
    public static boolean binarySearch(int[] arr, int num) {
        return binarySearchTR(arr, num, 0, arr.length-1);
    }

    // Tail recursive method:
    public static boolean binarySearchTR(int[] arr, int num, int lowerBound, int upperBound) {
        int mid = lowerBound + ((upperBound - lowerBound) / 2);
        if(upperBound < lowerBound){
            return false;
        }
        else if(arr[mid] > num){
            return binarySearchTR(arr, num, lowerBound, mid-1);
        }
        else if(arr[mid] < num){
            return binarySearchTR(arr, num, mid+1, upperBound);
        }
        else {
            return true;
        }
    }





    // ********************
    // Methods for homework:
    // ********************

    // This method does not use recursion!

    // Write a method takes two sorted arrays as input and combines them
    // into one large combined arrays.

    // Here is the pseudocode for merge:
    // * Create a new big output array
    // * Start at the beginning of both input arrays
    // * Take the smaller of the two values and add it to the output array
    // * Repeat until we’ve gone through all the values in one of the arrays
    // * Copy the remaining values from the other array into the output array

    // Here's an example of how it looks in action:
    // arr1 = [1, 4, 5, 8]       arr2 = [2, 6, 7, 10]      output = [                         ]
    //         ^                         ^                           ^
    //     idx1 = 0                  idx2 = 0                   outputIdx = 0

    // The current value in arr1 (1) is smaller than the current value
    // in arr2 (2). So we copy 1 into the output array. Then we increment
    // both idx1 and outputIdx:

    // arr1 = [1, 4, 5, 8]       arr2 = [2, 6, 7, 10]      output = [1,                       ]
    //            ^                      ^                              ^
    //        idx1 = 1               idx2 = 0                      outputIdx = 1

    // The current value in arr1 (4) is larger than the current value
    // in arr2 (2). So we copy 2 into the output array. Then we increment
    // both idx2 and outputIdx:

    // arr1 = [1, 4, 5, 8]       arr2 = [2, 6, 7, 10]      output = [1, 2,                     ]
    //            ^                         ^                              ^
    //        idx1 = 1                  idx2 = 1                      outputIdx = 2

    // We continue on until one of the arrays is empty
    // Then we need to copy the rest of the array

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;

        for (int k = 0; k < arr1.length + arr2.length; k++) {
            if (j == arr2.length) {
                arr3[k] = arr1[i];
                i++;
            }
            else if (i == arr1.length) {
                arr3[k] = arr2[j];
                j++;
            }
            else if (arr1[i] < arr2[j]) {
                arr3[k] = arr1[i];
                i++;
            }
            else if (arr1[i] > arr2[j]) {
                arr3[k] = arr2[j];
                j++;
            }
            else{
                arr3[k] = arr1[i];
                arr3[k + 1] = arr2[j];
                i++;
                j++;
                k++;
            }
        }
        return arr3;
    }
}
