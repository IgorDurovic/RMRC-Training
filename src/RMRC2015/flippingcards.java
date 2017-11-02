package RMRC2015;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class flippingcards {
	
	public static Card[] cards;
	public static int[] exists;
	public static int[] count;
	public static boolean[] visited;
	
	public static class Card {
		public int p_i;
		public int q_i;
		
		ArrayList<Integer> children;
		
		Card(int a, int b){
			p_i = a;
			q_i = b;
			
			children = new ArrayList<>();
		}
	}
	
	public static void bfs(int start) {
		LinkedList<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int cur = q.pop();
			if(count[cards[cur].p_i] == 0) {
				count[cards[cur].p_i]++;
			}
			else {
				count[cards[cur].q_i]++;
			}
			
			for(int i: cards[cur].children) {
				q.add(i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			cards = new Card[n + 1];
			exists = new int[2 * n + 1];
			visited = new boolean[n + 1];
			
			for(int j = 1; j <= n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int p_i = Integer.parseInt(st.nextToken());
				int q_i = Integer.parseInt(st.nextToken());
				
				cards[j] = new Card(p_i, q_i);
				
				if(p_i == q_i) {
					count[p_i]++;
					continue;
				}
				
				if(exists[p_i] != 0) {
					cards[exists[p_i]].children.add(j);
				}
				else {
					exists[p_i] = j;
				}
				
				if(exists[q_i] != 0) {
					cards[j].children.add(exists[q_i]);
				}
			}
			
			for(int j = 1; j <= n; j++) {
				if(visited[j]) continue;
				bfs(j);
			}
			
			boolean possible = true;
			for(int j = 1; j <= n; j++) {
				if(count[j] > 1) {
					pw.println("impossible");
					possible = false;
					break;
				}
			}
			
			if(possible) {
				pw.println("possible");
			}
		}
		
		pw.flush();
		pw.close();
		br.close();
		System.exit(0);
	}
}
