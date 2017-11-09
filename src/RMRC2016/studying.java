package RMRC2016;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class studying {
	
	public static class function implements Comparable<function>{
		public double a, b;
		
		function(double a, double b){
			this.a = a;
			this.b = b;
		}
		
		public double f(double t) {
			return a * t * t + b * t;
		}
		
		public double d(double t) {
			return 2 * a * t + b;
		}

		@Override
		public int compareTo(function o) {
			if(this.b == o.b) {
				return this.a - o.a > 0 ? 1 : -1;
			}
			
			return this.b - o.b > 0 ? 1 : -1;
		}
		
		@Override
		public boolean equals(Object o) {
			if(o instanceof function) {
				return (this.a == ((function)o).a) && (this.b == ((function)o).b);
			}
			
			return false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		
		int N = in.nextInt();
		int T = in.nextInt();
		double total = 0;
		
		ArrayList<function> funcs = new ArrayList<>(N);
		
		for(int i = 0; i < N; i++) {
			double a = in.nextDouble();
			double b = in.nextDouble();
			double c = in.nextDouble();
			
			function f = new function(a, b);
			if(!funcs.contains(f)) funcs.add(new function(a, b));
			total += c;
		}
		
		Collections.sort(funcs);
		
		double time = 0;
		for(int i = 0; i < funcs.size() - 1; i++) {
			if(funcs.get(i + 1).b == funcs.get(i).b) continue;
			double end = (funcs.get(i + 1).b - funcs.get(i).b) / (2 * funcs.get(i).a);
			time += end;
			total += funcs.get(i).f(end);
		}
	
		total += funcs.get(funcs.size() - 1).f(T - time);
		
		out.println(total);
		
		out.flush();
		out.close();
		in.close();
	}
}
