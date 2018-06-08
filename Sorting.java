import java.io.*;

// Sorting - Implement two types of sorting algorithms: Merge sort and bubble sort.
class Sorting {

  // An implementation of mergesort.
  static int[] mergesort(int[] a) {
    // Need to use an auxiliary function to call this.
    int len = a.length;

    // if the array is size 1, then return the array.
    if(len == 1) {
      return a;
    }

    int[] sorted = new int[len];

    // else split up the array into two, and sort each half.
    int half = len / 2;

    int[] b = new int[half];
    for(int i = 0; i < half; i++) {
      b[i] = a[i];
    }

    int[] c = new int[len-half];
    for(int i = 0; i < len-half; i++) {
      c[i] = a[i+half];
    }

    b = mergesort(b);
    c = mergesort(c);

    sorted = merge(b, c);

    return sorted;
  }

  // A function used to merge two arrays together.
  static int[] merge(int[] a, int[] b) {

    int[] sorted = new int[a.length + b.length];
    int alen = 0;
    int blen = 0;
    int curr = 0;

    while(alen < a.length && blen < b.length) {

      // Add the lower value to the sorted array, and increment the pointer to that array.
      if(a[alen] <= b[blen]) {
        sorted[curr] = a[alen];
        alen++;
        curr++;
      } else {
        sorted[curr] = b[blen];
        blen++;
        curr++;
      }
    }

    // Add the end of the still not empty array.
    if(alen == a.length) {
      while(blen < b.length) sorted[curr++] = b[blen++];
    } else {
      while(alen < a.length) sorted[curr++] = a[alen++];
    }

    return sorted;
  }

  // A function implementing selectionsort.
  static int[] selectionsort(int[] a) {

    // Set up a temporary int which will hold array values.
    int temp;

    // Set up an int which will hold the min
    int min;

    // Set up a pointer that holds the position up to which the array is sorted.
    int idx = 0;

    while (idx < a.length) {
      min = a[idx];

      for(int i = idx; i < a.length; i++) {
        if(a[i] < min) {
          temp = a[idx];
          a[idx] = a[i];
          a[i] = temp;
        }
      }

      idx++;
    }

    return a;
  }

  // A function implementing bubble sort.
  static int[] bubblesort(int[] a) {

    // Set a boolean to indicate whether a whole pass has gone through without any swaps
    boolean whole = false;
    boolean swap = false;

    // Set a temporary int which will hold array values for swap.
    int temp;

    while(!whole) {

      for(int i = 0; i < a.length-1; i++) {
        if(a[i] > a[i+1]) {
          temp = a[i];
          a[i] = a[i+1];
          a[i+1] = temp;
          swap = true;
        }
      }

      if(!swap) whole = true;
      // Reset swap
      swap = false;
    }

    return a;
  }

  // Test the applications of merge sort and bubble sort.
  public static void main(String args[]) {

    // Test the mergesort function.
    int[] sortthis = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    int[] sortthis2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    int[] sortthis3 = {9, 8, 7, 6, 5, 4, 3, 2, 1};

    System.out.print("Trying to sort this array: ");
    for(int i = 0; i < sortthis.length; i++) {
      System.out.print(sortthis[i] + " ");
    }
    System.out.println();

    int[] sorted = mergesort(sortthis);

    System.out.print("Test of the mergesort method: ");
    for(int i = 0; i < sorted.length; i++) {
      System.out.print(sorted[i] + " ");
    }
    System.out.println();

    sorted = selectionsort(sortthis2);

    System.out.print("Test of selection sort: ");
    for(int i = 0; i < sorted.length; i++) {
      System.out.print(sorted[i] + " ");
    }
    System.out.println();

    sorted = bubblesort(sortthis3);

    System.out.print("Test of bubble sort: ");
    for(int i = 0; i < sorted.length; i++) {
      System.out.print(sorted[i] + " ");
    }
    System.out.println();
  }
}
