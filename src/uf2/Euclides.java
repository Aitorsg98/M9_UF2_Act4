package uf2;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Euclides extends RecursiveTask<Integer> {
	int p, q;

	public Euclides(int p, int q) {
		this.p = p;
		this.q = q;
	}

	static int MCD_Euclides(int p, int q) {
		double calc = java.lang.Math.cos(54879854);
		if (q == 0) {
			return p;
		} else {
			return MCD_Euclides(q, p % q);
		}
	}

	@Override
	protected Integer compute() {
		double calc = java.lang.Math.cos(54879854);
		if (q == 0) {
			return p;
		} else {
			Euclides euc1 = new Euclides(q, p % q);
			return euc1.compute();
		}
	}

	public static void main(String[] args) {
		double inici = (double) System.currentTimeMillis() / 1000;
		//System.out.println(MCD_Euclides(999999999, 48150525));
		ForkJoinPool pool = new ForkJoinPool();
		System.out.println(pool.invoke(new Euclides(999999999, 48150525)));
		double fi = (double)System.currentTimeMillis() / 1000;
		double total = fi - inici;
		System.out.println(total);
	}
}
