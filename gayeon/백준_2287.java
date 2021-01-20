package B_2287;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int K = input.nextInt();
		int n = input.nextInt();

		HashSet<Integer>[] arr = new HashSet[9];

		int num = 0;
		for (int i = 1; i < 9; i++) {
			arr[i] = new HashSet<>();
			num = num * 10 + K;
			arr[i].add(num);
		}

		for (int i = 2; i < 9; i++) {
			for (int j = 1; j < i; j++) {
				int tmp = i - j;
				
				for(int x : arr[j]) {
					for(int y : arr[tmp]) {
						arr[i].add(x + y);
						arr[i].add(Math.abs(x - y));
						arr[i].add(x * y);
						if(y != 0)
							arr[i].add(x / y);
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			int tmp = input.nextInt();
			int result = -1;
			for (int j = 1; j < 9; j++) {
				if (arr[j].contains(tmp)) {
					result = j;
					break;
				}
			}
			if (result == -1)
				sb.append("NO\n");
			else
				sb.append(result+"\n");
		}
		System.out.print(sb);
	}

}
