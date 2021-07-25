#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <stdio.h>
#include <stack>

using namespace std;
int arr[1001] = { 0, };
int main() {
	stack<int> s;
	int n;
	scanf("%d", &n);

	int max_value = -1;
	int findIdx = 0;
	for (int i = 0; i < n; i++)
	{
		int l, h;
		scanf("%d %d", &l, &h);
		arr[l] = h;
		// ���� ū ���� ���� ���� ������
		if (max_value <= h) {
			max_value = h;
			findIdx = l;
		}
	}
	int ans = 0;
	s.push(0);
	// ó������ ���� ū���� �ִ� ������ ���� ���
	for (int i = 1; i <= findIdx; i++)
	{
		if (s.top() < arr[i]) {
			s.push(arr[i]);
		}

		ans += s.top();
	}

	while (!s.empty()) {
		s.pop();
	}

	s.push(0);
	// ���������� ���� ū���� ���۵Ǵ� ���������� ���� ���
	for (int i = 1000; i > findIdx; i--)
	{
		if (s.top() < arr[i]) {
			s.push(arr[i]);
		}

		ans += s.top();
	}
	printf("%d", ans);

	return 0;
}