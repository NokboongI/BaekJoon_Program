#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

int n, k;

int main() {
    cin >> n;
    cin >> k;

    long long** values = new long long* [n + 1];
    for (int i = 1; i < n + 1; i++) {
        values[i] = new long long[n + 1];
        fill(values[i], values[i] + n + 1, -1);
    }

    for (int i = 0; i < k; i++) {
        int s, e;
        long long v;
        cin >> s >> e >> v;
        if (values[s][e] == -1) {
            values[s][e] = v;
        }
        else {
            if (values[s][e] > v) {
                values[s][e] = v;
            }
        }

    }
    int start, end;
    cin >> start >> end;

    long long* direction = new long long[n + 1];
    fill(direction, direction + n + 1, LLONG_MAX);
    direction[start] = 0;

    bool* visited = new bool[n + 1];
    fill(visited, visited + n + 1, false);

    while (true) {
        long long min = LLONG_MAX;
        int min_index = 0;

        for (int i = 1; i < n + 1; i++) {
            if (direction[i] < min && !visited[i]) {
                min = direction[i];
                min_index = i;
            }
        }

        if (min == LLONG_MAX) {
            break;
        }

        visited[min_index] = true;

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i] && values[min_index][i] != -1) {
                if (direction[min_index] + values[min_index][i] < direction[i]) {
                    direction[i] = direction[min_index] + values[min_index][i];
                }
            }
        }
    }
    
    cout << direction[end];
    

    return 0;
}
