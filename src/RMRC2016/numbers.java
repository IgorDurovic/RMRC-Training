package RMRC2016;

import java.io.*;
import java.util.Scanner;

public class numbers {
	
	public static String num;
	public static boolean fin;
	
	public static boolean reduce() {
		
		StringBuilder sb = new StringBuilder();
		fin = true;
		for(int i = num.length() - 1; i > 0; i -= 2) {
			if(num.charAt(i) != '8' || num.charAt(i - 1) != '8') {
				fin = false;
			}
			
			if(num.charAt(i) != '8' && num.charAt(i) == num.charAt(i - 1)) {
				char join = (char)((num.charAt(i) - '0') + (num.charAt(i - 1) - '0') + '0');
				sb.append(join);
			}
			else {
				sb.append(num.charAt(i));
				sb.append(num.charAt(i - 1));
			}
		}
		
		String temp = sb.reverse().toString();
		
		if(temp.equals(num)) {
			return false;
		}
		else {
			num = temp;
			return true;
		}
	}
	
	public static void makeNicer() {
		StringBuilder sb = new StringBuilder();
		
		if(fin) {
			sb.append(num);
			int bit = Integer.highestOneBit(num.length());
			
			if(bit != num.length()) {
				bit <<= 1;
			}
			
			for(int i = num.length(); i < bit; i++) {
				sb.append('8');
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		
		int T = in.nextInt();
		
		for(int i = 0; i < T; i++) {
			num = in.next();
			
			while(num.length() != 1) {
				while(reduce()) {}
				
				makeNicer();
				
			}
			
			out.println(num);
		}
		
		out.flush();
		out.close();
		in.close();
	}
}
