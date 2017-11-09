package RMRC2016;

import java.io.*;

public class stack {

	public static char[] line;
	public static int[][] memo;

	public static int cost(int l, int r) {
		
		if(l > r)
			return 0;
		if (l == r)
			return 2;
		if (memo[r][l] > 0)
			return memo[r][l];

		int min = 2 + cost(l + 1, r);
		for (int i = l + 1; i <= r; i++) {
			if (line[i] == line[l]) {
				int temp = cost(l + 1, i - 1) + cost(i, r);
				if(temp < min) {
					min = temp;
				}
			}
		}

		return memo[r][l] = min;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());

		for (int i = 0; i < T; i++) {
			line = in.readLine().toCharArray();
			memo = new int[line.length][line.length];
			out.println(line.length + cost(0, line.length - 1));
		}

		out.flush();
		out.close();
		in.close();
	}
}
