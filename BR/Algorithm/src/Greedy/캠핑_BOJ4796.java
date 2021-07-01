package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 캠핑_BOJ4796 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int idx = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int possible = Integer.parseInt(st.nextToken()), total = Integer.parseInt(st.nextToken()), vacation = Integer.parseInt(st.nextToken());
			if(possible == 0 && total == 0 && vacation == 0) break;
			int set = vacation/total;
			int result = possible * set;
			vacation -= set*total;
			result += Math.min(vacation, possible);
			
			System.out.println("Case " + (idx++) + ": " + result);
		}
	}
}
