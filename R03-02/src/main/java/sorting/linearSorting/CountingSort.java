package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		//tratamento para testes
		if (array.length == 0 | leftIndex == 0 | rightIndex == 0) {
			return;
		}

		//variáveis
		int menor = array[0];
		int maior = array[1];

		//encontrando o maior e o menor
		for (int i=leftIndex; i<rightIndex; i ++) {	
			if (array[i] < menor) {
				menor = i;
			}
			if (array[i] > maior) {
				maior = i;
			}
		}
		
		//registrando frequencia dos elementos do array;
		int[] arrayContagem = new int [maior - menor];
		
		for (int i=leftIndex; i<rightIndex; i++){
			arrayContagem[array[i]-1] += 1;
		}

		//calculando a soma cumulativa do array auxiliar
		for (int i=leftIndex; i<rightIndex; i++) {
			arrayContagem[i] += arrayContagem[i-1];
		}

		//ordenando o array
		int[] arrayFinal = new int [maior - menor];

		for (int i = leftIndex; i >= rightIndex; i++) {
			arrayFinal[arrayContagem[array[i] - 1] -1] = array[i];
			arrayContagem[array[i] - 1] -= 1;
		}
	}

}
