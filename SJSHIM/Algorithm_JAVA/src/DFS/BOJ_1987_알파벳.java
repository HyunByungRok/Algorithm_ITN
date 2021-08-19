package DFS;

import java.util.*;
import java.io.*;

public class BOJ_1987_알파벳 {
	static int R, C;
	static int[][] board;
	static boolean select[];

	static int dy[] = { 0, 0, -1, 1 };
	static int dx[] = { 1, -1, 0, 0 };

	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new int[R][C];
		select = new boolean[26];

		for (int y = 0; y < R; y++) {
			String temp = br.readLine();
			for (int x = 0; x < temp.length(); x++) {
				board[y][x] = temp.charAt(x) - 'A';
			}
		}

		select[board[0][0]] = true;
		ans = 0;
		dfs(0, 0, 1);

		System.out.println(ans);
	}

	static void dfs(int y, int x, int cnt) {
		if (ans < cnt) {
			ans = cnt;
		}

		for (int dir = 0; dir < 4; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];

			if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
				continue;
			}

			if (select[board[ny][nx]] == false) {
				select[board[ny][nx]] = true;
				dfs(ny, nx, cnt + 1);
				select[board[ny][nx]] = false;
			}
		}

	}
}