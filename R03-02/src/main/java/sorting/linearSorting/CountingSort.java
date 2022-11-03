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

		//tratando casos de teste
		if (array.length == 0) {
			return;
		}

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
		
		//registrando frequencia dos elementos do array;
		int[] arrayContagem = new int [(maior - menor) + 1];
		
		for (int i2=leftIndex; i2<=rightIndex; i2++){
			arrayContagem[array[i2]] += 1;
		}

		//calculando a soma cumulativa do array auxiliar
		for (int j=1; j<arrayContagem.length; j++) {
			arrayContagem[j] = arrayContagem[j] + arrayContagem[j - 1];
		}

		//ordenando o array
		int[] arrayOrdenado = new int [array.length];

		for (int o=rightIndex; o>=leftIndex; o--) {
			arrayOrdenado[arrayContagem[array[o]] -1] = array[o];
			arrayContagem[array[o]] -= 1;
		}

		//insere o array ordenado para nas posições do array inicial
		for (int i3=leftIndex; i3<=rightIndex; i3++) {
			array[i3] = arrayOrdenado[i3];
		}
	}

}
