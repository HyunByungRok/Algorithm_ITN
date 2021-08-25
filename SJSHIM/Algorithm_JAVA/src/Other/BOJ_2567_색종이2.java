package Other;

import java.util.*;
import java.io.*;

public class BOJ_2567_색종이2 {

	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean board[][] = new boolean[101][101];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tempy = Integer.parseInt(st.nextToken());
			int tempx = Integer.parseInt(st.nextToken());

			for (int y = tempy; y < tempy + 10; y++) {
				for (int x = tempx; x < tempx + 10; x++) {
					board[y][x] = true;
				}
			}
		}

		int cnt = 0;
		for (int y = 1; y <= 100; y++) {
			for (int x = 1; x <= 100; x++) {
				if (board[y][x] == true) {
					for (int dir = 0; dir < 4; dir++) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];

						if (board[ny][nx] == false) {
							cnt++;
						}
					}
				}
			}

		}
		System.out.println(cnt);
	}

}
