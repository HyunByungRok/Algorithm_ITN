package Stack;

import java.util.*;
import java.io.*;

public class SWEA_D4_1218_심성진 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int testcase = 1; testcase <= 10; testcase++) {
			int len = Integer.parseInt(br.readLine());

			String str = br.readLine();

			Stack<Character> s = new Stack<>();

			boolean check = true;

			for (int i = 0; i < len; i++) {
				char temp = str.charAt(i);

				if (temp == '{' || temp == '[' || temp == '(' || temp == '<') {
					s.push(temp);
				} else {
					if (s.isEmpty()) {
						check = false;
						break;
					}

					char top = s.pop();
					if (temp == '}' && top != '{') {
						check = false;
					}

					if (temp == ']' && top != '[') {
						check = false;
					}

					if (temp == ')' && top != '(') {
						check = false;
					}

					if (temp == '>' && top != '<') {
						check = false;
					}

					if (check == false) {
						break;
					}
				}
			}

			if (check == false || !s.isEmpty()) {
				System.out.printf("#%d 0\n", testcase);
			} else {
				System.out.printf("#%d 1\n", testcase);
			}
		}
	}

}
