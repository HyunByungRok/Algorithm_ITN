package Other;

import java.util.*;
import java.io.*;

public class SWEA_1209_Sum {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = Integer.parseInt(br.readLine());

			int board[][] = new int[100][100];
			for (int y = 0; y < 100; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int x = 0; x < 100; x++) {
					board[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			int maxValue = 0;

			for (int y = 0; y < 100; y++) {
				int sum = 0;
				for (int x = 0; x < 100; x++) {
					sum += board[y][x];
				}
				if (y == 0) {
					maxValue = sum;
				} else {
					maxValue = Math.max(maxValue, sum);
				}
			}

			for (int x = 0; x < 100; x++) {
				int sum = 0;
				for (int y = 0; y < 100; y++) {
					sum += board[y][x];
				}

				maxValue = Math.max(maxValue, sum);
			}

			int crossSum = 0;
			for (int i = 0; i < 100; i++) {
				crossSum += board[i][i];
			}
			maxValue = Math.max(maxValue, crossSum);

			crossSum = 0;
			int tempy = 0;
			int tempx = 99;
			for (int i = 0; i < 100; i++) {
				crossSum += board[tempy + i][tempx - i];
			}
			maxValue = Math.max(maxValue, crossSum);

			System.out.println("#" + test_case + " " + maxValue);
		}
	}

}
