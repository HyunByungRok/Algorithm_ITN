package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1463_1로만들기 {
	static int dp[] = new int[1000001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= N; i++) {
			dp[i] = -1;
		}
		
		int ret = dpfunc(N);
		
		System.out.println(ret);
	}
	
	// top - down 방식
	static int dpfunc(int n)
	{
		if(n == 1) {
			return 0;
		}
		if(dp[n] != -1) {
			return dp[n];
		}
		
		int ret = dpfunc(n-1) + 1;
		
		if(n%3 == 0) {
			int temp = dpfunc(n/3)+1;
			if(temp < ret)
			{
				ret=temp;
			}
		}
		if(n%2 == 0) {
			int temp = dpfunc(n/2)+1;
			if(temp < ret)
			{
				ret=temp;
			}
		}
		dp[n] = ret;
		
		return ret;
	}
}
