package Greedy;

import java.util.*;
import java.io.*;

public class Main_문제은행_1828_ {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<ref> list = new ArrayList<>(N);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int minnum = Integer.parseInt(st.nextToken());
			int maxnum = Integer.parseInt(st.nextToken());

			list.add(new ref(minnum, maxnum));
		}

		Collections.sort(list);

		int ans = 1;
		int maxValue = list.get(0).maxNum;
		for (int i = 1; i < N; i++) {
			if (maxValue < list.get(i).minNum) {
				maxValue = list.get(i).maxNum;
				ans++;
			}
		}
		System.out.println(ans);
	}

	static public class ref implements Comparable<ref> {
		int minNum, maxNum;

		public ref(int minNum, int maxNum) {
			this.minNum = minNum;
			this.maxNum = maxNum;
		}

		@Override
		public int compareTo(ref o) {
			return maxNum - o.maxNum;
		}
	}

}
