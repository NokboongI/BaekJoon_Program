#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int>> stj;
bool* visited;
int* cnt;
int after = 0;
int dfs(int start, int x) {
    visited[x] = true;
    for (int i = 0; i < stj[x].size(); i++) {
        int next = stj[x][i];
        if (!visited[next]) {
            cnt[next]++;
            after+=dfs(start, next);
        }
    }
    return 1;
}

int main() {
    int n, m;
    cin >> n >> m;

    stj.resize(n + 1);
    visited = new bool[n + 1];
    cnt = new int[n + 1];

    for (int i = 0; i < m; i++) {
        int from, to;
        cin >> from >> to;
        stj[from].push_back(to);
    }
    for (int i = 0; i < n + 1; i++) {
        cnt[i] = 0;
    }
    for (int i = 1; i <= n; i++) {
        after = 0;
        fill(visited, visited + n + 1, false);
        dfs(i, i);
        cnt[i] += after;
    }

    int count = 0;
    for (int i = 1; i <= n; i++) {
        if (cnt[i] == n  - 1) {
            count++;
        }
    }

    cout << count;


    return 0;
}