package lecture.src.barkingdock.x10;
import java.util.*;
import java.io.*;
public class Boj11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+1];
        dp[1] = 1;
        if(n>=2){
            dp[2] = 2;
            for(int i=3;i<n+1;i++){
                dp[i] = (dp[i-1]+dp[i-2]);
            }
        }
        System.out.println(dp[n]%10007);

    }

}
