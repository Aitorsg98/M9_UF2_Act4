package uf2;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadSort {
	
	/**
	 * Metode que genera numeros aleatoris
	 * @return randomInt
	 */
	public static int randomFill() {
		double randomDouble = Math.random();
		randomDouble = randomDouble * 1000 + 1;
		int randomInt = (int) randomDouble;
		return randomInt;
	}

	public static void main(String[] args) throws InterruptedException {
		//Com que el meu ordinador té 2 nuclis, generem dos arrays de mida 500.
		int[] array1 = new int[500];
		int[] array2 = new int[500];

		//Els recorrem i els omplim de numeros aleatoris
		for (int i = 0; i < array1.length; i++) {
			array1[i] = randomFill();
		}

		for (int i = 0; i < array2.length; i++) {
			array2[i] = randomFill();
		}

		//Procedim a crear l'executor amb 2 fils
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

		/*Creem un objecte tipus OrdenaArray, que apunta cap a la subclasse que gestionarà
		 la ordenació dels arrays*/
		OrdenaArray ordena1 = new OrdenaArray(array1);
		executor.execute(ordena1);
		OrdenaArray ordena2 = new OrdenaArray(array2);
		executor.execute(ordena2);
		/*Afegim awaitTermination per asegurar que al programa li dona temps a ordenar
		completament els arrays*/
		executor.awaitTermination(1, TimeUnit.SECONDS);

		executor.shutdown();
		//Obtenim els arrays ja ordenats
		array1 = ordena1.getArray();
		array2 = ordena2.getArray();

		int i = 0;
		int j = 0;
		
		/*Recorrem els 2 arrays a la vegada i mostrem per pantalla el valor mes petit d'entre
		 els dos*/
		while (i < array1.length && j < array2.length) {
			if (array1[i] < array2[j]) {
				System.out.println(array1[i]);
				i++;
			} else {
				System.out.println(array2[j]);
				j++;
			}
		}

		//Tornem a recorrer els arrays i mostrem el contingut per pantalla
		if (i < array1.length) {
			for (int x = i; x < array1.length; x++) {
				System.out.println(array1[x]);
			}
		} else {
			for (int x = j; x < array2.length; x++) {
				System.out.println(array2[x]);
			}
		}
	}

	static class OrdenaArray implements Runnable {
		int[] array;

		public OrdenaArray(int[] array) {
			this.array = array;
		}

		@Override
		public void run() {
			int n = array.length;
			int temp = 0;
			for (int i = 0; i < n; i++){
				for (int j = 1; j < (n - i); j++) {
					if (array[j - 1] > array[j]) {
						temp = array[j - 1];
						array[j - 1] = array[j];
						array[j] = temp;
					}
				}
			}
		}

		public int[] getArray() {
			return array;
		}
	}
}
