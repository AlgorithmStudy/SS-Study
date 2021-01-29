package B_1744;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = input.nextInt();

		Arrays.sort(arr);

		int left = 0, right = n - 1;
		int sum = 0;

		while (true) {
			if (left >= n - 1 || arr[left] >= 0 || arr[left + 1] >= 1)
				break;
			sum += arr[left] * arr[left + 1];
			left += 2;
		}

		while (true) {
			if (right <= left || arr[right] <= 0 || arr[right - 1] <= 1)
				break;
			sum += arr[right] * arr[right - 1];
			right -= 2;
		}

		for (int i = left; i <= right; i++) {
			sum += arr[i];
		}

		System.out.println(sum);
	}

}
