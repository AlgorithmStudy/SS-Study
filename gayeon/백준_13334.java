package B_13334;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Point implements Comparable<Point> {
	int left, right;

	Point(int a, int b) {
		this.left = Math.min(a, b);
		this.right = Math.max(a, b);
	}

	@Override
	public int compareTo(Point p) {
		return Integer.compare(this.right, p.right);
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Point> list = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			list.add(new Point(tmp[0], tmp[1]));
		}

		int d = Integer.parseInt(br.readLine());

		list.sort(null);

		PriorityQueue<Integer> queue = new PriorityQueue<>();

		int max = 0;
		for (Point p : list) {
			queue.add(p.left);

			while (!queue.isEmpty() && queue.peek() < p.right - d)
				queue.poll();

			max = Math.max(max, queue.size());
		}

		System.out.println(max);

	}

}
