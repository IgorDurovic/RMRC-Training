package RMRC2015;

import java.io.*;
import java.util.StringTokenizer;

public class recipes {
	
	public static class Ingredient {
		public String name;
		public double weight, percent;
		
		Ingredient(String n, double w, double p) {
			name = n;
			weight = w;
			percent = p;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int R = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			double scale = ((double) D) / P;
			double scaledWeight = -1;
			Ingredient[] all = new Ingredient[R];
			
			for(int j = 0; j < R; j++) {
				st = new StringTokenizer(br.readLine());
				
				all[j] = new Ingredient(st.nextToken(),
						Double.parseDouble(st.nextToken()),
						Double.parseDouble(st.nextToken()) / 100.0);
				
				if(all[j].percent == 1.0) scaledWeight = scale * all[j].weight;
			}
			
			pw.println("Recipe # " + (i + 1));
			for(Ingredient n: all) {
				pw.println(n.name + " " + (scaledWeight * n.percent));
			}
			pw.println("----------------------------------------");
		}
		
		pw.flush();
		pw.close();
		br.close();
		System.exit(0);
	}
}
