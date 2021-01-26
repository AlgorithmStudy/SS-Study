package B_4358;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> hash = new HashMap<>();
		
		int cnt = 0;
		
		while(true) {
			String str = br.readLine();
			
			if(str == null)
				break;
			
			if(hash.containsKey(str))
				hash.put(str, hash.get(str)+1);
			else
				hash.put(str, 1);
			cnt++;
		}
		
		TreeMap<String, Integer> tm = new TreeMap<>(hash);
		Iterator<String> it = tm.keySet().iterator();
		
		while(it.hasNext()) {
			String s = it.next();
			double num = ((double)hash.get(s) / cnt) * 100;
			
			System.out.println(s+" "+String.format("%.4f", num));
		}
	}
}
