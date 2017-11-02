package RMRC2015;

import java.io.*;
import java.util.StringTokenizer;

public class keypad {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			boolean[][] grid = new boolean[r][c];
			char[][] sol = new char[r][c];
			int[] rows = new int[r];
			int[] cols = new int[c];
			
			for(int j = 0; j < r; j++) {
				String line = br.readLine();
				
				for(int k = 0; k < c; k++) {
					grid[j][k] = line.charAt(k) == '1';
					
					if(grid[j][k]) {
						rows[j]++;
						cols[k]++;
					}
					else{
						sol[j][k] = 'N';
					}
				}
			}
			
			boolean impossible = false;
			for(int j = 0; j < r; j++) {
				if(impossible) break;
				for(int k = 0; k < c; k++) {
					if(grid[j][k]) {
						if(rows[j] > 1 && cols[k] > 1) {
							sol[j][k] = 'I';
						}
						else {
							sol[j][k] = 'P';
						}
					}
					else {
						if(rows[j] > 0 && cols[k] > 0) {
							impossible = true;
							break;
						}
					}
				}
			}
			
			if(impossible) {
				pw.println("impossible");
			}
			else {
				for(int j = 0; j < r; j++) {
					StringBuilder sb = new StringBuilder();
					for(int k = 0; k < c; k++) {
						sb.append(sol[j][k]);
					}
					
					pw.println(sb.toString());
				}
			}
			
			pw.println("----------");
		}
		
		pw.flush();
		pw.close();
		br.close();
		System.exit(0);
	}
}
