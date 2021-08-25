package Other;

import java.util.*;
import java.io.*;

public class BOJ_10817_세수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] num = new int[3];

		for (int i = 0; i < 3; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		System.out.println(num[1]);
	}

}
