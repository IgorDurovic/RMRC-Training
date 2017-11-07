package RMRC2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class fizzbuzz {
	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		
		int X = scn.nextInt();
		int Y = scn.nextInt();
		int N = scn.nextInt();
		
		for(int i = 1; i <= N; i++) {
			out.print(i % X == 0 ? "Fizz" : "");
			out.print(i % Y == 0 ? "Buzz" : "");
			out.println(i % X != 0 && i % Y != 0 ? i : "");
		}
		
		out.flush();
		out.close();
		scn.close();
	}
}
