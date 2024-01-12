#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int n, m;
vector<string> str;
vector<string> ans;

void get_ans(string word, int as, int nas, int pos) {
    if (ans.size() == n&&as>=1&&nas>=2) {
        for (string s : ans) {
            cout << s;
        }
        cout << endl;
    }
    else {
        for (int i = pos; i < str.size(); i++) {
            string curr = str[i];
            ans.push_back(curr);
            if (curr.compare("a") == 0 || curr.compare("e") == 0 || curr.compare("i") == 0 ||
                curr.compare("o") == 0 || curr.compare("u") == 0) {
                get_ans(curr, as + 1, nas, i + 1);
            }
            else {
                get_ans(curr, as, nas + 1, i + 1);
            }
            ans.pop_back();
        }
    }
}

int main() {
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        string get;
        cin >> get;
        str.push_back(get);
    }
    sort(str.begin(), str.end());


    for (int i = 0; i < str.size() - n + 1; i++) {
        string word = str[i];
        ans.push_back(word);
        if (word.compare("a") == 0 || word.compare("e") == 0 || word.compare("i") == 0 ||
            word.compare("o") == 0 || word.compare("u") == 0) {
            get_ans(word, 1, 0, i + 1);
        }
        else {
            get_ans(word, 0, 1, i + 1);
        }
        ans.pop_back();
    }

    return 0;
}
