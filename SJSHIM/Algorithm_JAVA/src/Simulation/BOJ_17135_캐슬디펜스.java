package Simulation;

import java.util.*;
import java.io.*;

public class BOJ_17135_캐슬디펜스 {

	static int N;
	static int M;
	static int D;
	static int ans = 0;
	static ArrayList<Point> list = new ArrayList<>();
	static ArrayList<Point> enemyList = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		// 성이 있는 칸에 NC3 조합해서 시뮬레이션

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					enemyList.add(new Point(y, x, true));
				}
			}
		}

		comb(0, 0);
		System.out.println(ans);
	}

	static public void comb(int start, int cnt) {
		if (cnt == 3) {
			simul();
			return;
		}

		for (int i = start; i < M; i++) {
			list.add(new Point(N, i, false));
			comb(i + 1, cnt + 1);
			list.remove(list.size() - 1);
		}
	}

	static public void simul() {
		ArrayList<Point> tempEnemyList = new ArrayList<>();

		for (int i = 0; i < enemyList.size(); i++) {
			tempEnemyList.add(new Point(enemyList.get(i).y, enemyList.get(i).x, true));
		}

		while (true) {
			for (int i = 0; i < list.size(); i++) {
				int killIdx = -1;
				int minGap = 100;
				int leftPoint = 100;
				for (int j = 0; j < tempEnemyList.size(); j++) {
					if (tempEnemyList.get(j).y >= N) {
						continue;
					}

					int gap = Math.abs(list.get(i).x - tempEnemyList.get(j).x)
							+ Math.abs(list.get(i).y - tempEnemyList.get(j).y);

					if (minGap >= gap && gap <= D) {
						// 가장 가까운 적이 여럿일 경우 왼쪽을 공격
						if (minGap == gap) {
							if (leftPoint > tempEnemyList.get(j).x) {
								minGap = gap;
								leftPoint = tempEnemyList.get(j).x;
								killIdx = j;
							}
						} else {
							minGap = gap;
							leftPoint = tempEnemyList.get(j).x;
							killIdx = j;
						}
					}
				}
				if (killIdx != -1) {
					tempEnemyList.get(killIdx).live = false;
				}
			}

			// 적 제거
			for (int i = tempEnemyList.size() - 1; i >= 0; i--) {
				if (tempEnemyList.get(i).live == false) {
					tempEnemyList.remove(i);
				}
			}

			boolean isEnd = true;
			// 적 아래로 이동
			for (int i = tempEnemyList.size() - 1; i >= 0; i--) {
				tempEnemyList.get(i).y++;
				// 아래로 이동 후 이동할 곳이 남아있다면
				if (tempEnemyList.get(i).y < N) {
					isEnd = false;
				}
			}

			if (isEnd == true) {
				break;
			}
		}

		if (enemyList.size() - tempEnemyList.size() > ans) {
			ans = enemyList.size() - tempEnemyList.size();
		}
	}

	static public class Point {
		int y, x;
		boolean live;

		/**
		 * @param y
		 * @param x
		 */
		public Point(int y, int x, boolean live) {
			this.y = y;
			this.x = x;
			this.live = live;
		}
	}
}
