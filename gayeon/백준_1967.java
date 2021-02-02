package Tree_1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Node {
	int v, dist;
	Node (int v, int dist){
		this.v = v;
		this.dist = dist;
	}
}

public class Main {
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	static int leaf = 0, max = 0;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n+1; i++)
			list.add(new ArrayList<Node>());
		
		for(int i=0; i<n-1; i++) {
			int tmp[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			list.get(tmp[0]).add(new Node(tmp[1], tmp[2]));
			list.get(tmp[1]).add(new Node(tmp[0], tmp[2]));
		}
		
		visit = new boolean[n+1];
		dfs(1, 0);
		
		dfs(leaf, 0);
		System.out.println(max);
	}

	static void dfs(int idx, int weight) {
		if(max < weight) {
			leaf = idx;
			max = weight;
		}
		
		visit[idx] = true;
		for(Node n : list.get(idx)) {
			if(!visit[n.v]) {
				dfs(n.v, weight+n.dist);
			}
		}
		visit[idx] = false;
	}
}
