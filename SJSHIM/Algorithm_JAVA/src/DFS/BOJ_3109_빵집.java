package DFS;

import java.util.*;

import java.io.*;

public class BOJ_3109_빵집 {
	static int R, C;
	static char[][] board;

	static int dy[] = { -1, 0, 1 };
	static int dx[] = { 1, 1, 1 };
	static boolean flag;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];

		for (int y = 0; y < R; y++) {
			String temp = br.readLine();
			for (int x = 0; x < C; x++) {
				board[y][x] = temp.charAt(x);
			}
		}
		ans = 0;
		for (int y = 0; y < R; y++) {
			flag = false;
			dfs(y, 0);
		}
		System.out.println(ans);
	}

	static void dfs(int y, int x) {
		if (flag == true) {
			return;
		}

		if (x == C - 1) {
			flag = true;
			ans++;
			return;
		}

		for (int dir = 0; dir < 3; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];

			if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
				continue;
			}

			if (board[ny][nx] == '.') {
				board[ny][nx] = 'x';
				dfs(ny, nx);
				if (flag == true) {
					return;
				}
//				board[ny][nx] = '.';
			}
		}
	}

}
