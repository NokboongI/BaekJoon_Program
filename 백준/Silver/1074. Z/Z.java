import java.util.Scanner;
import java.lang.Math;
class Find {
    public Find() {
    }

    ;

    public long find(int r, int c, int rsize, int csize, long left, long right,int check) {
        //512 512 512-> 768 768 256 ->
        long mid = (left + right) / 2;
        long qu1, qu2;
        qu1 = (left + mid) / 2;
        qu2 = (right + mid) / 2;
        if (right-left>3) {
            if (r < rsize && c < csize) {
                return find(r, c, rsize-check/2 , csize-check/2 , left, qu1,check/2);
            } else if (r < rsize && c >= csize) {
                return find(r, c, rsize-check/2, csize + check / 2, qu1 + 1, mid,check/2);
            } else if (r >= rsize && c < csize) {
                return find(r, c, rsize + check / 2, csize-check/2, mid + 1, qu2,check/2);
            } else if (r >= rsize && c >= csize) {
                return find(r, c, rsize + check / 2, csize + check / 2, qu2 + 1, right,check/2);
            }
        } else {
            if (r == rsize-1 && c == csize-1) {
                return left;
            } else if (r == rsize-1 && c == csize) {
                return left + 1;
            } else if (r == rsize && c == csize-1) {
                return left + 2;
            } else if (r == rsize && c == csize) {
                return left + 3;
            }
        }
        return 0;
    }
}
public class Main {
    public static void main(String[] args) {
        int size, r, c;
        Scanner s = new Scanner(System.in);
        size = s.nextInt();
        size = (int)Math.pow(2,size);
        r = s.nextInt();
        c = s.nextInt();
        long ans = 0;
        long left = 0;
        long right = size*size-1;
        Find find = new Find();
        ans = find.find(r, c, size/2, size/2, left, right, size/2);
        System.out.println(ans);
    }
}