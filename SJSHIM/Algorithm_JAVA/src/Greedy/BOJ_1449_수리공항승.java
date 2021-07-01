package Greedy;

import java.util.*;
import java.io.*;

public class BOJ_1449_수리공항승 {
	static int N,L;
	static List<Integer> arr=new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(arr);
		
		int tapePoint=-1;
		int cnt=0;
		for (int i = 0; i < arr.size(); i++) {
			if(tapePoint < arr.get(i)) {
				tapePoint = arr.get(i)+L-1; 
				cnt++;
			}
		}
		// 정렬 후 가장 왼쪽부터 차례대로 테이프 범위를 확인
		
		System.out.println(cnt);
	}
}