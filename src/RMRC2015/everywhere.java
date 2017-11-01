package RMRC2015;

import java.io.*;
import java.util.HashSet;

public class everywhere {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			HashSet<String> cities = new HashSet<>();
			
			for(int j = 0; j < n; j++) {
				cities.add(br.readLine());
			}
			
			pw.println(cities.size());
		}
		
		pw.flush();
		pw.close();
		br.close();
		System.exit(0);
	}

}
