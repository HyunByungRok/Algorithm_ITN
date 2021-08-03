#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int L, C;
char al[15] = { 0, };
vector<char> ans;

void dfs(int idx, int check1, int check2) {
	if (ans.size() == L) {
		if (check1 >= 1 && check2 >= 2) {
			for (int i = 0; i < L; i++) {
				printf("%c", ans[i]);
			}
			printf("\n");
		}

		return;
	}

	for (int i = idx; i < C; i++) {
		ans.push_back(al[i]);
		if (al[i] == 'a' || al[i] == 'e' || al[i] == 'i' || al[i] == 'o' || al[i] == 'u') {
			dfs(i + 1, check1 + 1, check2);
		}
		else {
			dfs(i + 1, check1, check2 + 1);
		}
		ans.pop_back();
	}
}

int main()
{
	scanf("%d %d", &L, &C);

	for (int i = 0; i < C; i++) {
		cin >> al[i];
	}

	sort(al, al + C);

	dfs(0, 0, 0);

	return 0;
}