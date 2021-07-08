package BinarySearch;

import java.util.*;
import java.io.*;

public class BOJ_2805_나무자르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int tree[] = new int[1000000];

		int lowValue = 0;
		int highValue = 0;
		for(int i=0;i<N;i++)
		{
			tree[i] = Integer.parseInt(st.nextToken());
			if(highValue<tree[i])
			{
				highValue = tree[i];
			}
		}
		
		while(lowValue + 1 < highValue)
		{
			int midValue = (lowValue + highValue) / 2;
			
			long sum = 0;
			for(int i=0;i<N;i++)
			{
				if(tree[i] > midValue)
				{
					sum += tree[i] - midValue;
				}
			}
			
			if(M <= sum)
			{
				lowValue = midValue;
			}
			else
			{
				highValue = midValue;
			}
		}
		System.out.println(lowValue);
	}
}
