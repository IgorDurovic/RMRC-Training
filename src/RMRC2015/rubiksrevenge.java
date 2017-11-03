package RMRC2015;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class rubiksrevenge {

	public static String colors = "RGBY";
	public static String cur;
	public static String solved = "RRRRGGGGBBBBYYYY";

	public static HashSet<String> mid;

	public static String move(int num, int dir, int rc) {

		StringBuilder sb = new StringBuilder(cur);
		if (dir == 0) {
			if (rc == 0) {
				int i = num * 4;
				String temp = sb.charAt(i) + "";
				for (; i < num * 4 + 3; i++) {
					sb.replace(i, i + 1, sb.substring(i + 1, i + 2));
					//abcd
					//bcda
				}

				sb.replace(i, i + 1, temp);
			} else {
				int i = num;
				String temp = sb.charAt(i) + "";
				for (; i < num + 12; i += 4) {
					sb.replace(i, i + 1, sb.substring(i + 4, i + 5));
					//a d
					//b a
					//c b
					//d c
				}

				sb.replace(num + 12, num + 13, temp);
			}
		} else {
			if (rc == 0) {
				int i = num * 4 + 3;
				String temp = sb.charAt(i) + "";
				for (; i > num * 4; i--) {
					sb.replace(i, i + 1, sb.substring(i - 1, i));
					//abcd
					//dabc
				}

				sb.replace(i, i + 1, temp);
			} else {
				int i = num + 12;
				String temp = sb.charAt(i) + "";
				for (; i > num; i -= 4) {
					sb.replace(i, i + 1, sb.substring(i - 4, i - 3));
					//a b 
					//b c
					//c d
					//d a
				}

				sb.replace(num, num + 1, temp);
			}
		}

		return sb.toString();
	}

	public static int topDown() {
		LinkedList<String> q = new LinkedList<>();
		HashMap<String, Integer> visited = new HashMap<>();
		q.add(cur);
		visited.put(cur, 0);

		while (!q.isEmpty()) {
			cur = q.pop();

			if (cur.equals(solved))
				break;

			if (visited.get(cur) == 6) {
				mid.add(cur);
				continue;
			}

			for (int num = 0; num < 4; num++) {
				for (int dir = 0; dir < 2; dir++) {
					for (int rc = 0; rc < 2; rc++) {
						String temp = move(num, dir, rc);
						if (!visited.containsKey(temp)) {
							visited.put(temp, visited.get(cur) + 1);
							q.add(temp);
						}
					}
				}
			}
		}

		if (cur.equals(solved)) {
			return visited.get(cur);
		}

		return -1;
	}

	public static int bottomUp() {		
		LinkedList<String> q = new LinkedList<>();
		HashMap<String, Integer> visited = new HashMap<>();
		q.add(solved);
		visited.put(solved, 0);
		
		while(!q.isEmpty()) {
			cur = q.pop();
			
			if(mid.contains(cur)) break;
			
			if(visited.get(cur) == 7) break;
			
			for(int num = 0; num < 4; num++) {
				for(int dir = 0; dir < 2; dir++) {
					for(int rc = 0; rc < 2; rc++) {
						String temp = move(num, dir, rc);
						if(!visited.containsKey(temp)){
							visited.put(temp, visited.get(cur) + 1);
							q.add(temp);
						}
					}
				}
			}
		}
		
		if(mid.contains(cur)) {
			return 6 + visited.get(cur);
		}
		
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			sb.append(br.readLine());
		}

		cur = sb.toString();
		mid = new HashSet<>();
		
		//System.out.println(move(0, 1, 1));
		//System.out.println(move(1, 1, 1));
		//System.out.println(move(2, 1, 1));

		int sol = topDown();
		if (sol == -1) {
			sol = bottomUp();
		}
		
		if(sol == -1) {
			pw.println(13);
		}
		else{
			pw.println(sol);
		}

		pw.flush();
		pw.close();
		br.close();
		System.exit(0);
	}
}
