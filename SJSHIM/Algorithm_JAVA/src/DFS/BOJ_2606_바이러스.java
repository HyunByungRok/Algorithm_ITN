package DFS;

import java.util.*;
import java.io.*;

public class BOJ_2606_바이러스 {

	static boolean visited[];
	static boolean[][] network;
	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		network = new boolean[N + 1][N + 1];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			network[y][x] = true;
			network[x][y] = true;
		}
		visited = new boolean[N + 1];

		bfs();

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (visited[i]) {
				ans++;
			}
		}

		System.out.println(ans - 1);
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();

		visited[1] = true;

		q.add(1);

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 1; i <= N; i++) {
				int ny = cur;
				int nx = i;

				if (visited[nx] == false && network[ny][nx] == true) {
					visited[nx] = true;
					q.add(nx);
				}
			}
		}
	}
}