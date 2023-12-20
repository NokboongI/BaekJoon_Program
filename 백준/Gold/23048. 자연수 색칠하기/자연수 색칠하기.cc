#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    int** nums = new int* [n + 1];
    for (int i = 1; i < n + 1; i++) {
        nums[i] = new int[3];
        nums[i][0] = i;
        nums[i][1] = 0;
    }
    int colors = 0;
    for (int i = 1; i < n + 1; i++) {
        if (i == 1) {
            colors++;
            nums[i][2] = colors;
            nums[i][1] = 1;
        }
        else {
            int current = nums[i][0];
            if (nums[i][1] == 0) {
                nums[i][1] = 1;
                colors++;
                nums[i][2] = colors;
                for (int j = i; j < n + 1; j += current) {
                    nums[j][1] = 1;
                    nums[j][2] = colors;
                }
            }
            else {
                continue;
            }
        }
    }
    cout << colors << endl;

    for (int i = 1; i < n + 1; i++) {
        cout << nums[i][2] << ' ';
    }


    return 0;
}
