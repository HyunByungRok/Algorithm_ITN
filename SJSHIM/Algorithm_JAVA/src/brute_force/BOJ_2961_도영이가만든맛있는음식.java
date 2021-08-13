package brute_force;

import java.util.*;
import java.io.*;

class Taste {
	int sour, bitter;

}

public class BOJ_2961_도영이가만든맛있는음식 {

	static int N;
	static Taste arr[];
	static List<Taste> list;

	static int ans;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new Taste[N];
		list = new LinkedList<>();
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Taste();
			arr[i].sour = Integer.parseInt(st.nextToken());
			arr[i].bitter = Integer.parseInt(st.nextToken());
		}

		subset(0);

		System.out.println(ans);
	}

	static void subset(int start) {
		int tempSour = 1, tempBitter = 0;
		boolean check = false;
		for (int i = 0; i < list.size(); i++) {
			check = true;
			tempSour *= list.get(i).sour;
			tempBitter += list.get(i).bitter;
		}

		if (check == true) {
			int minus = Math.abs(tempSour - tempBitter);
			if (minus < ans) {
				ans = minus;
			}
		}

		for (int i = start; i < N; i++) {
			list.add(arr[i]);
			subset(i + 1);
			list.remove(list.size() - 1);
		}
	}

}
