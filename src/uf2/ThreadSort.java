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

	

	/*
	 * class ExecutaFil implements Runnable {
	 * 
	 * @Override // Mostrara l'hora d'execució i el estat de la tasca de cada fil.
	 * public void run() {
	 * 
	 * } }
	 */

}
