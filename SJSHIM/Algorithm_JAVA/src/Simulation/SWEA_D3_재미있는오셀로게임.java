package Simulation;

import java.io.*;
import java.util.*;

public class SWEA_D3_재미있는오셀로게임 {

	static int N, M;
	static int[][] board;
	static int dy[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int dx[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			board = new int[N][N];

			board[(N / 2) - 1][(N / 2) - 1] = 2;
			board[(N / 2) - 1][(N / 2)] = 1;
			board[(N / 2)][(N / 2) - 1] = 1;
			board[(N / 2)][(N / 2)] = 2;

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				simulation(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
						Integer.parseInt(st.nextToken()));
			}

			int ans[] = new int[2];
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (board[y][x] == 1) {
						ans[0]++;
					} else if (board[y][x] == 2) {
						ans[1]++;
					}
				}
			}
			System.out.println("#" + test_case + " " + ans[0] + " " + ans[1]);
		}

	}

	static void simulation(int y, int x, int color) {
		board[y][x] = color;
		for (int dir = 0; dir < 8; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];

			if (ny < 0 || nx < 0 || nx >= N || ny >= N) {
				continue;
			}

			int idx = 1;
			int cnt = 0;
			boolean check = false;

			while (board[ny][nx] != 0) {
				if (board[ny][nx] != color) {
					cnt++;
				} else {
					check = true;
					break;
				}

				ny = y + dy[dir] * idx;
				nx = x + dx[dir] * idx++;

				if (ny < 0 || nx < 0 || nx >= N || ny >= N) {
					break;
				}
			}

			if (check) {
				for (int i = 1; i < cnt; i++) {
					ny = y + dy[dir] * i;
					nx = x + dx[dir] * i;

					board[ny][nx] = color;
				}
			}
		}
	}
}
