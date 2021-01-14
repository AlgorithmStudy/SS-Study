package B_6497;

import java.util.PriorityQueue;
import java.util.Scanner;

class Power implements Comparable<Power> {
	int v1, v2, value;

	Power(int v1, int v2, int value) {
		this.v1 = v1;
		this.v2 = v2;
		this.value = value;
	}

	@Override
	public int compareTo(Power p) {
		if (this.value >= p.value)
			return 1;
		else
			return -1;
	}
}

public class Main {
	static int root[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		
		Scanner input = new Scanner(System.in);

		while (true) {
			int N = input.nextInt();
			int M = input.nextInt();
			int total = 0;
			
			if (N == 0 && M == 0)
				break;

			root = new int[N];
			for (int i = 0; i < N; i++) {
				root[i] = i;
			}

			PriorityQueue<Power> queue = new PriorityQueue<>();

			for (int i = 0; i < M; i++) {
				int v1 = input.nextInt();
				int v2 = input.nextInt();

				int value = input.nextInt();
				total += value;
				queue.add(new Power(v1, v2, value));
			}
			int n = 0;
			int answer = 0;
			while (true) {
				if (queue.isEmpty())
					break;
				if(n == N-1)
					break;
				
				Power temp = queue.poll();

				if (union(temp.v1, temp.v2)) {
					answer += temp.value;
					n++;
				}

			}
			sb.append(total - answer + "\n");
		}

		System.out.print(sb);
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return false;
		else {
			root[y] = x;
			return true;
		}

	}

	static int find(int x) {
		if (x == root[x])
			return x;
		else
			return root[x] = find(root[x]);
	}

}
