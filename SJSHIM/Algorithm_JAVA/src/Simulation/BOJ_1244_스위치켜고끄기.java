package Simulation;

import java.util.*;
import java.io.*;

public class BOJ_1244_스위치켜고끄기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int studentNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (check == 1) {
				for (int j = num; j <= n; j += num) {
					if (arr[j] == 0) {
						arr[j] = 1;
					} else {
						arr[j] = 0;
					}
				}
			} else if (check == 2) {
				int left = num, right = num;

				while (left > 0 && right <= n) {
					if (left == 1 || right == n) {
						break;
					}

					if (arr[left - 1] != arr[right + 1]) {
						break;
					}

					left -= 1;
					right += 1;
				}

				for (int j = left; j <= right; j++) {
					if (arr[j] == 0) {
						arr[j] = 1;
					} else {
						arr[j] = 0;
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			System.out.printf("%d ", arr[i]);
			if (i % 20 == 0) {
				System.out.println();
			}
		}
	}
}
