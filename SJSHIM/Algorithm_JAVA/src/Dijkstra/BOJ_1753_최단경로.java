package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	public static class Data implements Comparable<Data> {
		int start, cost;

		public Data(int start, int cost) {
			this.start = start;
			this.cost = cost;
		}

		@Override
		public int compareTo(Data o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		1.데이타 입력 및 초기화 

		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		ArrayList<int[]>[] map = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			map[i] = new ArrayList<>();
		}

		int[] distance = new int[V + 1]; // 정점간의 최소 비용을 저장할 배열

//		시작 정점 
		int start = Integer.parseInt(br.readLine());

//		정점에 대한 인접 정보 입력 받기
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			map[y].add(new int[] { x, w });
		}

//		정점의 최소 비용을 갱신하기 위해 초기 값을 max로 설정한다. 
		Arrays.fill(distance, Integer.MAX_VALUE);
//		시작 정점의 비용을 0으로 설정
		distance[start] = 0;
		PriorityQueue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(start, 0));

		while (!pq.isEmpty()) {
			Data temp = pq.poll();

			int curFrom = temp.start;
			int curCost = temp.cost;

			for (int i = 0; i < map[curFrom].size(); i++) {
				int to = map[curFrom].get(i)[0];
				int toCost = map[curFrom].get(i)[1];

				if (distance[to] > toCost + curCost) {
					distance[to] = toCost + curCost;
					pq.offer(new Data(to, distance[to]));
				}
			}
		}

		for (int i = 1; i < V + 1; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(distance[i]);
			}

		}
	}

}
