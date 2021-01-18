package B_16198;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			list.add(input.nextInt());
		}

		System.out.println(solution(list));
	}

	static public int solution(LinkedList<Integer> list) {
		if (list.size() <= 2)
			return 0;
		int max = 0;
		for (int i = 1; i < list.size() - 1; i++) {
			LinkedList<Integer> tmp = new LinkedList<>();
			tmp.addAll(list);
			int mul = tmp.get(i - 1) * tmp.get(i + 1);
			tmp.remove(i);
			max = Math.max(max, mul + solution(tmp));
		}

		return max;
	}

}
