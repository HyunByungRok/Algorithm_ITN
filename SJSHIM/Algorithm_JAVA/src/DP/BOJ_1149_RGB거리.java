package DP;

import java.util.*;
import java.io.*;

public class BOJ_1149_RGB거리 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] house = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			house[i][0] = Math.min(house[i - 1][1], house[i - 1][2]) + Integer.parseInt(st.nextToken());
			house[i][1] = Math.min(house[i - 1][0], house[i - 1][2]) + Integer.parseInt(st.nextToken());
			house[i][2] = Math.min(house[i - 1][0], house[i - 1][1]) + Integer.parseInt(st.nextToken());
		}

		System.out.println(Math.min(house[N][0], Math.min(house[N][1], house[N][2])));
	}

}
