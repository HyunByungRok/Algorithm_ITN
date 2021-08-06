package Permutation;

import java.util.*;
import java.io.*;

public class SWEA_test_1952_심성진 {

	static int Money[] = new int[4];
	static int month_plan[] = new int[13];
	static int min_value;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			min_value = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 4; i++) {
				Money[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());

			for (int i = 1; i <= 12; i++) {
				month_plan[i] = Integer.parseInt(st.nextToken());
			}

			dfs(1, 0);

			System.out.printf("#%d %d\n", test_case, min_value);
		}
	}

	static void dfs(int month, int money) {

		if (month > 12) {
			min_value = Math.min(min_value, money);
			return;
		}

		if (month == 1) {
			// year
			dfs(month + 12, money + Money[3]);
		}

		// day
		dfs(month + 1, money + month_plan[month] * Money[0]);

		// 1 month
		dfs(month + 1, money + Money[1]);

		// 3 month
		dfs(month + 3, money + Money[2]);
	}
}
