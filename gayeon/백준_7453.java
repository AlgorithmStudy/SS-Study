package B_7453;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][4];
		int[] AB = new int[n * n];
		int[] CD = new int[n * n];

		for (int i = 0; i < n; i++)
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				AB[idx] = arr[i][0] + arr[j][1];
				CD[idx] = arr[i][2] + arr[j][3];
				idx++;
			}
		}

		Arrays.sort(AB);
		Arrays.sort(CD);

		int ab = 0, cd = idx - 1;

		long cnt = 0;

		while (true) {
			if (ab >= idx || cd < 0)
				break;

			if (AB[ab] + CD[cd] == 0) {
				int abCnt = 0, cdCnt = 0;
				int tmp = AB[ab];
				while (true) {
					if (ab < idx && AB[ab] == tmp) {
						ab++;
						abCnt++;
					} else
						break;
				}

				tmp = CD[cd];
				while (true) {
					if (cd >= 0 && CD[cd] == tmp) {
						cd--;
						cdCnt++;
					} else
						break;
				}

				cnt += (long) abCnt * (long) cdCnt;
			}

			else if (AB[ab] + CD[cd] > 0)
				cd--;
			else
				ab++;
		}

		System.out.println(cnt);
	}

}
