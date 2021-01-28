package B_13164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tmp[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Arrays.sort(arr);

		int[] height = new int[tmp[0] - 1];

		for (int i = 1; i < tmp[0]; i++)
			height[i - 1] = arr[i] - arr[i - 1];

		Arrays.sort(height);

		int sum = 0;
		for (int i = 0; i < tmp[0] - tmp[1]; i++)
			sum += height[i];

		System.out.print(sum);
	}

}
