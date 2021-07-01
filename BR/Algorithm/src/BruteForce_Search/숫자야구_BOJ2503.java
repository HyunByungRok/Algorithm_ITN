package BruteForce_Search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자야구_BOJ2503 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		Num num[] = new Num[size];
		for(int i=0; i<size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num[i] = new Num(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int strike, ball, answer=0;
		for(int i=1; i<10; i++) {
			for(int j=1; j<10; j++) {
				if(i==j) continue;
				jump : for(int k=1; k<10; k++) {
					if(j==k || i==k) continue;
					for(int s=0; s<size; s++) {
						strike = 0; ball = 0;
						if(num[s].num.charAt(0) == i+'0') strike++;
						else if(num[s].num.contains(String.valueOf(i))) ball++;
						if(num[s].num.charAt(1) == j+'0') strike++;
						else if(num[s].num.contains(String.valueOf(j))) ball++;
						if(num[s].num.charAt(2) == k+'0') strike++;
						else if(num[s].num.contains(String.valueOf(k))) ball++;
						if(strike != num[s].strike || ball != num[s].ball) continue jump;
					}
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
	static class Num {
		public String num;
		public int strike, ball;
		public Num(String num, int strike, int ball) {
			super();
			this.num = num;
			this.strike = strike;
			this.ball = ball;
		}
		
	}
}
