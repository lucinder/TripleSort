/**
@author Lucinder
@preconditions Array "elements" consists of ints (I don't remember how to implement the T datatype) and no indices contain null
@postconditions Array "elements" consists of ints sorted in ascending order
A sort that improves on the basic bubblesort by percolating two elements at a time!
This also causes passive sorting of smaller subsections of the array due to a third comparison,
so less "runs" through the array are necessary to achieve a sorted result.
**/
public class TripleSort{
   public static void main(String[] args){ // runs sort over an array of 50 ints
      int[] elements = new int[50];
      for(int i = 0; i < elements.length; i++){ // fill array with random ints 0-50 inclusive
         elements[i] = (int)(Math.random()*51);
      }
      System.out.println("Unsorted array: " + arrayToStr(elements)); // print array pre sort
      tripleSort(elements);
      System.out.println("Sorted array: " + arrayToStr(elements)); // print array post sort
   }
   public static void tripleSort(int[] elements){ // my sort method- uses 3 main comparison operations per element per run
      int mid = elements.length / 2;
      while (!isSorted(elements)){ // continue runs until array is sorted (CANNOT last indefinitely)
         for(int i = 0; i < elements.length; i++){ // loop through array
            if((i < mid && elements[i] > elements[mid]) || (i > mid && elements[i] < elements[mid])){ // compare i + middle element, swap if out of order
               swap(elements, i,mid);
            }
            if(i < elements.length-1 && elements[i] > elements[i+1]){ // compare i and next element, swap if out of order
               swap(elements,i,i+1);
            }
            if(i > 0 && elements[i] < elements[i-1]){ // compare i and previous element, swap if out of order
               swap(elements,i,i-1);
            }
         }
      }
   }
   private static boolean isSorted(int[] elements){ // checks if the array is sorted
      for (int i = 0; i < elements.length - 1; i++){
         if(elements[i] > elements[i+1]){
            return false;
         }
      }
      return true;
   }
   private static void swap(int[] elements, int a, int b){ // swaps two elements in an array
      int temp = elements[a];
      elements[a] = elements[b];
      elements[b] = temp;
   }
   private static String arrayToStr(int[] elements){// creates a string in format "[e1, e2, e3, e4...]" from array
      String arrString = "[";
      for(int element: elements){ // add spacing between elements
         arrString += element + ", ";
      }
      arrString = arrString.substring(0,arrString.length() - 2); // cut off last ", "
      arrString += "]";
      return arrString;
   }
}
