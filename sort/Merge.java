package sort;

import java.util.Arrays;


/**
 * Write a description of class Merge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Merge
{

    /**
     * Returns the sorted array
     */
    public static int[] sort(int[] arr) {
        // Your algorithm goes here!
        int N = arr.length;

        if (N <=1) {
            return arr;
        }

        int middle = N/2;
        
        int [] left = new int[middle];
        int [] right = new int[N - middle];
        
        for(int i = 0; i<middle; i++) {
            left[i] = arr[i];
        }
        
        for(int i = middle; i<N; i++) {
            right[i- middle] = arr[i];
        }

        sort(left);
        sort(right);
        
        Merge(arr, left, right);

        
        

        return arr;
    }
    
    public static void Merge(int[] arr, int[]left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;
        
        int i = 0, j=0, k=0;
        
        while(i < leftSize && j < rightSize) {
            if(left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while(i< leftSize) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j < rightSize) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
    

    public static void main(String[] args) {
        int[] arr = {53,85,93,25,39,27,42,5,24,45,33,51,5,80,4,7,91,
                31,66,71,32,19,79,58,61,82,89,63,7,4,50,10,48,24,75,19,22,
                73,54,51,25,33,20,52,79,97,70,54,63,49};    

        // Test the sort
        testSort(sort(arr));
    }

    public static void testSort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                System.out.println("FAIL at index "+i);
                System.out.println(Arrays.toString(arr));
                return;
            }
        }
        System.out.println("SUCCESS!");
    }

}
