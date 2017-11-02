package RMRC2015;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class classy {
	
	public static class Person implements Comparable<Person>{
		
		public static final char LOWER = '0', MIDDLE = '1', UPPER = '2';
		
		public String name;
		public String c;
		
		Person(String n, String c) {
			name = n;
			this.c = c;
		}

		@Override
		public int compareTo(Person o) {
			
			int i;
			for(i = 0; i < 10; i++) {
				if(this.c.charAt(i) > o.c.charAt(i)) {
					return 1;
				}
				else if(this.c.charAt(i) < o.c.charAt(i)) {
					return -1;
				}
			}
			
			return o.name.compareTo(this.name);
		}
		
		public static String convert(String s) {
			
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(s, "-");
			
			while(st.hasMoreTokens()) {
				String temp = st.nextToken();
				
				switch(temp) {
				case "upper":
					sb.append(UPPER);
					break;
				case "middle":
					sb.append(MIDDLE);
					break;
				case "lower":
					sb.append(LOWER);
					break;
				}
			}
			
			sb.reverse();
			
			while(sb.length() < 10) {
				sb.append(MIDDLE);
			}
			
			return sb.toString();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			Person[] people = new Person[n];
			
			for(int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), ": ");
				String name = st.nextToken();
				String c = st.nextToken();
				
				if(c.equals("class")) c = "middle";
				
				people[j] = new Person(name, Person.convert(c));
			}

			Arrays.sort(people);
			
			for(int j = n - 1; j >= 0; j--) {
				pw.println(people[j].name);
			}
			
			pw.println("==============================");
		}
		
		pw.flush();
		pw.close();
		br.close();
		System.exit(0);
	}

}
