package Permutation;

import java.util.*;
import java.io.*;

public class SWEA_D4_7208_심성진 {
	static int MIN;
	static int color[];
	static int tempcolor[];
	static int map[][];
	static int N;

	static boolean isGood() {
		boolean ret = true;

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (map[y][x] == 1) {
					if (tempcolor[y] == tempcolor[x]) {
						ret = false;
						y = N;
						break;
					}
				}
			}
		}

		return ret;
	}

	static int getChanged() {
		int ret = 0;
		for (int i = 0; i < N; i++) {
			if (color[i] != tempcolor[i]) {
				ret++;
			}
		}
		return ret;
	}

	static void dfs(int cnt) {
		if (cnt == N) {
			int changed = getChanged();

			if (changed < MIN) {
				if (isGood()) {
					MIN = changed;
				}
			}

			return;
		}

		for (int i = 1; i <= 4; i++) {
			tempcolor[cnt] = i;
			dfs(cnt + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			MIN = 210000000;
			
			N = Integer.parseInt(br.readLine());

			color = new int[N];
			tempcolor = new int[N];
			map = new int[N][N];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				color[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dfs(0);

			System.out.printf("#%d %d\n", test_case, MIN);
		}
	}
}
