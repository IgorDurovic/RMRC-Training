package RMRC2015;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;

public class rubiksrevenge {
	
	public static String colors = "RGBY";
	public static String cur;
	public static String solved = "RRRRGGGGBBBBYYYY";
	
	public static String move(int num, int dir, int rc) {
		
		StringBuilder sb = new StringBuilder(cur);
		if(dir == 0) {
			if(rc == 0) {
				int i = num * 4;
				char temp = sb.charAt(i + 3);
				for(; i < num * 4 + 3; i++) {
					sb.insert(i + 1, sb.charAt(i));
				}
				
				sb.insert(num * 4, temp);
			}
			else {
				int i = num;
				char temp = sb.charAt(i + 12);
				for(; i < num + 12; i += 4) {
					sb.insert(i + 4, sb.charAt(i));
				}
				
				sb.insert(num, temp);
			}
		}
		else {
			if(rc == 0) {
				int i = num * 4 + 3;
				char temp = sb.charAt(i - 3);
				for(; i > num * 4; i--) {
					sb.insert(i - 1, sb.charAt(i));
				}
				
				sb.insert(num * 4 + 3, temp);
			}
			else {
				int i = num + 12;
				char temp = sb.charAt(num);
				for(; i > num; i -= 4) {
					sb.insert(i - 4, sb.charAt(i));
				}
				
				sb.insert(num + 12, temp);
			}
		}
		
		return sb.toString();
	}
	
	public static int topDown() {
		LinkedList<String> q = new LinkedList<>();
		HashMap<String, Integer> visited = new HashMap<>();
		q.add(cur);
		
		while(!q.isEmpty()) {
			cur = q.pop();
			
			
			
			for(int num = 0; num < 4; num++) {
				for(int dir = 0; dir < 2; dir++) {
					for(int rc = 0; rc < 2; rc++) {
						String temp = move(num, dir, rc);
						if(!visited.containsKey(temp)){
							visited.put(temp, visited.get(cur) + 1);
						}
					}
				}
			}
		}
		
		return -1;
	}
	
	public static int bottomUp() {
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 4; i++) {
			sb.append(br.readLine());
		}
		
		cur = sb.toString();
		
		int sol = topDown();
		if(sol == -1) {
			sol = bottomUp();
		}
		
		pw.println(sol);
		
		pw.flush();
		pw.close();
		br.close();
		System.exit(0);
	}
}
