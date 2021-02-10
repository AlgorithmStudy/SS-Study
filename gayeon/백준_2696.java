package B_2696;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int test = input.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<test; t++) {
			int n = input.nextInt();
			ArrayList<Integer> list = new ArrayList<>();
			
			StringBuilder str = new StringBuilder();
			
			int cnt = 0;
			for(int i=0; i<n; i++) {
				list.add(input.nextInt());
				list.sort(null);
				
				if(i % 2 == 0) {
					cnt++;
					if(cnt > 10 && cnt % 10 == 1)
						str.append("\n");
					str.append(list.get(i/2)+" ");
				}
			}
			
			sb.append(cnt+"\n");
			sb.append(str+"\n");
			
		}
		System.out.print(sb);
	}

}
