package B_14225;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++)
			arr[i] = input.nextInt();
		
		Arrays.sort(arr);
		
		if(arr[0] != 1)
			System.out.println(1);
		else {
			int sum = arr[0];
			
			for(int i=1; i<n; i++) {
				if(sum+1 < arr[i])
					break;
				sum += arr[i];
			}
			
			System.out.println(sum+1);
		}
	}

}
