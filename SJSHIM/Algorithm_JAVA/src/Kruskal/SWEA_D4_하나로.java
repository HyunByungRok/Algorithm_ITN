package Kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_D4_하나로 {
	public static int N;
	public static double E;
	public static List<Island> edge;
	public static int[] p;
	public static int[][] point;

	public static int findSet(int x) {
		if (p[x] == x)
			return x;
		else
			return p[x] = findSet(p[x]);
	}

	public static boolean union(int a, int b) {
		a = findSet(a);
		b = findSet(b);

		if (a == b)
			return false;
		p[b] = a;
		return true;
	}

	public static long kruskal() {

		edge = new ArrayList<Island>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					continue;
				}
				double temp = Math.sqrt(Math.pow((double) (point[i][0] - point[j][0]), 2)
						+ Math.pow((double) (point[i][1] - point[j][1]), 2));

				edge.add(new Island(i, j, temp));
			}
		}

		Collections.sort(edge, new Comparator<Island>() {
			public int compare(Island o1, Island o2) {
				if (o1.L > o2.L) {
					return 1;
				} else if (o1.L == o2.L) {
					return 0;
				} else {
					return -1;
				}
			}
		});

		p = new int[N + 1];
		for (int i = 0; i < N + 1; i++)
			p[i] = i;

		double sum = 0;
		int count = 0;
		for (Island e : edge) {
			if (union(e.from, e.to)) {
				sum += Math.pow(e.L, 2) * E;
				if (++count == N - 1) {
					break;
				}
			}
		}
		return (long) Math.round(sum);
	}

	public static class Island {
		int from, to;
		double L;

		public Island(int from, int to, double l) {
			this.from = from;
			this.to = to;
			this.L = l;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());

			point = new int[N][2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				point[i][0] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				point[i][1] = Integer.parseInt(st.nextToken());
			}

			E = Double.parseDouble(br.readLine());
			System.out.println("#" + test_case + " " + kruskal());
		}
	}
}
