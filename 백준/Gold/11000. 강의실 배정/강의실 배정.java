import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int stValue = Integer.parseInt(st.nextToken());
            int ftValue = Integer.parseInt(st.nextToken());
            int[] temp = {stValue, ftValue};
            que.add(temp);
        }

        //int cnt = 1;
        PriorityQueue<Integer> ans = new PriorityQueue<>();
        int[] curr;
        while(!que.isEmpty()){
            curr = que.poll();
            if(!ans.isEmpty()&&curr[0]>=ans.peek()){
                ans.poll();
            }
            ans.add(curr[1]);
        }
        System.out.println(ans.size());
    }
}
