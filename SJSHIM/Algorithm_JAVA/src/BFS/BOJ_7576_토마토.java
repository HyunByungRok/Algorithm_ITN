package BFS;

import java.util.*;
import java.io.*;

public class BOJ_7576_토마토 {

	static int[][] board;
	static int dy[] = { 0, 0, -1, 1 };
	static int dx[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Queue<Point> q = new LinkedList<>();
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		boolean allRipen = true;

		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				board[y][x] = Integer.parseInt(st.nextToken());
				if (board[y][x] == 0) {
					allRipen = false;
				}

				if (board[y][x] == 1) {
					q.add(new Point(y, x, 1));
				}
			}
		}

		if (allRipen) {
			System.out.println(0);
			return;
		}

		// 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int ny = cur.y + dy[dir];
				int nx = cur.x + dx[dir];
				int nValue = cur.value + 1;

				if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
					continue;
				}

				if (board[ny][nx] == 0) {
					board[ny][nx] = nValue;
					q.add(new Point(ny, nx, nValue));
				}
			}
		}
		int maxValue = 1;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (board[y][x] == 0) {
					System.out.println(-1);
					return;
				} else {
					if (board[y][x] > maxValue) {
						maxValue = board[y][x];
					}
				}
			}
		}

		System.out.println(maxValue - 1);

	}

	public static class Point {
		int y, x, value;

		/**
		 * @param y
		 * @param x
		 */
		public Point(int y, int x, int value) {
			this.y = y;
			this.x = x;
			this.value = value;
		}
	}
}
