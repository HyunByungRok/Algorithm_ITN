package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 박스채우기_BOJ1493 {
	/**
	 * 처음엔 완탐 돌릴까 하다가 문제 카테고리때문에 그리디하게 풀려는데 도저히 생각이 안나서 정답을 보고 하루 뒤에 다시품
	 * 주어진 조건에서 넣을 수 있는 가장 큰 사각형을 남는다면 같은 크기의 사각형이 3개 남는다는 점을 이용해서
	 * 재귀를 통한 분할 정복으로 문제를 풀어나간다는 방식을 알고 풀기  
	 * ---------------------푼 후
	 * java에서 log2 구하는 방법을 몰라서 많이 헤메었다
	 * 푼 뒤에 시간을 보니까 방법이 좋지 못했던 것 같다.... 나중에 다시 풀어보자
	 */
	static int length, width, height, n, cube[]; // cube[] - cube[i]의 갯수 i는 변의길이 2의i승의 i
	static boolean finish;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		length = Integer.parseInt(st.nextToken()); width = Integer.parseInt(st.nextToken()); height = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(br.readLine());
		cube = new int[20]; // 0<=A<20
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			cube[A] = B;
		}
		
		
		System.out.println(divide(length, width, height));
	}
	private static int divide(int len, int wid, int hei) {
		if(len == 0 || wid == 0 || hei == 0) return 0;
		//세 변중에 가장 짧은 변을 기준으로 부터 넣을 cube가 있나 찾기위해서
		int min = Math.min(len, Math.min(wid, hei));
		int l = (int)(Math.log(min) / Math.log(2)); //log2 구하기 => cube배열에 제곱근 형태값을 인덱스로 사용하고 있기때문에
		
		while(l>=0) {
			if(cube[l]!=0) {
				cube[l]--;
				int realL = (int) Math.pow(2, l); // 원래 길이로 변환
				//나누어지는 3개 구역으로 분할정복을 진행한다. 가능한 블럭이 아무것도 없이 빈공간으로 돌아오는 애가 있으면 못채우는 경우이므로 -1을 리턴
				//재귀함수에서 반환된 값이 -1 이면 전체를 불가능 처리하기 위해서 -1조건으로 계속 -1을 리턴
				int sector1 = divide(len-realL, realL, realL);
				if(finish || sector1 == -1) return -1;
				int sector2 = divide(len, wid-realL, realL);
				if(finish ||sector2 == -1) return -1;
				int sector3 = divide(len, wid, hei-realL);
				if(finish ||sector3 == -1) return -1;
				return sector1 + sector2 + sector3+1; // 가능하다면 자기자신 + 3개 구역을 채운 각 갯수를 다 더해서 리턴
			}
			l--;
		}
		finish = true;
		return -1;
	}
}
