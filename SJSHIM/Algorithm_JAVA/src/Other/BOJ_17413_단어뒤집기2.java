package Other;

import java.util.*;
import java.io.*;

public class BOJ_17413_단어뒤집기2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuffer sb = new StringBuffer();

		boolean needReverse = true;
		int startIdx = 0;
		int endIdx = -1;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '<') {
				for (int j = i - 1; j >= startIdx; j--) {
					sb.append(str.charAt(j));
				}
				sb.append('<');
				needReverse = false;
			} else if (str.charAt(i) == '>') {
				startIdx = i + 1;
				needReverse = true;
				sb.append('>');
			} else if (str.charAt(i) == ' ') {
				if (needReverse == true) {
					for (int j = i - 1; j >= startIdx; j--) {
						sb.append(str.charAt(j));
					}
				}
				sb.append(' ');
				startIdx = i + 1;
			} else {
				if (needReverse == false) {
					sb.append(str.charAt(i));
				}
			}

			endIdx = i;
		}
		if (needReverse == true) {
			for (int j = endIdx; j >= startIdx; j--) {
				sb.append(str.charAt(j));
			}
		}
		System.out.println(sb);
	}

}
