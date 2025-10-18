package barkingdock.x10;

/*

1번 집과 2번집은 같지 않음
N번 집은 N-1집 색은 같지 않음
i번 집의 색은 i-1번, i+1번 집 색과 같지 않음

3번 집이라면
1번은 최소값
2번은 남은 최소값
3번 집은

만약 n-1번집이 있다면
D[1][0] = arr[1][0]
D[1][1] = arr[1][1]
D[1][2] = arr[1][2]


D[i][0] = min(D[i-1][1],D[i-1][2])
D[i][1] = min(D[i-1][0],D[i-1][2])
D[i][2] = min(D[i-1][0],D[i-1][1])
 */


import java.io.*;
import java.util.*;
public class Boj1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][3];
        StringTokenizer st;
        for(int i=1;i<n+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n+1][3];
        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];
        dp[1][2] = arr[1][2];

        for(int i=2;i<n+1;i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+arr[i][0];
            dp[i][1] = Math.min(dp[i-1][2], dp[i-1][0])+arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+arr[i][2];
        }
        int ans = Math.min(Math.min(dp[n][0],dp[n][1]),dp[n][2]);
        System.out.println(ans);
    }
}

