import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static int v, e, r, st, fi, cnt = 0;
    static
    boolean[] status;
    static LinkedList<Integer>[] list;
    static int[] ans;
    static void dfs(int r){
        status[r] = true;
        ans[r] = ++cnt;
        for(int i:list[r]){
            if(!status[i]) dfs(i);
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        v = s.nextInt();
        e = s.nextInt();
        r = s.nextInt();
        status = new boolean[v];
        list = new LinkedList[v];
        ans = new int[v];
        for(int i = 0; i<v;i++){
            status[i] = false;
        }
        for(int i = 0; i < v; i++) {
            list[i] = new LinkedList<>();
        }
        for(int i = 0; i<e;i++){
            st = s.nextInt();
            fi = s.nextInt();
             list[st-1].add(fi-1);
             list[fi-1].add(st-1);
        }
        for(int i = 0; i<v;i++){
            Collections.sort(list[i]);
        }
        dfs(r-1);
        for(int i:ans){
            System.out.println(i);
        }

    }

}