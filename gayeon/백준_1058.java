package B_1058;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		int[][] friend = new int[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(friend[i], Integer.MAX_VALUE);
			friend[i][i] = 0;
		}
		for (int i = 0; i < n; i++) {
			String str = input.next();
			for (int j = 0; j < n; j++) {
				if (str.charAt(j) == 'Y')
					friend[i][j] = 1;
			}
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				if (i == k)
					continue;
				for (int j = 0; j < n; j++) {
					if (i == j || j == k)
						continue;
					int result = friend[i][k] + friend[k][j] < 0 ? Integer.MAX_VALUE : friend[i][k] + friend[k][j];
					friend[i][j] = Math.min(friend[i][j], result);
				}

			}
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				if (friend[i][j] <= 2)
					cnt++;
			}
			result = Math.max(result, cnt);
		}

		System.out.println(result);
	}

}
