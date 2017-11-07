package RMRC2016;

import java.io.*;
import java.util.Scanner;

public class election {
	
	//82248224822488
	//64
	
	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		
		int lim = 60;
        long[][] s = new long[lim + 1][lim + 1];
        for (int i = 0; i <= lim; i++) {
            s[i][0] = s[i][i] = 1L;
            for (int j = 1; j < i; j++) {
                s[i][j] = s[i - 1][j - 1] + s[i - 1][j];
            }
        }
        for (int i = 0; i <= lim; i++) {
            for (int j = i - 1; j >= 0; j--) {
                s[i][j] += s[i][j + 1];
            }
        }
		
		int T = scn.nextInt();
						
		for(int i = 0; i < T; i++) {
			int N = scn.nextInt();
			int V_1 = scn.nextInt();
			int V_2 = scn.nextInt();
			int W = scn.nextInt();
			int M = N - (V_1 + V_2);
			
			int left = N / 2 + 1 - V_1;
			
			if(V_2 >= (N + 1) / 2) {
				out.println("RECOUNT!");
			}
			else if(left <= 0 || W * (1L << (M)) < 100 * s[M][left]) {
				out.println("GET A CRATE OF CHAMPAGNE FROM THE BASEMENT!");
			}
			else {
				out.println("PATIENCE, EVERYONE!");
			}
		}
		
		out.flush();
		out.close();
		scn.close();
	}
}
