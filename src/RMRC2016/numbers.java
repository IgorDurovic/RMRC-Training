package RMRC2016;

import java.io.*;
import java.util.Scanner;

public class numbers {

	public static String num;
	public static int sum;

	public static void makeNicer(int n) {

		StringBuilder sb = new StringBuilder(num);

		if (n == 8) {
			sum = 0;
			for (char c : num.toCharArray()) {
				sum += (c - '0');
			}

			while (sum != Integer.highestOneBit(sum)) {
				sb.append('8');
				sum += 8;
			}

			num = sb.toString();
			return;
		}

		sum = 0;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) - '0' > n) {
				if (sum % (n * 2) != 0) {
					sb.insert(i, n);
					i++;
				}

				sum = 0;
			} else {
				sum += (sb.charAt(i) - '0');
			}
		}

		if (sum % (n * 2) != 0) {
			sb.append(n);
		}

		num = sb.toString();
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);

		int T = in.nextInt();

		for (int i = 0; i < T; i++) {
			num = in.next();
			sum = 0;

			if (!num.equals("22") && num.length() != 1) {
				makeNicer(2);
				makeNicer(4);
				makeNicer(8);
			}

			out.println(num);
		}

		out.flush();
		out.close();
		in.close();
	}
}
