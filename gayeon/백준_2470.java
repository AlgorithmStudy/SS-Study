package TwoPointer_2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
		
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = n-1;
		int min = Integer.MAX_VALUE;
		int sIdx =  0, eIdx = n-1;
		
		while(true) {
			if(start == end)
				break;
			int tmp = arr[start] + arr[end];

			if(min > Math.abs(tmp)) {
				min = Math.abs(tmp);
				sIdx = start;
				eIdx = end;
			}

			if(tmp < 0)
				start++;
			else
				end--;
		}
		
		System.out.println(arr[sIdx] +" "+arr[eIdx]);
	}

}
