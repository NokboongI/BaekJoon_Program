import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int left=0;
        int right=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;++i){
            arr[i] = Integer.parseInt(st.nextToken());
            if(left<arr[i]) left = arr[i];
            right += arr[i];
        }

        int mid, count, sum;
        while(left<=right){
            mid = (left+right)/2;
            count = 0;
            sum=0;
            for(int i=0;i<N;++i){
                if(sum+arr[i]>mid){
                    sum=0;
                    count++;
                }
                sum+=arr[i];
            }
            count++;
            if(count>M) left = mid+1;
            else right = mid-1;
        }
        System.out.println(left);
    }
}