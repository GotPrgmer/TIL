package barkingdock.x10;
import java.util.*;
import java.io.*;
public class Boj2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1;i<n+1;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[n+1][3];
        dp[1][1] = arr[1];
        dp[1][2] = arr[1];
        if(n>=2){
            dp[2][1] = arr[2];
            dp[2][2] = dp[1][1]+arr[2];
            for(int i=3;i<n+1;i++){
                dp[i][1] = Math.max(dp[i-2][1],dp[i-2][2])+arr[i];
                dp[i][2] = dp[i-1][1] + arr[i];
            }
        }
        System.out.println(Math.max(dp[n][1], dp[n][2]));


    }
}
