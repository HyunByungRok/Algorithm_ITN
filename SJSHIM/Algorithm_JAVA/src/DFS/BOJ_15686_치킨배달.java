package DFS;

import java.util.*;
import java.io.*;

public class BOJ_15686_치킨배달 {

	static int N, M, houseIdx, ans;
	static int map[][];
	static int chicken[][];
	static int house[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		chicken = new int[M][2];
		house = new int[2 * N][2];

		ans = Integer.MAX_VALUE;
		houseIdx = 0;
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == 1) {
					house[houseIdx][0] = y;
					house[houseIdx][1] = x;
					houseIdx++;
				}
			}
		}

		comb(0, 0, 0);

		System.out.println(ans);
	}

	static void comb(int starty, int startx, int cnt) {
		if (cnt == M) {
			// 구현
			int candiAns = 0;

			for (int i = 0; i < houseIdx; i++) {
				int minDistance = Integer.MAX_VALUE;
				for (int j = 0; j < cnt; j++) {
					int distance = Math.abs(house[i][0] - chicken[j][0]) + Math.abs(house[i][1] - chicken[j][1]);
					if (distance < minDistance) {
						minDistance = distance;
					}
				}
				candiAns += minDistance;
			}

			if (candiAns < ans) {
				ans = candiAns;
			}

			return;
		}
		int x = startx;

		for (int y = starty; y < N; y++) {
			for (x = startx; x < N; x++) {
				if (map[y][x] == 2) {
					chicken[cnt][0] = y;
					chicken[cnt][1] = x;
					comb(y, x + 1, cnt + 1);
				}
			}
			startx = 0;
		}

	}

}
