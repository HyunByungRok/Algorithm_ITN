package brute_force;
import java.io.*;
import java.util.*;

public class BOJ_2615_오목 {
	static int[][][] map = new int[19][19][9];

	// 8 방향
	static int dy[] = { 0, -1, 0, -1, 1, 0, -1, 1, 1 };
	static int dx[] = { 0, -1, -1, 0, 0, 1, 1, -1, 1 };

	static ArrayList<Info> arr = new ArrayList<Info>();

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		for (int y = 0; y < 19; y++) {
			for (int x = 0; x < 19; x++) {
				map[y][x][0] = sc.nextInt();
			}
		}

		for (int y = 0; y < 19; y++) {
			for (int x = 0; x < 19; x++) {
				for (int dir = 1; dir < 9; dir++) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];

					if (ny < 0 || ny >= 19 || nx < 0 || nx >= 19) {
						continue;
					}

					if (map[y][x][0] != 0 && map[y][x][0] == map[ny][nx][0]) {
						map[ny][nx][dir] += map[y][x][dir] + 1;
					}

					if (map[ny][nx][dir] == 4) {
						arr.add(new Info(ny, nx, dir, map[ny][nx][0]));
					}
				}
			}
		}

		boolean win = false;
		// 6목 체크
		int arrIdx = 0, findx = 0, findy = 0, finddir = 0, findcolor = 0;
		for (int i = 0; i < arr.size(); i++) {
			int ny = arr.get(i).y + dy[arr.get(i).dir];
			int nx = arr.get(i).x + dx[arr.get(i).dir];

			if (ny < 0 || ny >= 19 || nx < 0 || nx >= 19) {
				win = true;
				arrIdx = i;
				break;
			}

			if (arr.get(i).color != map[ny][nx][0]) {
				win = true;
				arrIdx = i;
				break;
			}
		}

		if (win) {
			findx = arr.get(arrIdx).x;
			findy = arr.get(arrIdx).y;
			findcolor = arr.get(arrIdx).color;
			finddir = arr.get(arrIdx).dir;
		}

		// 조건에 맞게 가장 왼쪽, 모두 세로로 놓인 경우 가장 위에 있는 것 고르기
		int retY = 0, retX = 0;
		if (findx < findx - dx[finddir] * 4) {
			retY = findy;
			retX = findx;
		} else if (findx == findx - dx[finddir] * 4) {
			retY = Math.min(findy, findy - dy[finddir] * 4);
			retX = findx;
		} else {
			retY = findy - dy[finddir] * 4;
			retX = findx - dx[finddir] * 4;
		}

		System.out.println(findcolor);
		if (findcolor != 0)
			System.out.printf("%d %d", retY + 1, retX + 1);
	}

	static class Info {
		int y, x, dir, color;

		public Info(int y, int x, int dir, int color) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.color = color;
		}

	}
}
