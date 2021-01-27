package TwoPointer_15961;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int d = input.nextInt();
		int k = input.nextInt();
		int c = input.nextInt();

		int arr[] = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = input.nextInt();

		int max = 0;
		int cnt = 1;
		int visit[] = new int[d + 1];
		visit[c]++;

		for (int i = 0; i < k; i++) {
			visit[arr[i]]++;
			if (visit[arr[i]] == 1)
				cnt++;
		}

		for (int i = 0; i < N; i++) {
			max = Math.max(max, cnt);
			visit[arr[i]]--;
			if (visit[arr[i]] == 0)
				cnt--;

			visit[arr[(i + k) % N]]++;
			if (visit[arr[(i + k) % N]] == 1)
				cnt++;

		}
		System.out.println(max);
	}

}
