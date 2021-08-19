package DevideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_Intermediate_Coder_1335 {

	static int[][] board;
	static int ans[] = new int[2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		board = new int[N][N];

		ans[0] = 0;
		ans[1] = 0;

		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				board[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		devide(0, 0, N);

		for (int i = 0; i < 2; i++) {
			System.out.println(ans[i]);
		}
	}

	static boolean check(int starty, int startx, int n) {
		for (int y = starty; y < starty + n; y++) {
			for (int x = startx; x < startx + n; x++) {
				if (board[starty][startx] != board[y][x]) {
					return false;
				}
			}
		}
		return true;
	}

	static void devide(int starty, int startx, int n) {
		if (check(starty, startx, n)) {
			ans[board[starty][startx]]++;
			return;
		}

		// 왼쪽 위
		devide(starty, startx, n / 2);
		// 오른쪽 위
		devide(starty, startx + n / 2, n / 2);
		// 왼쪽 아래
		devide(starty + n / 2, startx, n / 2);
		// 오른쪽 아래
		devide(starty + n / 2, startx + n / 2, n / 2);

	}
}
