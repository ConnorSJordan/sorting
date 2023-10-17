
/**
 * Write a description of class SelectionSort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sorting {
    
    static long comparisons;
    static long assignments;
    
    // Sorts an array of itegers using the selection sort algorithm. 
    public static void selectionSort(int[] array) {
        long comparisons = 0;
        long swaps = 0;
        
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int locationMin = i;
            
            for (int j = i + 1; j<array.length; j++) {
                comparisons++;
                
                if (array[j] < min) {
                    min = array[j];
                    locationMin = j;
                }
            }
            
            if(array[i] != array[locationMin]) {
                swaps++;
                array[locationMin] = array[i];
                array[i] = min;
            }
        }
        
        System.out.print(", " + comparisons + ", " + swaps);
    }
    
    // Sorts an array of integers using the insertion sort algorithm.
    public static void insertionSort(int[] array) {
        long comparisons = 0;
        long assignments = 0;
        
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            
            while (j != 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                assignments++;
                j--;
                comparisons++;
            }
            
            array[j] = temp;
            assignments++;
        }
        
        System.out.print(", " + comparisons + ", " + assignments/3);
    }
    
    // Sorts an array of integers using the bubble sort algorithm.
    public static void bubbleSort(int[] array) {
        long comparisons = 0;
        long swaps = 0;
        
        for (int i = 0; i < array.length; i++) {
            boolean sorted = true;
            
            for (int j = 0; j < array.length - 1; j++) {
                comparisons++;
                if (array[j] > array[j + 1]) { 
                    sorted = false;
                    int temp = array[j];
                    
                    array[j] = array[j + 1];
                    array[j + 1] = temp; 
                    /* Swaps the bigger number(j) with 
                    * the smaller number(i)*/
                    swaps++;
                }
            }
            if(sorted) {
                break;
            }
        }
        
        System.out.print(", " + comparisons + ", " + swaps);
    }
    
    // Sorts an array of integers using the Merge sort Algorithm.
    public static void mergeSort(int[] array) {
        comparisons = 0;
        assignments = 0;
        mergeSort(array, 0, array.length -1);
        System.out.print(", " + comparisons + ", " + assignments/3);
    }
    
    // Recursivley splits the array in half then calls the merge method
    public static void mergeSort(int[] array, int beg, int end) {
        if (beg == end) {
            return ;
        } else if (end-beg == 2) {
            comparisons++;
            if(array[beg]>array[end]) {
                int temp = array[beg];
                
                array[beg] = array[end];
                array[end] = temp;
                
                assignments += 3;
            }
        } else {
            int midpoint = (beg + end) / 2;
            
            mergeSort(array, beg, midpoint);
            mergeSort(array, midpoint + 1, end);
            merge(array, beg, midpoint, end);
        }
    }
    
    // Sorts the split arrays passed in through the mergeSort method
    public static void merge(int[] array, int beg, int mid, int end) {
        int[] sorted = new int[end - beg + 1];
        int firstMark = beg;
        int secondMark = mid + 1;
        int location = 0;
        
        // Traverses both arrays at the same time
        while (firstMark <= mid && secondMark <= end) {
            comparisons++;
            if(array[firstMark] < array[secondMark]) {
                sorted[location] = array[firstMark];
                assignments++;
                firstMark++;
                location++;
            } else {
                sorted[location] = array[secondMark];
                assignments++;
                secondMark++;
                location++;
            }
        }
        
        // Places the rest of the unfinished array into its spot
        while (firstMark <= mid) {
            sorted[location] = array[firstMark];
            assignments++;
            firstMark++;
            location++;
        }
        
        while (secondMark <= end) {
            sorted[location] = array[secondMark];
            assignments++;
            secondMark++;
            location++;
        }
        
        // Copies the array values into a new array
        for (int i = 0; i < end + 1 - beg; i++) {
            array[beg + i] = sorted[i];
        }
    }
}
