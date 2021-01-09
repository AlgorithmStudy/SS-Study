package B_17836;

import java.util.PriorityQueue;
import java.util.Scanner;

class Point implements Comparable<Point>{
	int row, col, time;
	int gram;
	
	Point(int row, int col, int time, int gram){
		this.row = row;
		this.col = col;
		this.time = time;
		this.gram = gram;
	}
	
	@Override
	public int compareTo(Point p) {
		if(this.time <= p.time)
			return -1;
		else
			return 1;
	}
}
public class Main {
	static int Dr[] = { -1, 1, 0, 0 };
	static int Dc[] = { 0, 0, -1, 1 };
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		int T = input.nextInt();
		
		int map[][] = new int[N][M];
		int dp[][][] = new int[N][M][2];
		
		int time = T+1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = input.nextInt();
				dp[i][j][0] = dp[i][j][1] = time;
			}
		}
		
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(0, 0, 0, 0));
		dp[0][0][0] = 0;
		
		while(true) {
			if(queue.isEmpty())
				break;
			
			Point tmp = queue.poll();
			if(tmp.row == N-1 && tmp.col == M-1) {
				time = Math.min(time, tmp.time);
				continue;
			}
			
			if(time <= tmp.time) {
				continue;
			}
			
			for(int i=0; i<4; i++) {
				int nr = tmp.row + Dr[i];
				int nc = tmp.col + Dc[i];
				
				if(nr<0 || nr>=N || nc<0 || nc>= M)
					continue;

				int gram = tmp.gram;
				if(map[nr][nc] == 2) {
					gram = 1;
				}
				
				if(map[nr][nc] != 1 || gram == 1) {
					if(dp[nr][nc][gram] > tmp.time + 1) {
						dp[nr][nc][gram] = tmp.time + 1;
						queue.add(new Point(nr, nc, dp[nr][nc][gram], gram));
					}
				}
			}
		}
		
		if(time > T)
			System.out.println("Fail");
		else
			System.out.println(time);
	}

}
