import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, m, cnt = 0;
        n = s.nextInt();
        m = s.nextInt();
        s.nextLine();

        String get;
        String[][] arr1 = new String[n][m];
        String[][] arr2 = new String[n][m];
        for (int i = 0; i < n; i++) {
            get = s.nextLine();
            arr1[i] = get.split("");
            
        }

        for (int i = 0; i < n; i++) {
            get = s.nextLine();
            arr2[i] = get.split("");
        }
        if(n>2&&m>2){
            for (int i = 0; i < n-2; i++) {
                for (int j = 0; j < m-2; j++) {
                    if (!arr2[i][j].equals(arr1[i][j])) {
                        cnt++;
                        for (int r = i; r < i + 3; r++) {
                            for (int z = j; z < j + 3; z++) {
                                if (arr2[r][z].equals("0")) {
                                    arr2[r][z] = "1";
                                } else if(arr2[r][z].equals("1")){
                                    arr2[r][z] = "0";
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!arr2[i][j].equals(arr1[i][j])){
                        cnt = -1;
                        break;
                    }
                }
            }
        }else{
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!arr2[i][j].equals(arr1[i][j])){
                        cnt = -1;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
