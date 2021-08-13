package DevideAndConquer;

import java.util.*;
import java.io.*;

public class BOJ_1992_쿼드트리_심성진 {

	static int[][] board;

	static String[] ans;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		board = new int[N][N];

		for (int y = 0; y < N; y++) {
			String str = br.readLine();
			for (int x = 0; x < N; x++) {
				board[y][x] = str.charAt(x) - '0';
			}
		}

		Quard(0, 0, N);
	}

	static boolean check(int sy, int sx, int n) {
		boolean ret = true;

		top: for (int y = sy; y < sy + n; y++) {
			for (int x = sx; x < sx + n; x++) {
				if (board[sy][sx] != board[y][x]) {
					ret = false;
					break top;
				}
			}
		}

		return ret;
	}

	static void Quard(int sy, int sx, int n) {
		if (true == check(sy, sx, n)) {
			System.out.print(board[sy][sx]);
			return;
		}

		System.out.print("(");

		// 왼쪽 위
		Quard(sy, sx, n / 2);

		// 오른쪽 위
		Quard(sy, sx + n / 2, n / 2);

		// 왼쪽 아래
		Quard(sy + n / 2, sx, n / 2);

		// 오른쪽 아래
		Quard(sy + n / 2, sx + n / 2, n / 2);

		System.out.print(")");
	}
}
