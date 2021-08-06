package Combination;

import java.util.*;
import java.io.*;

public class SWEA_D3_5215_심성진 {

	static int N, L, T, maxValue, tas[], cal[];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			tas = new int[N];
			cal = new int[N];

			maxValue = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				tas[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}

			per(0, 0, 0);

			System.out.printf("#%d %d\n", test_case, maxValue);
		}
	}

	static void per(int start, int sumCal, int sumTas) {
		if (sumCal > L) {
			return;
		} else {
			if (sumTas > maxValue) {
				maxValue = sumTas;
			}
		}

		for (int i = start; i < N; i++) {
			per(i + 1, sumCal + cal[i], sumTas + tas[i]);
		}
	}

}
