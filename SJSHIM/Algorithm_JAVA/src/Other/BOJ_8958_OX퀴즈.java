package Other;

import java.util.*;
import java.io.*;

public class BOJ_8958_OX퀴즈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();

			int ans = 0;
			int plusScore = 0;
			for (int j = 0; j < temp.length(); j++) {
				if (temp.charAt(j) == 'O') {
					plusScore++;
				} else {
					plusScore = 0;
				}
				ans += plusScore;
			}
			System.out.println(ans);
		}

	}

}
