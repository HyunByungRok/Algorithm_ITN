package BFS;

import java.util.*;
import java.io.*;

public class BOJ_1303_전쟁전투 {

	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static boolean[][] visited;
	static char[][] board;
	static int cnt = 0;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[M][N];
		visited = new boolean[M][N];
		int ans[] = new int[2];

		for (int y = 0; y < M; y++) {
			String temp = br.readLine();
			for (int x = 0; x < N; x++) {
				board[y][x] = temp.charAt(x);
			}
		}

		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N; x++) {
				if (visited[y][x] == false) {
					cnt = 0;
					bfs(y, x);
					if (board[y][x] == 'W') {
						ans[0] += cnt * cnt;
					} else {
						ans[1] += cnt * cnt;
					}
				}
			}
		}

		System.out.println(ans[0] + " " + ans[1]);
	}

	public static void bfs(int y, int x) {
		Queue<Point> q = new LinkedList<>();

		Point p = new Point(y, x);
		q.add(p);
		cnt++;
		visited[y][x] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int ny = cur.y + dy[dir];
				int nx = cur.x + dx[dir];

				if (ny < 0 || ny >= M || nx < 0 || nx >= N) {
					continue;
				}

				if (board[y][x] == board[ny][nx] && visited[ny][nx] == false) {
					visited[ny][nx] = true;
					cnt++;
					Point next = new Point(ny, nx);
					q.add(next);
				}
			}
		}
	}

	public static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
