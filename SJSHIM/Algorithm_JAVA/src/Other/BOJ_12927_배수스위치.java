package Other;

import java.util.*;
import java.io.*;

public class BOJ_12927_배수스위치 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();

		boolean num[] = new boolean[temp.length() + 1];
		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) == 'N') {
				num[i + 1] = true;
			}
		}

		int cnt = 0;
		for (int i = 1; i < num.length; i++) {
			if (num[i] == false) {
				cnt++;
				int k = 1;
				for (int j = i; j < num.length; j = i * k) {
					if (num[j] == false) {
						num[j] = true;
					} else if (num[j] == true) {
						num[j] = false;
					}
					k++;
				}
			}
		}

		boolean ret = true;
		for (int i = 1; i < num.length; i++) {
			if (num[i] == false) {
				ret = false;
				break;
			}
		}

		if (ret == false) {
			System.out.println(-1);
		} else {
			System.out.println(cnt);
		}
	}

}
