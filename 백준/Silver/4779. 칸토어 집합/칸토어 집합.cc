#include <iostream>
#include <string>
#include <vector>
#include <math.h>

using namespace std;

vector<int> nums;
vector<string> lines;

void makeline(int size, string place, int index);

int main() {
    int n;

    while (cin >> n) {
        nums.push_back(n);
        int i = nums.size() - 1; 

        int linesize = pow(3, nums[i]);
        lines.resize(nums.size());

        if (linesize >= 3) {
            makeline(linesize / 3, "left", i);
            makeline(linesize / 3, "center", i);
            makeline(linesize / 3, "right", i);
        }
        else {
            lines[i] = "-";
        }
    }

    for (int i = 0; i < nums.size(); i++) {
        cout << lines[i];
        if (i != nums.size() - 1) {
            cout << '\n';
        }
    }

    return 0;
}

void makeline(int size, string place, int index) {
    if (place.compare("left") == 0) {
        if (size == 1) {
            lines[index].append("-");
        }
        else {
            makeline(size / 3, "left", index);
            makeline(size / 3, "center", index);
            makeline(size / 3, "right", index);
        }
    }
    else if (place.compare("right") == 0) {
        if (size == 1) {
            lines[index].append("-");
        }
        else {
            makeline(size / 3, "left", index);
            makeline(size / 3, "center", index);
            makeline(size / 3, "right", index);
        }
    }
    else if (place.compare("center") == 0) {
        if (size == 1) {
            lines[index].append(" ");
        }
        else {
            makeline(size / 3, "center", index);
            makeline(size / 3, "center", index);
            makeline(size / 3, "center", index);
        }
    }
}
