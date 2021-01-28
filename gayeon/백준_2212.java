package B_2212;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int k=Integer.parseInt(br.readLine());
        
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);
        
        int[] dist = new int[n-1];
        
        for(int i=1; i<n; i++) {
        	dist[i-1] = arr[i] - arr[i-1];
        }
        
        Arrays.sort(dist);
        
        int sum = 0;
        
        for(int i=0; i<n-k; i++)
        	sum += dist[i];
        
        System.out.println(sum);
	}

}
