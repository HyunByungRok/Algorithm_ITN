package Sort;

import java.util.*;
import java.io.*;

public class BOJ_11399_ATM {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int sum = 0;

		for (int i = 0; i < N; i++) {
			sum += arr[i] * (N - i);
		}

		System.out.println(sum);
	}

}
