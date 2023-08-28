import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static HashMap<Integer, ArrayList<Integer>> people;
    static int[] bacon;

    static void bfs(int start, int n) {
        boolean[] status = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        status[start] = true;
        int freind = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                bacon[start] += freind;

                ArrayList<Integer> friends = people.get(current);
                for (int friend : friends) {
                    if (!status[friend]) {
                        queue.offer(friend);
                        status[friend] = true;
                    }
                }
            }
            freind++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        people = new HashMap<>();
        bacon = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            people.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            people.get(a).add(b);
            people.get(b).add(a);
        }

        int min = 100000000;
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            bfs(i, n);
            if (bacon[i] < min) {
                min = bacon[i];
                answer = i;
            }
            bacon[i] = 0;
        }

        System.out.println(answer);
    }
}
