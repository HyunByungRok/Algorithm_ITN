package Greedy;

import java.util.*;
import java.io.*;

public class BOJ_1931_회의실배정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Meet> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arr.add(new Meet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(arr);
		
		int endTime=0;
		int cnt=0;
		
		// 종료 시간, 시작 시간을 기준으로 배정 가능한 갯수 구함 
		for (int i = 0; i < arr.size(); i++) {
			if(endTime <= arr.get(i).start)
			{
				endTime = arr.get(i).end;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	static class Meet implements Comparable<Meet>{
		int start,end;
		public Meet(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		// 종료 시간을 기준으로 오름차순 정렬하고 종료 시간이 같다면 시작 시간을 기준으로 오름차순 정렬한다.
		public int compareTo(Meet o) {
			if(this.end == o.end) {
				return this.start - o.start;
			}
			else
			{
				return this.end - o.end;	
			}
		}
	}
}