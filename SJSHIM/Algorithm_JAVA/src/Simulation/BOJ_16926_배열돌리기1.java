package Simulation;

import java.util.*;
import java.io.*;

public class BOJ_16926_배열돌리기1 {

	static int N, M, R;
	static int[][] map;
	static int dy[] = { 0, 1, 0, -1 };
	static int dx[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		int k = Math.min(N, M) / 2;

		for (int i = 0; i < R; i++) {
			int sy = 0, sx = 0;

			int moveY = N - 1;
			int moveX = M - 1;

			for (int j = 0; j < k; j++) {
				int y = sy;
				int x = sx;

				int tempValue = map[sy][sx];

				for (int dir = 0; dir < 4; dir++) {
					int cnt = 0;

					if (dir % 2 == 0) {
						cnt = moveX;
					} else {
						cnt = moveY;
					}

					for (int l = 0; l < cnt; l++) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];

						map[y][x] = map[ny][nx];

						y = ny;
						x = nx;
					}

				}

				map[sy + 1][sx] = tempValue;

				sy += 1;
				sx += 1;

				moveY -= 2;
				moveX -= 2;
			}
		}

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				System.out.print(map[y][x] + " ");
			}
			System.out.println();
		}
	}

}
