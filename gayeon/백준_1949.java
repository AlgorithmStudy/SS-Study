package B_1949;

import java.util.Scanner;

public class Main {
	static int N;
	static boolean[][] city;
	static int[] people;
	static int[][] dp;
	static boolean[] visit;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		people = new int[N+1];
		
		city = new boolean[N+1][N+1];
		dp = new int[N+1][2];
		visit = new boolean[N+1];
		
		for(int i=1; i<=N; i++)
			people[i] = input.nextInt();
		
		for(int i=0; i<N-1; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			
			city[a][b] = city[b][a] = true;
		}
		
		dfs(1);
		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}
	
	static void dfs(int idx) {
		dp[idx][0] = people[idx];
		visit[idx] = true;
		for(int i=1; i<= N; i++) {
			if(city[idx][i] & !visit[i]) {
				dfs(i);
				dp[idx][0] += dp[i][1]; // 현재 노드 방문 -> 다음 노드는 방문 X
				dp[idx][1] += Math.max(dp[i][0], dp[i][1]); // 현대 노드 방문 안함 -> 다음 노드 방문 해도 되고 안해도 됨
			}
		}
		visit[idx] = false;
	}
}
