package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class °úÁ¦_BOJ13904 {
	static int N, d, w, max, result;
	static List<Problem> problems;
	static boolean check[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		problems = new ArrayList<Problem>();
		max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken()); w = Integer.parseInt(st.nextToken());
			max = Math.max(max, d);
			problems.add(new Problem(d, w));
		}
		check = new boolean[d+1];
		problems.sort(new Comparator<Problem>() {

			@Override
			public int compare(Problem o1, Problem o2) {
				return o2.score - o1.score;
			}
		
		});
		
		for(Problem problem : problems) {
			d = problem.remainedDate;
			w = problem.score;
			while(d>0) {
				if(!check[d]) {
					check[d]=true;
					result+=w;
					break;
				}
				d--;
			}
		}
		
		System.out.println(result);
		
	}
	static class Problem{
		int remainedDate, score;

		public Problem(int remainedDate, int score) {
			super();
			this.remainedDate = remainedDate;
			this.score = score;
		}
		
	}
}
