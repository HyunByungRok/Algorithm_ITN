package DFS;

import java.util.*;
import java.io.*;

public class BOJ_1260_DFS와BFS {

	static boolean board[][];
	static boolean visited[];
	static int N, M, V;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		board = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			board[y][x] = true;
			board[x][y] = true;
		}

		dfs(V);
		System.out.println();
		for (int i = 0; i < N + 1; i++) {
			visited[i] = false;
		}
		bfs(V);
	}

	static void dfs(int v) {
		if (visited[v] == true) {
			return;
		}

		visited[v] = true;
		System.out.print(v + " ");
		for (int i = 1; i <= N; i++) {
			if (board[v][i]) {
				dfs(i);
			}
		}
	}

	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		System.out.print(v + " ");
		visited[v] = true;
		q.add(v);
		while (!q.isEmpty()) {
			int y = q.poll();
			for (int i = 1; i <= N; i++) {
				if (board[y][i] && visited[i] == false) {
					visited[i] = true;
					System.out.print(i + " ");
					q.add(i);
				}
			}
		}

	}

}
