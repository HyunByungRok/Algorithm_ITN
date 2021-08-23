package Simulation;

import java.util.*;
import java.io.*;

public class BOJ_3985_롤케이크 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		boolean cake[] = new boolean[L + 1];

		int max = 0, expectMax = 0;
		int expectMan = 0, realMan = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cnt = 0;
			int expectCnt = end - start + 1;
			for (int j = start; j <= end; j++) {
				if (cake[j] == false) {
					cake[j] = true;
					cnt++;
				}
			}
			if (max < cnt) {
				max = cnt;
				realMan = i + 1;
			}
			if (expectMax < expectCnt) {
				expectMax = expectCnt;
				expectMan = i + 1;
			}
		}

		System.out.println(expectMan);
		System.out.println(realMan);

	}
}
