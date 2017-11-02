package RMRC2015;

import java.io.*;

public class vote {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int max = 0;
			int winner = 0;
			int total = 0;
			boolean tie = false;
			for(int j = 0; j < n; j++) {
				int votes = Integer.parseInt(br.readLine());
				total += votes;
				
				if(votes > max) {
					tie = false;
					max = votes;
					winner = j + 1;
				}
				else if(votes == max) {
					tie = true;
				}
			}
			
			if(max * 2 > total) {
				pw.println("majority winner " + winner);
			}
			else if(!tie) {
				pw.println("minority winner " + winner);
			}
			else {
				pw.println("no winner");
			}
		}
		
		pw.flush();
		pw.close();
		br.close();
		System.exit(0);
	}
}
