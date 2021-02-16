package B_19598;

import java.util.PriorityQueue;
import java.util.Scanner;

class Meeting implements Comparable<Meeting> {
	int start, end;

	Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting m) {
		if (this.start < m.start)
			return -1;
		else if (this.start == m.start) {
			if (this.end < m.end)
				return -1;
		}
		return 1;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		PriorityQueue<Meeting> startQueue = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			startQueue.add(new Meeting(input.nextInt(), input.nextInt()));
		}

		PriorityQueue<Integer> endQueue = new PriorityQueue<>();
		int room = 0;

		while (true) {
			if (startQueue.isEmpty())
				break;

			if (endQueue.isEmpty()) {
				endQueue.add(startQueue.poll().end);
				room++;
				continue;
			}

			Meeting tmp = startQueue.poll();

			if (endQueue.peek() <= tmp.start)
				endQueue.poll();
			else
				room++;

			endQueue.add(tmp.end);
		}
		
		System.out.println(room);
	}

}
