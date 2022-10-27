package sorting.divideAndConquer;

import java.util.PrimitiveIterator;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) { //estou tendo problemas de tipo no merge sort :_(
		if (array.length == 1) {
			return;
		}

		Integer[] arrayAuxiliar = new Integer[rightIndex - leftIndex];
		for (int i=leftIndex; i<=rightIndex; i++) {
			arrayAuxiliar[i] = array[i];
		}

		//variáveis para apontamento
		int primeiro = leftIndex;
		int ultimo = rightIndex;
		int meio = (leftIndex + rightIndex)/2;
		int primeiroSegundaLista = meio+1;
		int incrementador = primeiro;

		while (primeiro<=meio && primeiroSegundaLista <= ultimo){ //mergesort
			if (array[primeiro].compareTo(array[primeiroSegundaLista]) > 0) {
				array[incrementador++] = arrayAuxiliar[primeiro++];
			}
			else{
				array[incrementador++] = arrayAuxiliar[primeiroSegundaLista++];
			}
		}

		while (primeiro<=meio) {
			array[incrementador++] = arrayAuxiliar[primeiro++];
		}
		while (primeiroSegundaLista<=ultimo){
			array[incrementador++] = arrayAuxiliar[primeiroSegundaLista++];
		}
	}
}
