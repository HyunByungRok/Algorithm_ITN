package Greedy;

import java.util.*;
import java.io.*;

public class BOJ_11000_강의실배정 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Time> arr = new ArrayList<Time>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr.add(new Time(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(arr);
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int cnt=1;
		pq.add(arr.get(0).end);
		
		// 우선순위 큐를 사용해 큐의 사이즈가 늘어날 때 마다 강의실이 늘어나며 큐에 입력돼있는 종료 시간과 정렬된 배열의 시작 시간을 비교하여 값을 갱신할지 강의실을 추가할지 판단 가능
		for (int i = 1; i < arr.size(); i++) {
			if(pq.peek() <= arr.get(i).start) {
				pq.poll();
				pq.add(arr.get(i).end);
			}
			else
			{
				cnt++;
				pq.add(arr.get(i).end);
			}
		}
		System.out.println(cnt);
	}

	// 시작 시간을 기준으로 오름차순 정렬하고 시작 시간이 같다면 종료 시간을 기준으로 오름차순 정렬
	static class Time implements Comparable<Time>{
		int start, end;

		public Time(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Time o) {
			if(this.start == o.start) {
				return this.end - o.end;
			}
			else
			{
				return this.start - o.start;
			}
		}
	}
}
