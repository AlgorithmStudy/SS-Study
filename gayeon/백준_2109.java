package B_2109;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture>{
	int p, d;
	Lecture(int p, int d){
		this.p = p;
		this.d = d;
	}
	
	@Override
	public int compareTo(Lecture l) {
		if(this.d < l.d)
			return -1;
		else if(this.d == l.d) {
			if(this.p > l.p)
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
		
		ArrayList<Lecture> list = new ArrayList<>();
		
		for(int i=0; i<n; i++)
			list.add(new Lecture(input.nextInt(), input.nextInt()));
		
		list.sort(null);
		PriorityQueue<Lecture> queue = new PriorityQueue<>(new Comparator<Lecture>() {

			@Override
			public int compare(Lecture l0, Lecture l1) {
				if(l0.p < l1.p)
					return -1;
				else
					return 1;
			}
			
		});
		
		int sum = 0;
		int day = 0;
		for(int i=0; i<n; i++) {
			if(day == list.get(i).d) {
				if(queue.size() < list.get(i).d)
					queue.add(list.get(i));
				else if(queue.peek().p < list.get(i).p) {
					queue.poll();
					queue.add(list.get(i));
				}
				continue;
			}
			day = list.get(i).d;
			queue.add(list.get(i));
		}
		
		while(!queue.isEmpty())
			sum += queue.poll().p;
		
		System.out.println(sum);
	}

}
