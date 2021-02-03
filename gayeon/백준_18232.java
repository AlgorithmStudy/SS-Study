package B_18232;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Point implements Comparable<Point> {
	int x, time;

	Point(int x, int time) {
		this.x = x;
		this.time = time;
	}

	@Override
	public int compareTo(Point p) {
		if (this.time <= p.time)
			return -1;
		else
			return 1;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int m = input.nextInt();

		int S = input.nextInt();
		int E = input.nextInt();

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= N; i++)
			list.add(new ArrayList<>());

		for (int i = 0; i < m; i++) {
			int x = input.nextInt();
			int y = input.nextInt();
			list.get(x).add(y);
			list.get(y).add(x);
		}

		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(S, 0));
		boolean visit[] = new boolean[N+1];
		
		while (true) {
			if (queue.isEmpty())
				break;
			Point tmp = queue.poll();

			if (tmp.x == E) {
				System.out.println(tmp.time);
				break;
			}

			if(tmp.x < 0 || tmp.x > N || visit[tmp.x])
				continue;
			
			visit[tmp.x] = true;
			
			for (int i : list.get(tmp.x)) {
				queue.add(new Point(i, tmp.time + 1));
			}
			queue.add(new Point(tmp.x - 1, tmp.time + 1));
			queue.add(new Point(tmp.x + 1, tmp.time + 1));
		}
	}

}
