package RMRC2016;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class password {
	
	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		
		int N = scn.nextInt();
		double[] passwords = new double[N];
		
		for(int i = 0; i < N; i++) {
			scn.next();
			passwords[i] = scn.nextDouble();
		}
		
		Arrays.sort(passwords);
		
		double expected = 0;
		int counter = 0;
		for(int i = N - 1; i >= 0; i--) {
			expected += passwords[i] * ++counter;
		}
		
		out.println(expected);
		
		out.flush();
		out.close();
		scn.close();
	}
}
