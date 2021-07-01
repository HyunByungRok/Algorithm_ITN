package brute_force;

import java.util.*;
import java.io.*;

public class BOJ_1182_부분수열 {
	static int target, size, ret;
	static int arr[];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		size = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
		arr = new int [size];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0,0);
		
		System.out.println(ret);
	}
	
	static void dfs(int sum,int idx,int cnt)
	{
		if(idx >= size)
		{
			if(sum == target && cnt != 0)
			{
				ret++;	
			}
			return;
		}
		
		dfs(sum+arr[idx],idx+1,cnt+1);
		dfs(sum,idx+1,cnt);
	}
}