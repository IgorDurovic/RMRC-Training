package RMRC2015;

import java.io.*;
import java.util.StringTokenizer;

public class race {
	
	public static int n, T;
	public static int[][] dist, memo;
	public static Location[] locs;
	
	public static class Location {
		public int p, t, d;
		
		Location(int a, int b, int c){
			p = a;
			t = b;
			d = c;
		}
	}
	
	public static int solve(int bitset, int next) {
		if(bitset == 0) return dist[n][next];
		if(next != -1 && memo[bitset][next] != 0) return memo[bitset][next];
		
		int min = Integer.MAX_VALUE;
		int prev = -1;
		for(int i = 0; i < 21; i++) {
			int temp = bitset;
			if((1 << i & bitset) != 0) {
				temp = bitset ^ (1 << i);
				int sol = solve(temp, i);
				if(sol != -1 && sol < min) {
					min = sol;
					prev = i;
				}
			}
		}
		
		if(next != -1) {
			memo[bitset][next] = min + dist[prev][next]<= T ? min : -1;
		}
		
		return min <= T ? min + dist[prev][n + 1] : -1;
	}
	
	public static int points(int bitset) {
		int total = 0;
		for(int i = 0; i < n; i++) {
			if((bitset & 1) == 1) {
				total += locs[i].p;
			}
			bitset >>= 1;
		}
		
		return total;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		dist = new int[n + 2][n + 2];
		memo = new int[(int)Math.pow(2, 21)][n + 2];
		locs = new Location[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			locs[i] = new Location(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		int sol = 0;
		for(int i = 1; i <= Math.pow(2, 21) - 1; i++) {
			if(solve(i, -1) != -1 && points(i) > max) {
				max = points(i);
				sol = i;
			}
		}
		
		pw.println(max);
		
		pw.flush();
		pw.close();
		br.close();
		System.exit(0);
	}
}
