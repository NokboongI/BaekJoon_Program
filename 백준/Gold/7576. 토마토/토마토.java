/*import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String s = bf.readLine();
        Queue<int[]> from = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(s);
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int day = 1, cnt = 0, ncnt = 0;
        int[][] box = new int[r][c];
        int[] temp = new int[2];
        for(int i = 0;i<r;i++){
            s = bf.readLine();
            st = new StringTokenizer(s);
            for(int j=0;j<c;j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j]==1){
                    temp[0] = i;
                    temp[1] = j;
                    from.add(temp);
                    cnt++;
                    System.out.println(i +" "+ j);

                }
            }
        }
        int cr, cc;
        while(!from.isEmpty()){
            if(cnt==0){
                cnt = ncnt;
                ncnt=0;
                day++;
            }
            temp = from.remove();
            --cnt;
            cr = temp[0];
            cc = temp[1];

            if(cr+1<r&&box[cr+1][cc]==0){
                box[cr+1][cc]=day;
                temp[0]=cr+1;
                temp[1]=cc;
                from.add(temp);
                ncnt++;
            }
            if (cc-1>=0&&box[cr][cc-1]==0) {
                box[cr][cc-1]=day;
                temp[0]=cr;
                temp[1]=cc-1;
                from.add(temp);
                ncnt++;
            }
            if (cr-1>=0&&box[cr-1][cc]==0) {
                box[cr-1][cc]=day;
                temp[0]=cr-1;
                temp[1]=cc;
                from.add(temp);
                ncnt++;
            }
            if (cc+1<c&&box[cr][cc+1]==0) {
                box[cr][cc+1]=day;
                temp[0]=cr;
                temp[1]=cc+1;
                from.add(temp);
                ncnt++;
            }
        }
        for(int[] i:box){
            for(int j:i){
                System.out.print(j);
            }
            System.out.println();
        }

    }
}*/
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = bf.readLine();
        Queue<int[]> from = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(s);
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int day = 1, cnt = 0, ncnt = 0,blk = 0;
        int[][] box = new int[r][c];
        int[] temp;
        for (int i = 0; i < r; i++) {
            s = bf.readLine();
            st = new StringTokenizer(s);
            for (int j = 0; j < c; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    temp = new int[2];
                    temp[0] = i;
                    temp[1] = j;
                    from.add(temp);
                    cnt++;
                }
                if (box[i][j] == -1) {

                    blk++;
                }
            }
        }

        if(cnt+blk!=c*r) {
            int cr, cc;
            while (!from.isEmpty()) {
                if (cnt == 0) {
                    cnt = ncnt;
                    ncnt = 0;
                    day++;
                }
                temp = from.remove();
                --cnt;
                cr = temp[0];
                cc = temp[1];

                if (cr + 1 < r && box[cr + 1][cc] == 0) {
                    box[cr + 1][cc] = day;
                    temp = new int[2];
                    temp[0] = cr + 1;
                    temp[1] = cc;
                    from.add(temp);
                    ncnt++;
                }
                if (cc - 1 >= 0 && box[cr][cc - 1] == 0) {
                    box[cr][cc - 1] = day;
                    temp = new int[2];
                    temp[0] = cr;
                    temp[1] = cc - 1;
                    from.add(temp);
                    ncnt++;
                }
                if (cr - 1 >= 0 && box[cr - 1][cc] == 0) {
                    box[cr - 1][cc] = day;
                    temp = new int[2];
                    temp[0] = cr - 1;
                    temp[1] = cc;
                    from.add(temp);
                    ncnt++;
                }
                if (cc + 1 < c && box[cr][cc + 1] == 0) {
                    box[cr][cc + 1] = day;
                    temp = new int[2];
                    temp[0] = cr;
                    temp[1] = cc + 1;
                    from.add(temp);
                    ncnt++;
                }
            }
            int check = 0, max = box[0][0];
            for (int[] i : box) {
                for (int j : i) {
                    if (j == 0) check++;
                    if (max < j) max = j;
                }
            }
            if (check == 0) {
                System.out.println(max);
            } else {
                System.out.println(-1);
            }
            // bw.flush();
            // bw.close();
        }else{
            System.out.println(0);
        }
    }
}
