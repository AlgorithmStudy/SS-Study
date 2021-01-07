package B_14496;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Change implements Comparable<Change> {
	int idx, cnt;

	Change(int idx, int cnt) {
		this.idx = idx;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Change c) {
		if (this.cnt <= c.cnt)
			return -1;
		else
			return 1;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();

		int n = input.nextInt();
		int m = input.nextInt();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= n; i++)
			list.add(new ArrayList<Integer>());

		for (int i = 0; i < m; i++) {
			int v1 = input.nextInt();
			int v2 = input.nextInt();
			list.get(v1).add(v2);
			list.get(v2).add(v1);
		}
		boolean visit[] = new boolean[n + 1];

		Queue<Change> queue = new LinkedList<>();
		queue.add(new Change(a, 0));
		visit[a] = true;

		int result = -1;
		while (true) {
			if (queue.isEmpty())
				break;
			Change tmp = queue.poll();

			if (tmp.idx == b) {
				result = tmp.cnt;
				break;
			}
			for (int i : list.get(tmp.idx)) {
				if (!visit[i]) {
					queue.add(new Change(i, tmp.cnt + 1));
					visit[i] = true;
				}
			}
		}

		System.out.println(result);
	}

}
