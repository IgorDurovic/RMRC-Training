package RMRC2015;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class three {
	
	public static ArrayList<Integer> primes;
	
	public static int reduce(int n) {
		
		if(n < 7 && n != 3) return -1;
		if(n == 3) return 4;
		
		int base = n - 3;
		
		for(int i = 4; i < 10; i++) {
			if(base % i == 0) return i;
		}
		
		while(base % 2 == 0) base /= 2;
		while(base % 3 == 0) base /= 3;
		
		for(int i: primes) {
			if(i <= 3) continue;
			if(i >= base) break;
			if(base % i == 0) return i;
		}
		
		return base;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		primes = new ArrayList<>();
		boolean[] isPrime = new boolean[50000];
		
		Arrays.fill(isPrime, true);
		
		for(int i = 2; i < isPrime.length; i++) {
			if(isPrime[i]) {
				primes.add(i);
				if(Integer.MAX_VALUE / i < i) continue;
				for(int j = i * i; j < isPrime.length; j += i) {
					isPrime[j] = false;
				}
			}
		}
		
		int num;
		while((num = Integer.parseInt(br.readLine())) != 0) {
			int sol = reduce(num);
			
			pw.println((sol == -1 ? "No such base" : sol));
		}
		
		pw.flush();
		pw.close();
		br.close();
		System.exit(0);
	}
}
