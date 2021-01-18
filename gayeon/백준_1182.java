package B_1182;

import java.util.Scanner;

public class Main {
	static int result = 0;
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int s = input.nextInt();
		
		arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = input.nextInt();
		
		if(s == 0)
			result--;
		solve(n, s, 0, 0);
		System.out.println(result);
	}

	static void solve(int n, int s, int sum, int idx) {
		if(idx >= n) {
			if(sum == s)
				result++;
			return;
		}
		
		solve(n, s, sum + arr[idx], idx+1);
		solve(n, s, sum, idx+1);
	}
}
