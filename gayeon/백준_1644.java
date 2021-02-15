package B_1644;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		boolean check[] = new boolean[n+1];
		ArrayList<Integer> list = new ArrayList<>();
		
		if(n <= 1) {
			System.out.println(0);
			System.exit(0);
		}
		
		for (int i = 2; i <= n; i++) {
			if (!check[i]) {
				list.add(i);
				for (int j = i; j <= n; j += i) {
					if(check[j])
						continue;
					check[j] = true;
				}
			}
		}
		
		
		int start = 0, end =0;
		int sum = list.get(0);
		int cnt = 0;
		
		while(true) {
			if(start > end)
				break;
			
			if(sum <= n) {
				if(sum == n)
					cnt++;
				end++;
				if(end >= list.size())
					break;
				sum += list.get(end);
			}
			else {
				sum -= list.get(start);
				start++;
			}
		}
		
		System.out.println(cnt);
	}

}
