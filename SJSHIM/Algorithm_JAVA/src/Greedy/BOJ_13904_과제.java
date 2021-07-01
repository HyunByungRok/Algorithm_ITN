package Greedy;

import java.util.*;
import java.io.*;

public class BOJ_13904_과제 {

	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		List<work> arr = new ArrayList<work>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		// 점수가 높은 순으로 정렬
		Collections.sort(arr);
		
		int result[] = new int [1001];
		
		// 높은 점수를 획득할 수 있는 것을 순서대로 deadline에 가깝게 제출
		for (int i = 0; i < arr.size(); i++) {
			int day=arr.get(i).day;
			for (int j = day; j > 0; j--) {
				if(result[j] == 0)
				{
					result[j]=arr.get(i).score;
					break;
				}
			}
		}
		
		int ret=0;
		for (int i = 0; i < 1001; i++) {
			ret += result[i];
		}
		
		System.out.println(ret);
	}
	
	static class work implements Comparable<work>{
		int day, score;
		
		public work(int day,int score) {
			this.day = day;
			this.score = score;
		}

		@Override
		public int compareTo(work o) {
			return o.score - this.score;
		}
	}
}