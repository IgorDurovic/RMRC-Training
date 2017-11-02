package RMRC2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * I know I should've used a nested class :(
 * too lazy to rewrite code rn
 */

public class bundles {

	public static boolean[][] bundles;
	public static int[] prices;
	public static ArrayList<ArrayList<Integer>> subsets;
	
	public static int subset(int A, int B) {

		boolean strict = false;
		for (int i = 0; i < bundles[A].length; i++) {
			if (bundles[A][i] && !bundles[B][i])
				return 0;
			if(!bundles[A][i] && bundles[B][i])
				strict = true;
		}

		return strict ? 2 : 1;
	}
	
	public static boolean equal(boolean[] temp, int B) {
		
		for(int i = 0; i < temp.length; i++) {
			if(temp[i] != bundles[B][i]) return false;
		}
		
		return true;
	}
	
	public static boolean isValid(int n) {
		boolean[] temp = new boolean[bundles[n].length];
		
		for(int i: subsets.get(n)) {
			for(int j = 0; j < temp.length; j++) {
				temp[j] = temp[j] || bundles[i][j];
			}
		}
		
		return equal(temp, n);
	}
	
	public static int solve(int n) {
		
		if(subsets.get(n) == null
				|| subsets.get(n).size() == 0) return prices[n];
		
		if(prices[n] != Integer.MAX_VALUE && !isValid(n)) return prices[n];
		
		int total = 0;
		for(int i: subsets.get(n)) {
			total += solve(i);
		}
				
		return Math.min(prices[n], total);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			bundles = new boolean[m + 1][n + 1];
			prices = new int[m + 1];
			subsets = new ArrayList<ArrayList<Integer>>(m + 1);
			
			for(int j = 0; j <= m; j++) {
				subsets.add(null);
			}

			Arrays.fill(bundles[m], true);

			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());

				prices[j] = Integer.parseInt(st.nextToken());
				int s_i = Integer.parseInt(st.nextToken());

				for (int k = 0; k < s_i; k++) {
					bundles[j][Integer.parseInt(st.nextToken())] = true;
				}
			}
			
			prices[m] = Integer.MAX_VALUE;

			for (int j = 0; j < m; j++) {
				int cur = m;
				for (int k = 0; k < m; k++) {
					if (j == k)
						continue;

					int sub = subset(j, k);
					if (sub > 0) {
						if ((sub == 2 || (sub == 1 && k > j)) && cur == m) {
							cur = k;
							continue;
						}
						
						if(sub == 1 && k < j) continue;
						
						sub = subset(k, cur);
						if (sub == 2) {
							cur = k;
						}
					}
				}
			
				if (subsets.get(cur) == null) subsets.set(cur, new ArrayList<Integer>());
				subsets.get(cur).add(j);
			}
			
			//System.out.println("here " + subsets.get(m).size());
			
			pw.println(solve(m));
		}

		pw.flush();
		pw.close();
		br.close();
		System.exit(0);
	}

}
