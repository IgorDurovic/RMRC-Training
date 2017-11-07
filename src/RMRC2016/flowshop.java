package RMRC2016;

import java.io.*;
import java.util.Scanner;

public class flowshop {
	public static void main(String[] args) throws IOException{
		Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		
		int N = scn.nextInt();
		int M = scn.nextInt();
		
		int[][] P = new int[N][M];
		int[][] sol = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				P[i][j] = scn.nextInt();
			}
		}
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += P[i][0];
			sol[i][0] = sum;
		}
		
		sum = 0;
		for(int i = 0; i < M; i++) {
			sum += P[0][i];
			sol[0][i] = sum;
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 1; j < M; j++) {
				sol[i][j] = P[i][j] + Math.max(sol[i - 1][j], sol[i][j - 1]);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(sol[i][M - 1] + " ");
		}
		
		out.println(sb.toString().trim());
		
		out.flush();
		out.close();
		scn.close();
	}
}
