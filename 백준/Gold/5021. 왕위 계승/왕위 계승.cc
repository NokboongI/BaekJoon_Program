#include<iostream>
#include<map>
#include<vector>
#include<string>
#include<queue>


using namespace std;


int n, m;
map<string, vector<string>> adj;
map<string, pair<int, double>> lineage;
string kingName;
vector<string>wannaking;


int main(void) {
	cin >> n >> m;
	cin >> kingName;

	while (n--) {
		string dad, mom;
		string name;

		cin >> name >> dad >> mom;
		if (lineage.find(name) == lineage.end()) {
			lineage[name] = { 0 ,0 };
		}
		if (lineage.find(dad) == lineage.end()) {
			lineage[dad] = { 0 ,0 };
		}
		if (lineage.find(mom) == lineage.end()) {

			lineage[mom] = { 0 ,0 };
		}
		adj[dad].push_back(name);
		adj[mom].push_back(name);
		lineage[name] = { 2,0 };
	}
	while (m--) {
		string name;
		cin >> name;
		wannaking.push_back(name);
	}
	lineage[kingName] = { 0,1 };
	queue<string>q;
	string nextking;
	double poss = 0;

	for (auto iter : lineage) {
		if (iter.second.first == 0)
			q.push(iter.first);
	}

	while (!q.empty()) {
		string current = q.front();
		q.pop();

		for (auto iter : adj[current]) {
			string next = iter;
			lineage[next].second += lineage[current].second;
			if (--lineage[next].first == 0) {
				q.push(next);
				lineage[next].second /= 2;
			}
		}
	}
	for (auto iter : wannaking) {
		if (poss < lineage[iter].second) {
			poss = lineage[iter].second;
			nextking = iter;
		}
	}
	cout << nextking;
}