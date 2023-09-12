
/**
 * Write a description of class SelectionSort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Sorting
{

    public static void selectionSort(int[] array)
    {
        long comparisons = 0;
        long swaps = 0;
        for(int i = 0; i<array.length; i++)
        {
            int min = array[i];
            int locationMin = i;
            for(int j = i+1; j<array.length; j++)
            {
                comparisons++;
                if(array[j]<min)
                {
                    min=array[j];
                    locationMin = j;
                }
            }
            swaps++;
            
            array[locationMin]=array[i];
            array[i]=min;
        }
        System.out.print(", " + comparisons + ", " + swaps);
    }
    
    public static void insertionSort(int[] array)
    {
        long comparisons = 0;
        long assignments = 0;
        for (int i = 1; i < array.length; i++) 
        {
            int temp = array[i];
            int j = i;
            while(j!= 0 && temp<array[j-1]) 
            {
                array[j] = array[j-1];
                assignments++;
                j--;
                comparisons++;
            }
            array[j] = temp;
            assignments++;
        }
        System.out.print(", " + comparisons + ", " + assignments/3);
    }
    
    public static void bubbleSort(int[] array)
    {
        long comparisons = 0;
        long swaps = 0;
        for(int i = 0; i<array.length; i++)
        {
            for(int j = 0; j<array.length-1; j++)
            {
                comparisons++;
                if(array[j]>array[j+1])
                {
                    int temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    swaps++;
                }
            }
        }
        System.out.print(", " + comparisons + ", " + swaps);
    }
    
    static long comparisons;
    static long assignments;
    
    public static void mergeSort(int[] array)
    {
        comparisons = 0;
        assignments = 0;
        mergeSort(array, 0, array.length -1);
        System.out.print(", " + comparisons + ", " + assignments/3);
    }
    
    public static void mergeSort(int[] array, int beg, int end)
    {
        
        if(beg == end)
        {
            return ;
        }
        else
        {
            int midpoint = (beg+end)/2;
            mergeSort(array, beg, midpoint);
            mergeSort(array, midpoint+1, end);
            merge(array, beg, midpoint, end);
        }
    }
    
    public static void merge(int[] array, int beg, int mid, int end)
    {
        int[] sorted = new int[end-beg+1];
        int firstMark = beg;
        int secondMark = mid+1;
        int location = 0;
        while(firstMark<=mid && secondMark<=end)
        {
            comparisons++;
            if(array[firstMark]<array[secondMark])
            {
                sorted[location] = array[firstMark];
                assignments++;
                firstMark++;
                location++;
            }
            else
            {
                sorted[location] = array[secondMark];
                assignments++;
                secondMark++;
                location++;
            }
        }
        while(firstMark<=mid)
        {
            sorted[location] = array[firstMark];
            assignments++;
            firstMark++;
            location++;
        }
        while(secondMark<=end)
        {
            sorted[location] = array[secondMark];
            assignments++;
            secondMark++;
            location++;
        }
        
        for(int i = 0; i < end+1-beg; i++)
        {
            array[beg+i]=sorted[i];
        }
    }

    public static void test()
    {
        int[] test1 = {1, 2, 3, 4 ,5};
        int[] result1 = {1, 2, 3, 4, 5};
        int[] test2 = {5, 4, 3, 2, 1};
        int[] result2 = {1, 2, 3, 4, 5};
        int[] test3 = {-1, -2, -3, -4, -5};
        int[] result3 = {-5, -4, -3, -2, -1};
        int[] test4 = {0, 6, 5, -3, 4, -16};
        int[] result4 = {-16, -3, 0, 4, 5, 6};
        int[] test5 = {0, 0, 0, 5, -1};
        int[] result5 = {-1, 0, 0, 0, 5};
        
        /*System.out.println(Arrays.toString(selectionSort(test1)));
        System.out.println(Arrays.toString(selectionSort(test2)));
        System.out.println(Arrays.toString(selectionSort(test3)));
        System.out.println(Arrays.toString(selectionSort(test4)));
        System.out.println(Arrays.toString(selectionSort(test5)));*/
        
        /*System.out.println(Arrays.toString(insertionSort(test1)));
        System.out.println(Arrays.toString(insertionSort(test2)));
        System.out.println(Arrays.toString(insertionSort(test3)));
        System.out.println(Arrays.toString(insertionSort(test4)));
        System.out.println(Arrays.toString(insertionSort(test5)));*/
        
        /*System.out.println(Arrays.toString(bubbleSort(test1)));
        System.out.println(Arrays.toString(bubbleSort(test2)));
        System.out.println(Arrays.toString(bubbleSort(test3)));
        System.out.println(Arrays.toString(bubbleSort(test4)));
        System.out.println(Arrays.toString(bubbleSort(test5)));
        
        mergeSort(test1);
        System.out.println(Arrays.toString(test1));
        mergeSort(test2);
        System.out.println(Arrays.toString(test2));
        mergeSort(test3);
        System.out.println(Arrays.toString(test3));
        mergeSort(test4);
        System.out.println(Arrays.toString(test4));
        mergeSort(test5);
        System.out.println(Arrays.toString(test5));*/
    }
}
