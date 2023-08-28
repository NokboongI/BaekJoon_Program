import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int blue = 0;
    static int white = 0;

    static void count(int[][] paper, int r, int c, int s) {
        int check = 0;
        for (int i = r; i < r + s; i++) {
            for (int j = c; j < c + s; j++) {
                check += paper[i][j];
            }
        }
        if (check == 0) {
            white++;
        } else if (check == s * s) {
            blue++;
        } else {
            count(paper, r, c, s / 2);
            count(paper, r + s / 2, c, s / 2);
            count(paper, r, c + s / 2, s / 2);
            count(paper, r + s / 2, c + s / 2, s / 2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[n][n];
        int check = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int curr = Integer.parseInt(st.nextToken());
                paper[i][j] = curr;
                check+=curr;
            }
        }
        if(check==0){
            System.out.println(++white);
            System.out.println(blue);
        } else if (check==n*n) {
            System.out.println(white);
            System.out.println(++blue);
        }else {
            count(paper, 0, 0, n / 2);
            count(paper, n / 2, 0, n / 2);
            count(paper, 0, n / 2, n / 2);
            count(paper, n / 2, n / 2, n / 2);
            System.out.println(white);
            System.out.println(blue);
        }
    }
}
