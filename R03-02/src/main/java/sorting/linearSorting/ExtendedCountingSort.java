package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		//tratando casos de teste
		if (array.length > 0) {
			
			//variáveis
			int maior = 0;
			int menor = 0;

			//encontrando o maior e o menor
			for (int i=leftIndex; i<=rightIndex; i++) {	
				if (array[i] > maior) {
					maior = array[i];
				}
				if (array[i] < menor) {
					menor = array[i];
				}
			}

			//tratando os numeros negativos
			if (menor < 0) {
				menor = Math.abs(menor);
			}
			
			//registrando frequencia dos elementos do array;
			int[] arrayContagem = new int [(maior + menor) + 1];
			
			for (int i2=leftIndex; i2<=rightIndex; i2++){
				arrayContagem[array[i2] + menor] += 1;
			}

			//calculando a soma cumulativa do array auxiliar
			for (int j=1; j<arrayContagem.length; j++) {
				arrayContagem[j] = arrayContagem[j] + arrayContagem[j - 1];
			}

			//ordenando o array
			int[] arrayOrdenado = new int [array.length];

			for (int o=rightIndex; o>=leftIndex; o--) {
				arrayOrdenado[arrayContagem[array[o] + menor] -1] = array[o];
				arrayContagem[array[o] + menor] -= 1;
			}

			//insere o array ordenado para nas posições do array inicial
			for (int i3=leftIndex; i3<=rightIndex; i3++) {
				array[i3] = arrayOrdenado[i3];
			}
		}
	}

}
