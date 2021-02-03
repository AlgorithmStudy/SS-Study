package CountingSort_1489;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] cntA = new int[1001];
		int[] cntB = new int[1001];

		for (int i = 0; i < n; i++) {
			cntA[A[i]]++;
			cntB[B[i]]++;
		}
		
		int ans = 0;
		for(int i=1; i<1001; i++) {
			if(cntA[i] == 0)
				continue;
			for(int j=i-1; j>0; j--) {
				if(cntA[i] == 0 || cntB[j] == 0)
					continue;
				cntA[i]--;
				cntB[j]--;
				j++;
				ans += 2;
			}
		}
		
		for(int i=1; i<1001; i++) {
			if(cntA[i] > 0 && cntB[i] > 0) {
				int tmp = Math.min(cntA[i], cntB[i]);
				ans += tmp;
			}
		}
		
		System.out.println(ans);
	}

}
