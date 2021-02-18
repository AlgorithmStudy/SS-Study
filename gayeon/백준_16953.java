package B_16953;

import java.util.PriorityQueue;
import java.util.Scanner;


class Change implements Comparable<Change>{
	long a;
	int cnt;
	Change(long a, int cnt){
		this.a = a;
		this.cnt = cnt;
	}
	
	@Override
	public int compareTo(Change c) {
		if(this.cnt < c.cnt)
			return -1;
		return 1;
	}
}

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b =  input.nextInt();
		
		PriorityQueue<Change> queue = new PriorityQueue<>();
		queue.add(new Change(a, 1));
		
		while(true) {
			if(queue.isEmpty())
				break;
			
			Change tmp = queue.poll();
			
			if(tmp.a > b)
				continue;
			
			if(tmp.a == b) {
				System.out.println(tmp.cnt);
				System.exit(0);
			}
			
			queue.add(new Change(tmp.a*2, tmp.cnt+1));
			queue.add(new Change((tmp.a*10)+1, tmp.cnt+1));
		}
		
		System.out.println(-1);
	}

}
