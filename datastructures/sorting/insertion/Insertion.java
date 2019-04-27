/**
 * The insertion class implemention for sorting an array using insertion sort
 * The implemention makes ~ 1/2 n^2 compares and exchanges in the worst case
 * The sorting algorithm is stable and uses O(1) space
 */
import java.util.Comparator;
public class Insertion<T> {
	
	public Insertion() {}
	
	/**
 	 * Rearranges the array in ascending order using natural order
 	 */
	public void sort(Comparable<T>[] arr)
	{
		int n = arr.length;
		for (int i = 1; i < n; i++)
		{
			for (int j = i; j > 0 && less(arr[j], arr[j-1]); j--)
				exchange(arr, j, j - 1);
			assert isSorted(arr, 0, i);		
		}
		assert isSorted(arr);
	}
	/**
 	 * Rearrages the subarray from low to high in ascending order
	 * using the natural order
 	 */
	public void sort(Comparable<T>[] arr, int low, int high)
	{
		for (int i = low + 1; i < high; i ++)
		{
			for (int j = i; j > low && less(arr[j], arr[j-1]); j--)
				exchange(arr, j, j -1);
		}
		assert isSorted(arr, low, high);
	}
	
	/**
 	 * Rearranges the array in ascending order, using a comparator
 	 */
	public void sort(Object[] arr, Comparator<T> comparator)
	{
		int n = arr.length;
		for (int i = 1; i < n; i++)
		{
			for (int j = i; j > 0 && less(arr[j], arr[j-1], comparator); j--)
				exchange(arr, i, j-1);
			assert isSorted(arr, 0, i, comparator); 
		}
		assert isSorted(arr, comparator);
	}
	
	/**
	 * Rearranges the subarry from low to high in ascending order using a comparator
	 */
	public void sort(Object[] arr, int low, int high, Comparator<T> comparator)
	{
		for (int i = low + 1; i < high; i++)
			for (int j = i; j > low && less(arr[j], arr[j-1], comparator); j--)
				exchange(arr, j, j -1);
		assert isSorted(arr, low, high, comparator);
	}
	
	/**
	 * Return a permutation that gives the elements in the array in ascending order
	 * do not change the original of the array
	 */
	public int[] indexSort(Comparable<T>[] arr)
	{
		int n = arr.length;
		int[] index = new int[n];
		for (int i = 0; i < n; i++)
			index[i] = i;
		for (int i = 0; i < n; i++)
			for (int j = i; j > 0 && less(arr[index[j]], arr[index[j-1]]); j--)
				exchange(index, j, j - 1);
		return index;
	}

	/***************************************************************************
    	*  Sorting functions.
    	***************************************************************************/
	
	/**
	 * check if v < w
	 */
	@SuppressWarnings("unchecked")
	private boolean less(Comparable<T> v, Comparable<T> w)
	{
		return v.compareTo((T) w) < 0;
	}
	
	/**
	 * check if v < w
	 */
	@SuppressWarnings("unchecked")
	private boolean less(Object v, Object w, Comparator<T> comparator)
	{
		return comparator.compare((T) v, (T) w) < 0;
	}
	
	/**
	 * exchange value from i to j
	 */
	private void exchange(Object[] arr, int i, int j)
	{
		Object swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
	}
	
	private void exchange(int[] arr, int i, int j)
	{
		int swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
	}
	
	/***************************************************************************
    	*  Sorting check.
    	***************************************************************************/
	private boolean isSorted(Comparable<T>[] arr)
	{
		return isSorted(arr, 0, arr.length);
	}
	
	private boolean isSorted(Comparable<T>[] arr, int low, int high)
	{
		for (int i = low + 1; i < high; i ++)
			if (less(arr[i], arr[i-1]))
				return false;
		return true;
	}
	
	private boolean isSorted(Object[] arr, Comparator<T> comparator)
	{
		return isSorted(arr, 0, arr.length, comparator);
	}
	
	private boolean isSorted(Object[] arr, int low, int high, Comparator<T> comparator)
	{
		for (int i = low + 1; i < high; i++)
			if (less(arr[i], arr[i-1], comparator))
				return false;
		return true;
	}
	
	/***************************************************************************
    	* Sorting display.
    	***************************************************************************/
	public void show(Comparable<T>[] arr)
	{
		for (int i = 0; i < arr.length; i ++)
			System.out.println(arr[i]);
	}
} 
