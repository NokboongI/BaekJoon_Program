#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

vector<vector<int>> stj;
bool* visited;
int* cnt;

void bfs(int start, int n) {
    visited[start] = true;
    queue<int> que;
    que.push(start);
    int temp = stj[start].size();
    int nexttemp = 0;
    int* depth = new int[n+1];
    if (que.empty()) {
        cnt[start] += 0;
    }
    else {
        depth[start] = 0;
        while (!que.empty()) {
            int x = que.front();
            que.pop();
            
            for (int i = 0; i < stj[x].size(); i++) {
                int y = stj[x][i];
                if (!visited[y]) {
                    que.push(y);
                    visited[y] = true;
                    depth[y] = depth[x] + 1;
                }

            }
        }
        int big = 0;
        for (int i = 1; i < n + 1; i++) {
            if (big <= depth[i]) {
                big = depth[i];
            }
        }
        cnt[start] = big;
    }
}

int main() {
    int n;
    cin >> n;

    stj.resize(n + 1);
    visited = new bool[n + 1];
    cnt = new int[n + 1];

    while(true) {
        int from, to;
        cin >> from >> to;
        if (from == -1 && to == -1) {
            break;
        }
        stj[from].push_back(to);
        stj[to].push_back(from);

    }
    for (int i = 0; i < n+1; i++) {
        cnt[i] = 0;
    }
    for (int i = 1; i <= n; i++) {
        fill(visited, visited + n + 1, false);
        bfs(i, n);
    }
    int min = *min_element(cnt+1, cnt + n + 1);
    int count = 0;
    for (int i = 1; i <= n; i++) {
        if (cnt[i] == min) {
            count++;
        }
    }
    cout << min << " " << count << endl;
    for (int i = 1; i <= n; i++) {
        if (cnt[i] == min) {
            cout << i <<" ";
        }
    }




    return 0;
}
