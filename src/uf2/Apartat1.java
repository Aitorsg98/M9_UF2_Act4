package uf2;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Apartat1 {
	static class Client implements Runnable {
		private int[] articles;
		private int numeroClient;

		public Client(int numeroClient, int[] articles) {
			this.numeroClient = numeroClient;
			this.articles = articles;
		}

		@Override
		public void run() {
			// Thread.sleep();
		}
	}

	public static int randomFill() {
		double randomDouble = Math.random();
		randomDouble = randomDouble * 30 + 1;
		int randomInt = (int) randomDouble;
		return randomInt;
	}

	public static void main(String[] args) {
		int numClient = 1;

		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);

		for (int i = 0; i < 50; i++) {
			double randomDouble = Math.random();
			randomDouble = randomDouble * 30 + 1;
			int randomInt = (int) randomDouble;

			/*int[] articles = new int[randomInt];
			for (int ii = 0; ii < articles.length; ii++) {
				articles[ii] = randomFill();
			}
			
			Client client = new Client(numClient, articles);

			System.out.println("Creat el client " + numClient + " amb " + articles.length + " articles"+Arrays.toString(articles));*/
			
			int[] articles = new int[randomInt];
			
			Client client = new Client(numClient, articles);

			System.out.println("Creat el client " + numClient + " amb " + articles.length + " articles");
			System.out.println("Client " + numClient +  " passa per caixa...");

			for (int ii = 0; ii < articles.length; ii++) {
				long inici = System.currentTimeMillis() / 1000;
				articles[ii] = randomFill();
				System.out.print("Client " + numClient + " ");
				System.out.print("article " + (ii+1) + "/" + articles.length + " ");
				if (ii+1 < articles.length) {
				System.out.println( "(" + articles[ii] + " segons)...");
				} else {
					System.out.println( "(" + articles[ii] + " segons)...FINALITZAT");
				}
			}
			numClient++;
		}
	}
}
