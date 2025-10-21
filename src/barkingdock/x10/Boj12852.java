package barkingdock.x10;
import java.util.*;
import java.io.*;

public class Boj12852 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int[] pre = new int[N + 1];
        dp[1] = 0;
        for(int i=2;i<N+1;i++){
            dp[i] = dp[i-1]+1;
            pre[i] = i-1;

            if(i%2==0 && dp[i / 2]+1 < dp[i] ){
                dp[i] = dp[i / 2]+1;
                pre[i] = i/2;
            }
            if(i%3==0 && dp[i / 3]+1 < dp[i] ){
                dp[i] = dp[i / 3]+1;
                pre[i] = i/3;
            }

        }
        System.out.println(dp[N]);
    /*
    N에서 1혹은 2 혹은 3으로 줄여나가면서 최소를 선택해서 찍는다
     */
        int cur =N;
        StringBuilder sb = new StringBuilder();
        while(cur>0){
            sb.append(cur).append(" ");
            cur = pre[cur];
        }
        System.out.println(sb);
    }
}

