package Trie_14725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Trie tries = new Trie("");
		
		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
			tries.insert(tmp);
		}
		
		tries.print("", tries);
	}
}

class Trie {
	String word;
	ArrayList<Trie> childList;

	Trie(String word) {
		childList = new ArrayList<>();
		this.word = word;
	}
	
	void insert(String[] words) {
		Trie current = this;
		
		loop:
		for(int i=1; i<words.length; i++) {
			for(Trie t : current.childList) {
				if(t.word.equals(words[i])) {
					current = t;
					continue loop;
				}
			}
			
			current.childList.add(new Trie(words[i]));
			current = current.childList.get(current.childList.size()-1);
		}
	}

	void print(String line, Trie current) {
		current.childList.sort(new Comparator<Trie>() {

			@Override
			public int compare(Trie a, Trie b) {
				return a.word.compareTo(b.word);
			}
			
		});
		
		for(Trie t : current.childList) {
			System.out.println(line+t.word);
			print(line+"--", t);
		}
	}

}