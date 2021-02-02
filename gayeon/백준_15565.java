package TwoPointer_15565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tmp[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int min = tmp[0] + 2;
		Queue<Integer> queue = new LinkedList<>();

		for (int end = 0; end < tmp[0]; end++) {
			if (arr[end] == 1)
				queue.add(end);
			if (queue.size() >= tmp[1]) {
				min = Math.min(min, end - queue.poll() + 1);
			}
		}

		if(min >= tmp[0] + 2)
			System.out.println(-1);
		else
			System.out.println(min);
	}

}
