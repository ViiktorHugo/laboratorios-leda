package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean trocou = true;

		while (trocou){
			trocou = false;

			for (int i = leftIndex; i < rightIndex-i; i++){
				if (array[leftIndex].compareTo(array[rightIndex]) > 0){
					Util.swap(array, leftIndex, rightIndex);
					trocou = true;
				}
			}
		}
	}
}
