package DP;

import java.util.*;
import java.io.*;

public class BOJ_2193_이친수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long arr[]=new long[91];
		
		arr[1] = 1;
		arr[2] = 1;
		
		for(int i=3;i<=N;i++)
		{
			arr[i] = arr[i-1]+arr[i-2];
		}
		
		System.out.println(arr[N]);
	}
}