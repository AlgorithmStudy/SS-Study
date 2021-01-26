package B_18809;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int row, col;

	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class Main {
	static LinkedList<Point> land;
	static int N, M, R, G;
	static int[][] arr;
	static int max = 0;
	static int[] Dr = { -1, 1, 0, 0 };
	static int[] Dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		R = input.nextInt();
		G = input.nextInt();

		arr = new int[N][M];
		land = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = input.nextInt();
				if (arr[i][j] == 2)
					land.add(new Point(i, j));
			}
		}
		LinkedList<Point> redList = new LinkedList<>();
		LinkedList<Point> greenList = new LinkedList<>();
		
		backTracking(0, 0,0,redList, greenList);
		
		System.out.println(max);
	}

	static void backTracking(int idx, int red, int green, LinkedList<Point> redList, LinkedList<Point> greenList) {
		if (idx >= land.size()) {
			if (red == R && green == G) {
				max = Math.max(max, spread(redList, greenList));
			}
			return;
		}

		Point tmp = land.get(idx);

		if (red < R) {
			arr[tmp.row][tmp.col] = 3;
			redList.add(tmp);
			backTracking(idx + 1, red + 1, green, redList, greenList);
			redList.removeLast();
		}

		if (green < G) {
			arr[tmp.row][tmp.col] = 4;
			greenList.add(tmp);
			backTracking(idx + 1, red, green + 1, redList, greenList);
			greenList.removeLast();
		}

		arr[tmp.row][tmp.col] = 2;
		backTracking(idx + 1, red, green, redList, greenList);
	}

	static int spread(LinkedList<Point> redList, LinkedList<Point> greenList) {
		int flower = 0;
		Queue<Point> redQueue = new LinkedList<>(redList);
		Queue<Point> greenQueue = new LinkedList<>(greenList);
		int visit[][] = new int[N][M];
		int temp[][] = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = arr[i][j];
			}
		}

		int time = 0;

		while (true) {
			if (redQueue.isEmpty() && greenQueue.isEmpty())
				break;

			int redSize = redQueue.size();
			int greenSize = greenQueue.size();

			time++;

			while (redSize-- > 0) {
				Point rtmp = redQueue.poll();
				if(temp[rtmp.row][rtmp.col] == 5)
					continue;
				
				for(int i=0; i<4; i++) {
					int nr = Dr[i] + rtmp.row;
					int nc = Dc[i] + rtmp.col;
					
					if(nr < 0 || nr>=N || nc<0 || nc>= M || temp[nr][nc] == 0 || temp[nr][nc] >= 3)
						continue;
					
					temp[nr][nc] = 3;
					visit[nr][nc] = time;
					redQueue.add(new Point(nr, nc));
				}
			}

			while (greenSize-- > 0) {
				Point gtmp = greenQueue.poll();
				
				for(int i=0; i<4; i++) {
					int nr = Dr[i] + gtmp.row;
					int nc = Dc[i] + gtmp.col;
					
					if(nr < 0 || nr>=N || nc<0 || nc>= M || temp[nr][nc] == 0 || temp[nr][nc] == 4 || temp[nr][nc] == 5)
						continue;
					
					if(temp[nr][nc] ==  3) {
						if(visit[nr][nc] == time){
							temp[nr][nc] = 5;
							flower++;
						}
						continue;
					}
					
					temp[nr][nc] = 4;
					visit[nr][nc] = time;
					greenQueue.add(new Point(nr, nc));
				}
			}
		}

		return flower;
	}
}
