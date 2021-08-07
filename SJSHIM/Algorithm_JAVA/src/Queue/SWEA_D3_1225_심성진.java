package Queue;

import java.util.*;
import java.io.*;

public class SWEA_D3_1225_심성진 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int testcase = 1; testcase <= 10; testcase++) {
			int tc = Integer.parseInt(br.readLine());

			Queue<Integer> q = new LinkedList<>();

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}

			boolean passward = true;
			while (passward) {
				for (int i = 1; i <= 5; i++) {
					int temp = q.poll();
					temp -= i;

					if (temp <= 0) {
						temp = 0;
						passward = false;
						q.add(temp);
						break;
					}

					q.add(temp);
				}
			}

			StringBuilder sb = new StringBuilder();

			sb.append("#" + testcase);

			for (int i = 0; i < 8; i++) {
				sb.append(" " + q.poll());
			}

			System.out.println(sb);
		}

	}

}
