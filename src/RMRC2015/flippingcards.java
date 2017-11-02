package RMRC2015;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class flippingcards {
	
	public static ArrayList<ArrayList<Integer>> cards;
	public static boolean[] visited;
	
	public static boolean bfs(int start) {
		LinkedList<Integer> q = new LinkedList<>();
		q.add(start);
		
		int countNums = 0;
		int countCards = 0;
		
		while(!q.isEmpty()) {
			int num = q.pop();
			if(visited[num]) continue;
			
			countNums++;
			
			for(int i: cards.get(num)) {
				if(visited[i]) continue;
				
				countCards++;
				q.add(i);
			}
			
			visited[num] = true;
		}
				
		return countNums >= countCards;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			cards = new ArrayList<ArrayList<Integer>>(2 * n + 1);
			
			for(int j = 0; j < 2 * n + 1; j++) {
				cards.add(null);
			}
			
			visited = new boolean[2 * n + 1];
			
			for(int j = 1; j <= n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int p_i = Integer.parseInt(st.nextToken());
				int q_i = Integer.parseInt(st.nextToken());
				
				if(cards.get(p_i) == null) cards.set(p_i, new ArrayList<>());
				if(cards.get(q_i) == null) cards.set(q_i, new ArrayList<>());
				
				cards.get(p_i).add(q_i);
				if(p_i != q_i) cards.get(q_i).add(p_i);
			}
					
			boolean possible = true;
			for(int j = 1; j <= 2 * n; j++) {
				if(cards.get(j) == null || visited[j]) continue;
				if(!bfs(j)) {
					possible = false;
					pw.println("impossible");
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
