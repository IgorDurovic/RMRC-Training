package RMRC2016;

import java.io.*;
import java.util.Scanner;

public class traffic {

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		
		int X_1 = scn.nextInt();
		int X_2 = scn.nextInt();
		
		int[] first = new int[scn.nextInt()];
		
		for(int i = 0; i < first.length; i++) {
			first[i] = scn.nextInt();
		}
		
		int[] second = new int[scn.nextInt()];
		
		for(int i = 0; i < second.length; i++) {
			second[i] = scn.nextInt();
		}
		
		boolean crash = false;
		boolean d_1 = false;
		boolean d_2 = false;
		int cur_1 = 0;
		int cur_2 = 0;
		for(int i = 1; i <= 5000001; i++) {
			if(d_1) X_1++;
			if(d_2) X_2++;
			
			if(X_1 < X_2 && X_1 + 5 > X_2) {
				out.println("bumper tap at time " + i);
				crash = true;
				break;
			}
			else if(X_2 < X_1 && X_2 + 5 > X_1) {
				out.println("bumper tap at time " + i);
				crash = true;
				break;
			}
			
			if(cur_1 < first.length && i == first[cur_1]) {
				cur_1++;
				d_1 = !d_1;
			}
			if(cur_2 < second.length && i == second[cur_2]) {
				cur_2++;
				d_2 = !d_2;
			}
		}
		
		if(!crash) {
			out.println("safe and sound");
		}
		
		out.flush();
		out.close();
		scn.close();
	}
}
