package B_14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[][] arr = new int[tmp[0]][tmp[1]];
		int[][] dp = new int[tmp[0]][tmp[1]];

		int[] block = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		for (int i = 0; i < block.length; i++) {
			for (int j = 0; j < block[i]; j++) {
				arr[tmp[0] - 1 - j][i] = 1;
				
				if(i == 0)
					dp[tmp[0] - 1 - j][i] = 1;
			}
		}

		
		int rain = 0;
		
		for (int j = 1; j < tmp[1]; j++) {
			for (int i = 0; i < tmp[0]; i++) {
				if (arr[i][j] == 1) {
					dp[i][j] = 1;
					if(dp[i][j-1] != 0)
						rain += dp[i][j - 1] - 1;
				} else {
					if(dp[i][j-1] != 0)
						dp[i][j] = dp[i][j - 1] + 1;
				}
			}
		}
		
		System.out.println(rain);
	}
}
