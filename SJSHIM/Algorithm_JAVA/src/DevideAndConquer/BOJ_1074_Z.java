package DevideAndConquer;

import java.util.*;
import java.io.*;

public class BOJ_1074_Z {
	static int cnt, Y, X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		cnt = 0;
		devide(0, 0, 1 << N, cnt);
	}

	static void devide(int y, int x, int n, int cnt) {
		if (n == 1) {
			if (y == Y && x == X) {
				System.out.println(cnt);
			}
			return;
		}

		if (Y >= y && X >= x && Y < y + n / 2 && X < x + n / 2) {
			devide(y, x, n / 2, cnt);
		}
		if (Y >= y && X >= x + n / 2 && Y < y + n / 2 && X < x + n / 2 + n / 2) {
			if (n == 1) {
				devide(y, x + n / 2, n / 2, cnt + 1);
			} else {
				devide(y, x + n / 2, n / 2, cnt + (n * n) / 4);
			}
		}
		if (Y >= y + n / 2 && X >= x && Y < y + n / 2 + n / 2 && X < x + n / 2) {
			if (n == 1) {
				devide(y, x + n / 2, n / 2, cnt + 2);
			} else {
				devide(y + n / 2, x, n / 2, cnt + (n * n) / 4 * 2);
			}
		}
		if (Y >= y + n / 2 && X >= x + n / 2 && Y < y + n / 2 + n / 2 && X < x + n / 2 + n / 2) {
			if (n == 1) {
				devide(y, x + n / 2, n / 2, cnt + 3);
			} else {
				devide(y + n / 2, x + n / 2, n / 2, cnt + (n * n) / 4 * 3);
			}
		}
	}
}