package RMRC2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * I know I should've used a nested class :(
 * too lazy to rewrite code rn
 */

public class bundles {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			boolean[][] bundles = new boolean[m][n + 1];
			int[] prices = new int[m];
			int[] subsets = new int[m];
			
			for(int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				
				prices[j] = Integer.parseInt(st.nextToken());
				int s_i = Integer.parseInt(st.nextToken());
				
				for(int k = 0; k < s_i; k++) {
					bundles[j][Integer.parseInt(st.nextToken())] = true;
				}
			}
			
			for(int j = 0; j < m; j++) {
				int cur = -1;
				for(int k = 0; k < m; k++) {
					if(i == k) continue;
					
					if(subset(j, k, bundles)) {
						if(cur == -1) cur = k;
						else if(subset(k, cur, bundles)) {
							cur = k;
						}
					}
				}
				
				if(cur != -1) subsets[j] = cur;
			}
		}
		
		pw.flush();
		pw.close();
		br.close();
		System.exit(0);
	}
	
	public static boolean subset(int A, int B, boolean[][] bundles) {
		
		for(int i = 0; i < bundles[i].length; i++) {
			if(bundles[A][i] && !bundles[B][i]) return false;
		}
		
		return true;
	}
	
}
