package BruteForce_Search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판다시칠하기_BOJ1018 {
	static int N, M;
	static char map[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i=0; i<N; i++) map[i] = br.readLine().toCharArray();
		int min = Integer.MAX_VALUE;
		for(int sy=0; sy<=N-8; sy++) {
			next: for(int sx=0; sx<=M-8; sx++) {
				int count =0, count2=0;
				char flag = map[sy][sx] == 'W' ? 'B' : 'W';
				for(int i=0; i<8; i++) {
					for (int j=0; j<8; j++) {
						int y = sy+i;
						int x = sx+j;
						if(flag==map[y][x]) count++;
						else count2++;
						if(min <= count) continue next;
						flag = (flag == 'W' ? 'B' : 'W');
					}
					flag = (flag == 'W' ? 'B' : 'W');
				}
				min = Math.min(min, Math.min(count, count2));
			}
		}
		System.out.println(min);
	}
}
