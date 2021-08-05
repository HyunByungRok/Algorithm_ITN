package Stack;

import java.util.*;
import java.io.*;

public class BOJ_2493_탑 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		Stack<TopInfo> s = new Stack<TopInfo>();
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			int temp = Integer.parseInt(st.nextToken());

			while (!s.isEmpty() && s.peek().height < temp) {
				s.pop();
			}

			if (s.isEmpty()) {
				sb.append("0 ");
			} else {
				sb.append(s.peek().location + " ");
			}

			s.push(new TopInfo(temp, i));
		}

		System.out.println(sb.toString());
	}

	static class TopInfo {
		int height, location;

		/**
		 * @param height
		 * @param location
		 */
		public TopInfo(int height, int location) {
			this.height = height;
			this.location = location;
		}
	}

}
