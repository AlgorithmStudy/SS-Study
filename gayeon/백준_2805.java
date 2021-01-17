package BinaraySearch_2805;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int height = input.nextInt();

		long min = 0;
		long max = 0;
		long[] tree = new long[n];

		for (int i = 0; i < n; i++) {
			tree[i] = input.nextLong();
			max = Math.max(tree[i], max);
		}

		while (true) {
			if (min > max)
				break;
			long middle = (min + max) / 2;

			long cut = 0;
			for (int i = 0; i < n; i++) {
				if (tree[i] > middle)
					cut += tree[i] - middle;
			}
			if (cut >= height)
				min = middle + 1;
			else
				max = middle - 1;
		}

		System.out.println(max);
	}

}
