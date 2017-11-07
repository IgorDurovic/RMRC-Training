package RMRC2015;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class space {

	public static double dist(double t, double[] first, double[] second) {
		double x = first[0] + t * first[4] - second[0] - t * second[4];
		double y = first[1] + t * first[5] - second[1] - t * second[5];
		double z = first[2] + t * first[6] - second[2] - t * second[6];
		return Math.sqrt(x * x + y * y + z * z);
	}

	public static void main(String[] args) {
		double max = 100000;
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			double[] first = new double[7];
			for (int j = 0; j < first.length; j++) {
				first[j] = sc.nextInt();
			}
			double[] second = new double[7];
			for (int j = 0; j < second.length; j++) {
				second[j] = sc.nextInt();
			}

			double lo = 0;
			double hi = max;
			for (int j = 0; j < 100; j++) {
				double mid = (lo + hi) / 2;
				if (dist(lo, first, second) < dist(hi, first, second))
					hi = mid;
				else
					lo = mid;
			}

			if (hi == max || dist(lo, first, second) > first[3] + second[3] + 1e-15) {
				out.println("No collision");
			} else {
				lo = 0;
				double d = first[3] + second[3];
				for (int j = 0; j < 60; j++) {
					double mid = 0.5 * (lo + hi);
					if (dist(mid, first, second) < d)
						hi = mid;
					else
						lo = mid;
				}
				out.println(lo);
			}
		}
		
		out.flush();
		out.close();
		sc.close();
	}

}
