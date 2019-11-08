package uf2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadSort {

	public static int randomFill() {
		double randomDouble = Math.random();
		randomDouble = randomDouble * 1000 + 1;
		int randomInt = (int) randomDouble;
		return randomInt;
	}

	public static void main(String[] args) throws InterruptedException {
		int[] array1 = new int[500];
		int[] array2 = new int[500];

		for (int i = 0; i < array1.length; i++) {
			array1[i] = randomFill();
		}

		for (int i = 0; i < array2.length; i++) {
			array2[i] = randomFill();
		}

		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

		OrdenaArray ordena1 = new OrdenaArray(array1);
		executor.execute(ordena1);
		OrdenaArray ordena2 = new OrdenaArray(array2);
		executor.execute(ordena2);
		executor.awaitTermination(1, TimeUnit.SECONDS);

		executor.shutdown();
		array1 = ordena1.getArray();
		array2 = ordena2.getArray();

		int i = 0;
		int j = 0;

		while (i < array1.length && j < array2.length) {
			if (array1[i] < array2[j]) {
				System.out.println(array1[i]);
				i++;
			} else {
				System.out.println(array2[j]);
				j++;
			}
		}

		if (i < array1.length) {
			for (int x = i; x < array1.length; x++) {
				System.out.println(array1[x]);
			}
		} else {
			for (int x = j; x < array2.length; x++) {
				System.out.println(array2[x]);
			}
		}

		/*
		 * final ScheduledExecutorService schExService =
		 * Executors.newScheduledThreadPool(4); final Runnable ob = new ThreadSort().new
		 * ExecutaFil(); schExService.scheduleWithFixedDelay(ob, 5, 6,
		 * TimeUnit.SECONDS); schExService.awaitTermination(30, TimeUnit.SECONDS);
		 * schExService.shutdownNow();
		 */
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
			for (int i = 0; i < n; i++) // Looping through the array length
			{
				for (int j = 1; j < (n - i); j++) {
					if (array[j - 1] > array[j]) {

						// swap elements
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

	/*
	 * class ExecutaFil implements Runnable {
	 * 
	 * @Override // Mostrara l'hora d'execució i el estat de la tasca de cada fil.
	 * public void run() {
	 * 
	 * } }
	 */

}
