package MST_20010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Town implements Comparable<Town> {
	int v1, v2, val;

	Town(int v1, int v2, int val) {
		this.v1 = v1;
		this.v2 = v2;
		this.val = val;
	}

	Town(int v1, int val) {
		this.v1 = v1;
		this.val = val;
	}
	
	@Override
	public int compareTo(Town t) {
		if (this.val <= t.val)
			return -1;
		else
			return 1;
	}
}

public class Main {
	static int[] root;
	static ArrayList<ArrayList<Town>> list = new ArrayList<>();
	static boolean[] visit;
	static int max = 0, leaf = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();

		PriorityQueue<Town> queue = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			queue.add(new Town(input.nextInt(), input.nextInt(), input.nextInt()));
		}

		for(int  i=0; i<n; i++)
			list.add(new ArrayList<>());
		
		root = new int[n];
		Arrays.fill(root, -1);

		int cnt = 0;
		int min = 0;
		while (true) {
			if (cnt == n - 1)
				break;
			Town temp = queue.poll();

			if (union(temp.v1, temp.v2)) {
				cnt++;
				min += temp.val;
				list.get(temp.v1).add(new Town(temp.v2, temp.val));
				list.get(temp.v2).add(new Town(temp.v1, temp.val));
			}
		}

		visit = new boolean[n];
		dfs(0, 0);
		dfs(leaf, 0);
		
		System.out.println(min + "\n" + max);
	}

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return false;

		root[b] = a;
		return true;
	}

	static int find(int a) {
		if (root[a] == a || root[a] == -1)
			return root[a] = a;
		return root[a] = find(root[a]);
	}

	static void dfs(int idx, int weight) {
		if(max < weight) {
			leaf = idx;
			max = weight;
		}
		
		visit[idx] = true;
		for(Town t : list.get(idx)) {
			if(!visit[t.v1]) {
				dfs(t.v1, weight+t.val);
			}
		}
		visit[idx] = false;
	}
}
