
/**
 * Write a description of class SelectionSort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Sorts
{

    public static int[] selectionSort(int[] array)
    {
        for(int i = 0; i<array.length; i++)
        {
            int min = array[i];
            int locationMin = i;
            for(int j = i; j<array.length; j++)
            {
                if(array[j]<min)
                {
                    min=array[j];
                    locationMin = j;
                }
            }
            
            array[locationMin]=array[i];
            array[i]=min;
        }
        return array;
    }
    
    public static int[] insertionSort(int[] array)
    {
        for (int i = 1; i < array.length; i++) 
        {
            for (int j = i; j > 0; j--) 
            {
                if (array[j - 1] > array[j]) 
                {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }
    
    public static int[] bubbleSort(int[] array)
    {
        
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
        
        System.out.println(Arrays.toString(selectionSort(test1)));
        System.out.println(Arrays.toString(selectionSort(test2)));
        System.out.println(Arrays.toString(selectionSort(test3)));
        System.out.println(Arrays.toString(selectionSort(test4)));
        System.out.println(Arrays.toString(selectionSort(test5)));
        
        System.out.println(Arrays.toString(insertionSort(test1)));
        System.out.println(Arrays.toString(insertionSort(test2)));
        System.out.println(Arrays.toString(insertionSort(test3)));
        System.out.println(Arrays.toString(insertionSort(test4)));
        System.out.println(Arrays.toString(insertionSort(test5)));
    }
}
