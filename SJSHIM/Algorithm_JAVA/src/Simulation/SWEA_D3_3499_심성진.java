package Simulation;

import java.util.*;
import java.io.*;

public class SWEA_D3_3499_심성진 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			int N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());

			String[] arr = new String[N];

			for (int i = 0; i < N; i++) {
				arr[i] = st.nextToken();
			}

			StringBuilder sb = new StringBuilder();

			int half1 = 0, half2 = 0;
			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					sb.append(arr[half1++] + " ");
				} else {
					sb.append(arr[((N + 1) / 2) + half2++] + " ");
				}
			}

			System.out.printf("#%d " + sb + "\n", testcase);
		}
	}

}
