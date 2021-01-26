package PriorityQueue_7662;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int test = input.nextInt();

		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < test; t++) {
			PriorityQueue<Integer> min = new PriorityQueue<>();
			PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
			HashMap<Integer, Integer> hash = new HashMap<>();
			
			int n = input.nextInt();

			for (int i = 0; i < n; i++) {
				char str = input.next().charAt(0);
				int num = input.nextInt();

				if (str == 'I') {
					min.add(num);
					max.add(num);
					
					if(hash.containsKey(num)) {
						hash.put(num, hash.get(num)+1);
					}else
						hash.put(num, 1);
					
				} else {
					if (num > 0) {
						while(true) {
							if(max.isEmpty())
								break;
							int tmp = max.poll();
							if(hash.get(tmp) > 0) {
								hash.put(tmp, hash.get(tmp)-1);
								break;
							}
						}
					} else {
						while(true) {
							if(min.isEmpty())
								break;
							int tmp = min.poll();
							if(hash.get(tmp) > 0) {
								hash.put(tmp, hash.get(tmp)-1);
								break;
							}
						}
					}
				}
			}
			
			while(true) {
				if(max.isEmpty())
					break;
				if(hash.get(max.peek()) > 0) {
					break;
				}
				max.poll();
			}
			if(!max.isEmpty()) {
				while(true) {
					if(min.isEmpty())
						break;
					if(hash.get(min.peek()) > 0) {
						break;
					}
					min.poll();
				}
			}
			
			if(max.isEmpty() || min.isEmpty())
				sb.append("EMPTY\n");			
			else
				sb.append(max.peek()+" "+min.peek()+"\n");
		}

		System.out.print(sb);
	}
}
