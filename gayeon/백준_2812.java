package B_2812;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int K = input.nextInt();
		
		int num[] = Arrays.stream(input.next().split("")).mapToInt(Integer::parseInt).toArray();
		
		Stack<Integer> stack = new Stack<>();
		
		int cnt = K;
		for(int i=0; i<N; i++) {
			while(cnt > 0 && !stack.isEmpty() && stack.peek() < num[i]) {
				stack.pop();
				cnt--;
			}
			stack.push(num[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N-K; i++)
			sb.append(stack.get(i));
		
		System.out.print(sb);
	}

}
