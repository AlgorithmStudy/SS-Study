package B_1254;

import java.util.Scanner;

public class Main {
	static int dp[][];
	static char str[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		str = input.next().toCharArray();
		
		dp = new int[str.length][str.length];
		
		for(int i=0; i<str.length-1; i++) {
			dp[i][i] = 1;
			if(str[i] == str[i+1])
				dp[i][i+1] = dp[i+1][i] = 1;
			else
				dp[i][i+1] = dp[i+1][i] = 2;
		}
		dp[str.length-1][str.length-1] = 1;
		
		int result = str.length;
		int start;
		for(start=0; start<str.length-1; start++) {
			if(isPalindrome(start, str.length-1) == 1) {
				break;
			}
		}
		
		System.out.println(result+start);
	}
	
	static int isPalindrome(int start, int end) {
		if(dp[start][end] != 0)
			return dp[start][end];
		
		if(str[start] == str[end])
			return dp[start][end] = dp[end][start] = isPalindrome(start+1, end-1);
		else
			return dp[start][end] = dp[end][start] = 2;
	}
}
