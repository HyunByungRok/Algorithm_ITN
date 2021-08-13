package DFS;

import java.util.*;
import java.io.*;

public class BOJ_1062_가르침 {
	static boolean alpha[];
	static String strArr[];
	static int N, K, ans;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		alpha = new boolean[26];

		alpha['a' - 'a'] = true;
		alpha['n' - 'a'] = true;
		alpha['t' - 'a'] = true;
		alpha['i' - 'a'] = true;
		alpha['c' - 'a'] = true;

		ans = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		strArr = new String[N];

		for (int i = 0; i < N; i++) {
			strArr[i] = br.readLine();
		}

		comb(0, 5);

		System.out.println(ans);
	}

	static void comb(int start, int cnt) {
		if (cnt >= K) {
			if (K < 5) {
				return;
			}

			int read = 0;
			for (int i = 0; i < N; i++) {
				int end = strArr[i].length();
				boolean add = true;
				for (int j = 0; j < end; j++) {
					if (alpha[strArr[i].charAt(j) - 'a'] == false) {
						add = false;
						break;
					}
				}
				if (add) {
					read++;
				}
			}
			ans = Math.max(read, ans);

			return;
		}

		for (int i = start; i < 26; i++) {
			if (alpha[i] == false) {
				alpha[i] = true;
				comb(i, cnt + 1);
				alpha[i] = false;
			}
		}
	}

}
