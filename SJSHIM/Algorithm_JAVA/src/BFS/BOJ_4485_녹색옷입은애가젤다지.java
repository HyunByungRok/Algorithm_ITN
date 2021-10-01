package BFS;

import java.util.*;
import java.io.*;

public class BOJ_4485_녹색옷입은애가젤다지 {

	static int board[][];
	static int visited[][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) {
				return;
			}

			board = new int[N][N];
			visited = new int[N][N];

			for (int y = 0; y < N; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++) {
					board[y][x] = Integer.parseInt(st.nextToken());
					visited[y][x] = Integer.MAX_VALUE;
				}
			}

			Queue<Pos> q = new LinkedList<>();
			q.add(new Pos(0, 0));
			visited[0][0] = board[0][0];

			while (!q.isEmpty()) {
				Pos cur = q.poll();

				for (int dir = 0; dir < 4; dir++) {
					int ny = cur.y + dy[dir];
					int nx = cur.x + dx[dir];

					if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
						if (visited[ny][nx] > visited[cur.y][cur.x] + board[ny][nx]) {
							visited[ny][nx] = visited[cur.y][cur.x] + board[ny][nx];
							q.add(new Pos(ny, nx));
						}
					}
				}
			}

			System.out.println("Problem " + tc + ": " + visited[N - 1][N - 1]);
			tc++;
		}

	}

	static public class Pos {
		int y, x;

		/**
		 * @param y
		 * @param x
		 */
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
