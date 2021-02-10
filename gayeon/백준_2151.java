package B_2151;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Point implements Comparable<Point> {
	int row, col, mirror, dir;

	Point(int row, int col, int mirror, int dir) {
		this.mirror = mirror;
		this.row = row;
		this.col = col;
		this.dir = dir;
	}
	
	@Override
	public int compareTo(Point o) {
		if (this.mirror <= o.mirror)
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
		char arr[][] = new char[N][N];

		Point[] door = new Point[2];
		int idx = 0;

		int visit[][][] = new int[N][N][4];

		for (int i = 0; i < N; i++) {
			String str = input.next();
			if (str.contains("#")) {
				for (int j = 0; j < str.length(); j++) {
					arr[i][j] = str.charAt(j);
					if (arr[i][j] == '#') {
						door[idx++] = new Point(i, j, 0, 0);
					}
				}
			} else
				arr[i] = str.toCharArray();
			
			for(int j=0; j<N; j++)
				Arrays.fill(visit[i][j], Integer.MAX_VALUE);
		}

		PriorityQueue<Point> queue = new PriorityQueue<>();

		for(int i=0; i<4; i++) {
			queue.add(new Point(door[0].row, door[0].col, 0, i));
		}

		int Dr[] = { 1, 0, -1, 0 };
		int Dc[] = { 0, 1, 0, -1 };

		while (true) {
			if (queue.isEmpty())
				break;

			Point tmp = queue.poll();

			int row = tmp.row;
			int col = tmp.col;
			int dir = tmp.dir;
			
			if (row < 0 || row >= N || col < 0 || col >= N || arr[row][col] == '*')
				continue;

			if (row == door[1].row && col == door[1].col) {
				System.out.println(tmp.mirror);
				break;
			}

			if (visit[row][col][dir] < tmp.mirror)
				continue;

			visit[row][col][dir] = tmp.mirror;

			if (arr[row][col] == '!') {
				queue.add(new Point(row + Dr[(dir + 1) % 4], col + Dc[(dir + 1) % 4], tmp.mirror + 1, (dir + 1) % 4));
				queue.add(new Point(row + Dr[(dir + 3) % 4], col + Dc[(dir + 3) % 4], tmp.mirror + 1, (dir + 3) % 4));
			}
			
			queue.add(new Point(row + Dr[dir], col + Dc[dir], tmp.mirror, dir));

		}
	}

}
