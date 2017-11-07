package RMRC2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class cups {
	
	public static class Cup implements Comparable<Cup>{
		public String color;
		public double radius;
		
		Cup(String c, double r){
			color = c;
			radius = r;
		}

		@Override
		public int compareTo(Cup o) {
			return this.radius - o.radius >= 0 ? 1 : -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int N = Integer.parseInt(br.readLine());
		Cup[] all = new Cup[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String first = st.nextToken();
			String second = st.nextToken();
			try {
				double radius = Integer.parseInt(first) / 2.0;
				String color = second;
				
				all[i] = new Cup(color, radius);
			} catch(Exception e) {
				double radius = Double.parseDouble(second);
				String color = first;
				
				all[i] = new Cup(color, radius);
			}
		}
		
		Arrays.sort(all);
		
		for(Cup c: all) {
			out.println(c.color);
		}
		
		out.flush();
		out.close();
		br.close();
	}
}
