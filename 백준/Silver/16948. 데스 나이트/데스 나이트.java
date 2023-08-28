import java.util.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[][] pan = new int[size][size];
        for (int i = 0; i < size; i++) {
            pan[i] = new int[size];
        }
        int startr, startc, findr, findc, r, c, cnt = 0, prev = 0;
        Point curr;
        startr = s.nextInt();
        startc = s.nextInt();
        findr = s.nextInt();
        findc = s.nextInt();
        pan[startr][startc] = prev;
        Queue<Point> queue = new LinkedList<>();
        r = startr;
        c = startc;

        queue.add(new Point(r, c));
        while (!queue.isEmpty()) {
            curr = queue.poll();
            r = curr.x;
            c = curr.y;
            if (r + 2 < size && c + 1 < size && pan[r + 2][c + 1]==0) {
                pan[r + 2][c + 1] = 1+pan[r][c];
                queue.add(new Point(r + 2, c + 1));
            }
            if (r + 2 < size && c - 1 >= 0 && pan[r + 2][c - 1]==0) {
                pan[r + 2][c - 1] = 1+pan[r][c];
                queue.add(new Point(r + 2, c - 1));
            }
            if (r < size && c + 2 < size && pan[r][c + 2]==0) {
                pan[r][c + 2] = 1+pan[r][c];
                queue.add(new Point(r, c + 2));
            }
            if (r < size && c - 2 >= 0 && pan[r][c - 2]==0) {
                pan[r][c - 2] = 1+pan[r][c];
                queue.add(new Point(r, c - 2));
            }
            if (r - 2 >= 0 && c + 1 < size && pan[r - 2][c + 1]==0) {
                pan[r - 2][c + 1] = 1+pan[r][c];
                queue.add(new Point(r - 2, c + 1));
            }
            if (r - 2 >= 0 && c - 1 >= 0 && pan[r - 2][c - 1]==0) {
                pan[r - 2][c - 1] = 1+pan[r][c];
                queue.add(new Point(r - 2, c - 1));
            }
            if (pan[findr][findc]!=0) {
                break;
            }
        }
        if (pan[findr][findc]!=0) {
            System.out.println(pan[findr][findc]);
        } else {
            System.out.println(-1);
        }
    }
}
