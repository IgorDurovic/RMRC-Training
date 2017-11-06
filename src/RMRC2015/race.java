package RMRC2015;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class race {

	public static int n, T;
	public static int[][] dist, memo;
	public static Location[] locs;

	public static class Location {
		public int p, t, d;

		Location(int a, int b, int c) {
			p = a;
			t = b;
			d = c;
		}
	}

	public static int solve(int bitset, int next, int time) {
		if (memo[next][bitset] >= 0)
			return memo[next][bitset];
		if (bitset == (1<<next)) {
			return memo[next][bitset] = locs[next].t + dist[n][next] <= locs[next].d ? locs[next].t + dist[n][next] : 1441;
		}

		int min = 1441;
		for (int i = 0; i < n; i++) {
			if (i != next && (1 << i & bitset) != 0) {
				int temp = bitset ^ (1 << next);
				int sol = dist[i][next] + locs[next].t + solve(temp, i, time);
				if (sol <= locs[next].d && sol < min) {
					min = sol;
				}
			}
		}

		return memo[next][bitset] = min;
	}

	public static int points(int bitset) {
		int total = 0;
		for (int i = 0; i < n; i++) {
			if ((bitset & (1 << i)) == 1 << i) {
				total += locs[i].p;
			}
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
		memo = new int[n][1 << n];
		
		for(int i = 0; i < memo.length; i++) {
			Arrays.fill(memo[i], -1);
		}
		
		locs = new Location[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			locs[i] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
			
			if(locs[i].d == -1) locs[i].d = 1441;
		}

		for (int i = 0; i < n + 2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n + 2; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0;
		int sol = 0;
		for (int i = 0; i < 1 << n; i++) {
			for (int last = 0; last < n; last++) {
				if(((1 << last) & i) == 0) continue;
				if (solve(i, last, 0) + dist[last][n + 1] <= T && points(i) > max) {
					max = points(i);
					sol = i;
				}
			}
		}

		pw.println(max);
		
		StringBuilder set = new StringBuilder();
		for(int i = 0; i < n; i++) {
			if((sol & (1 << i)) == 1 << i) {
				set.append((i + 1) + " ");
			}
		}
		
		pw.println(set.toString().trim());

		pw.flush();
		pw.close();
		br.close();
		System.exit(0);
	}
}
