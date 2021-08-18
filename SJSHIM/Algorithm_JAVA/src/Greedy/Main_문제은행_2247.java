package Greedy;

import java.util.*;
import java.io.*;

public class Main_문제은행_2247 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Lib> list = new ArrayList<>(N);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sTime = Integer.parseInt(st.nextToken());
			int eTime = Integer.parseInt(st.nextToken());

			list.add(new Lib(sTime, eTime));
		}

		Collections.sort(list);
		int sTime = list.get(0).stime;
		int eTime = list.get(0).etime;
		int remainTime = 0;
		int nonRemainTime=0;
		for (int i = 1; i < N; i++) {
			if (eTime >= list.get(i).stime) {
				eTime = Math.max(eTime, list.get(i).etime);
				remainTime = Math.max(remainTime, eTime - sTime);
			} else {
				nonRemainTime=Math.max(nonRemainTime, list.get(i).stime - eTime);
				sTime = list.get(i).stime;
				eTime = list.get(i).etime;
			}
		}

		System.out.println(remainTime + " " + nonRemainTime);
	}

	static class Lib implements Comparable<Lib> {
		int stime;
		int etime;

		public Lib(int stime, int etime) {
			this.stime = stime;
			this.etime = etime;
		}

		@Override
		public int compareTo(Lib o) {
			int time = stime - o.stime;

			return time;
		}
	}

}
