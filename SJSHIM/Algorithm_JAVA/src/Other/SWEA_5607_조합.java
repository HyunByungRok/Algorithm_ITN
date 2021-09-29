package Other;

import java.util.*;
import java.io.*;

public class SWEA_5607_조합 {
	static int N, R;
	static long MOD = 1234567891;
	static long factorial[];

	public static long pow(long a, long b) {
		if (b == 0) {
			return 1;
		}

		else if (b == 1) {
			return a;
		}

		// 분할정복
		if (b % 2 == 0) {
			long temp = pow(a, b / 2);
			return (temp * temp) % MOD;
		}

		long temp = pow(a, b - 1) % MOD;

		// a^(b-1) * a
		return (temp * a) % MOD;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		factorial = new long[1000001];
		factorial[0] = 1;
		for (int i = 1; i < 1000001; i++) {
			// factorial 1234567891 나눈 값으로 저장
			factorial[i] = factorial[i - 1] * i;
			factorial[i] %= MOD;
		}
		for (int t = 1; t <= T; t++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());

			// 페르마의 소정리
			long ans = (factorial[N] * pow((factorial[R] * factorial[N - R]) % MOD, MOD - 2)) % MOD;

			System.out.println("#" + t + " " + ans);
		}
	}
}
