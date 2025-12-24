#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
	int n;
	string command;
	int num;
	int result;	//출력하는 결과
	stack <int> s;
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> command;
		if (command == "push") {
			cin >> num;
			s.push(num);
		}

		else if (command == "pop") {
			if (s.empty()) {
				cout << -1 << endl;
			}
			else {
				result = s.top();
				cout << result << endl;
				s.pop();
			}
		}

		else if (command == "size") {
			cout << s.size() << endl;
		}

		else if (command == "empty") {
			if (s.empty()) {
				cout << 1 << endl;
			}
			else {
				cout << 0 << endl;
			}
		}

		else if (command == "top") {
			if (s.empty()) {
				cout << -1 << endl;
			}
			else {
				result = s.top();
				cout << result << endl;
			}
		}
	}
	return 0;
}