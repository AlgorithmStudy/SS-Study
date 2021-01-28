package B_11659;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		
		int[] dp = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			dp[i] = dp[i-1] + input.nextInt();
		}
		
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<m; t++) {
			int i = input.nextInt();
			int j = input.nextInt();
			
			sb.append(dp[j] - dp[i-1]+"\n");
		}
		
		System.out.print(sb);
	}

}
