package DFS;

import java.util.*;
import java.io.*;

public class BOJ_17070_파이프옮기기1 {

	// 가로, 대각선, 세로
	static int dy[] = { 0, 1, 1 };
	static int dx[] = { 1, 1, 0 };
	static int N;
	static int[][] board;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		board = new int[N][N];

		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				board[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 1, 0);

		System.out.println(ans);
	}

	public static void dfs(int y, int x, int dir) {
		// 가로
		if (dir == 0) {
			for (int d = 0; d < 2; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (d == 1) {
					if (ny < 0 || ny >= N || nx < 0 || nx >= N || board[ny][nx] == 1 || board[ny - 1][nx] == 1
							|| board[ny][nx - 1] == 1) {
						continue;
					}
				} else {
					if (ny < 0 || ny >= N || nx < 0 || nx >= N || board[ny][nx] == 1) {
						continue;
					}
				}

				if (ny == N - 1 && nx == N - 1) {
					ans++;
				} else {
					dfs(ny, nx, d);
				}
			}
		}

		// 대각선
		else if (dir == 1) {
			for (int d = 0; d < 3; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (d == 1) {
					if (ny < 0 || ny >= N || nx < 0 || nx >= N || board[ny][nx] == 1 || board[ny - 1][nx] == 1
							|| board[ny][nx - 1] == 1) {
						continue;
					}
				} else {
					if (ny < 0 || ny >= N || nx < 0 || nx >= N || board[ny][nx] == 1) {
						continue;
					}
				}

				if (ny == N - 1 && nx == N - 1) {
					ans++;
				} else {
					dfs(ny, nx, d);
				}
			}
		}

		// 세로
		else if (dir == 2) {
			for (int d = 1; d < 3; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (d == 1) {
					if (ny < 0 || ny >= N || nx < 0 || nx >= N || board[ny][nx] == 1 || board[ny - 1][nx] == 1
							|| board[ny][nx - 1] == 1) {
						continue;
					}
				} else {
					if (ny < 0 || ny >= N || nx < 0 || nx >= N || board[ny][nx] == 1) {
						continue;
					}
				}

				if (ny == N - 1 && nx == N - 1) {
					ans++;
				} else {
					dfs(ny, nx, d);
				}
			}
		}
	}

}
