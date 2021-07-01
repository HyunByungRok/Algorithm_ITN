package BruteForce_Search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합_BOJ1182 {
	static int N, S, num[], count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); S = Integer.parseInt(st.nextToken());
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) num[i] = Integer.parseInt(st.nextToken());
		
		count=0;
		combi(0, 0);
		System.out.println(count);
	}
	private static void combi(int idx, int value) {
		if(value == S && idx!=0) count++;
		
		for(int i=idx; i<N; i++) {
			combi(i+1, value+num[i]);
		}
	}
}
