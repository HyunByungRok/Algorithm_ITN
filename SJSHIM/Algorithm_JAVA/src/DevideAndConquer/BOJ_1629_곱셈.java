package DevideAndConquer;

import java.util.*;
import java.io.*;

public class BOJ_1629_곱셈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A,B,C;
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		long ret = dfs(A,B,C)%C; 
		
		System.out.println(ret);
	}
	
	static long dfs(long A, long B, long C)
	{
		if(B == 1)
		{
			return (A % C);
		}
		else if(B % 2 == 0)
		{
			long temp = dfs(A,B/2,C);
			return (temp * temp) % C;
		}
		else
		{
			long temp = dfs(A,B-1,C);
			return (A * temp) % C;
		}
	}
}
