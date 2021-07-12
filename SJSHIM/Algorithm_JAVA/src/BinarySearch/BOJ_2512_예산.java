package BinarySearch;

import java.util.*;
import java.io.*;

public class BOJ_2512_예산 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		
		StringTokenizer st =new StringTokenizer(br.readLine());
				
		int highValue=0;
		int lowValue=1;
		int arrHighValue=0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arrHighValue<arr[i])
			{
				arrHighValue=arr[i];
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		
		highValue=arrHighValue;
		int answer=0;
		
		while(lowValue <= highValue) {
			int midValue=(lowValue+highValue)/2;
			int sum=0;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] >= midValue) {
					sum+=midValue;
				}
				else
				{
					sum+=arr[i];
				}
			}
			if(M >= sum)
			{
				lowValue=midValue+1;
				answer = Math.max(answer, midValue);
			}else
			{
				highValue=midValue-1;
			}
		}
		
		System.out.println(answer);
	}
}
