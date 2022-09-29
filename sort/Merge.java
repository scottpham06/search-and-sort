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
   public static int[] sort(int[] arr, int start, int end) {
    // Your algorithm goes here!
    int mid = (start + end) /2;
    if (start < end) {
        sort (arr, start, mid);
        sort (arr, mid +1, end);
    }
    
    int i = 0, first = start, last = mid +1;
    int [] tmp = new int [end - start + 1];
    
    while (first <= mid && last <= end) {
        if (arr[first] < arr[last] ){
            tmp [i++] = arr[first++];
        }
        else {
            tmp [i++] = arr[last++];
        }
    }
    while (first <= mid) { 
        tmp[i++] = arr[first++]; 
    }
    while (last <= end) { 
        tmp[i++] = arr[last++]; 
    } 
    i = 0;
    while (start <= end) { 
        arr[start++] = tmp[i++]; 
    }

    return arr;
  }
  
  public static void main(String[] args) {
    int[] arr = {53,85,93,25,39,27,42,5,24,45,33,51,5,80,4,7,91,
      31,66,71,32,19,79,58,61,82,89,63,7,4,50,10,48,24,75,19,22,
      73,54,51,25,33,20,52,79,97,70,54,63,49};    
    
    // Test the sort
    testSort(sort(arr, 0, arr.length-1));
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
