package Divide_And_Conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종이의개수_BOJ1780 {
	static int N, map[][], cnt[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		cnt = new int[3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		divide(0, 0, N);
		for(int i=0; i<3; i++) System.out.println(cnt[i]);
	}
	private static void divide(int y, int x, int size) {
		int std = size/3;
		if(check(y, x, size)) {
			cnt[map[y][x]+1]++;
		}else {
			for(int i=y; i<y+size; i+=std) {
				for(int j=x; j<x+size; j+=std) {
					divide(i, j, std);
				}
			}
		}
		
	}
	private static boolean check(int sy, int sx, int std) {
		int num = map[sy][sx];
		for(int i=sy; i<sy+std; i++) {
			for(int j=sx; j<sx+std; j++) {
				if(num != map[i][j]) return false; 
			}
		}
		return true;
	}
}
