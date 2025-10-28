package lecture.src.barkingdock.x10;
import java.util.*;
import java.io.*;
public class Boj2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int sum = 0;
        for(int i=1;i<n+1;i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        int[] dp = new int[n+1];
        //dp는 i개의 계단까지의 경로에서 스킵할 계단의 최소합이다
        //i는 n보다 작다
        // 단 i번째 계단은 스킵한다고 가정
        // n의 경로에서 dp[i]를 사용해야하므로
        // i를 지나서도 해당 경로가 유지되어야하므로
        // 그러면 i-1는 반드시 방문해야한다.
        // 그리고 i-2나 i-3는 i-4를 방문한다고 가정할 때
        // 세계단을 한번에 못오르므로 i-2, i-3 중 하나는 방문해야한다.
        dp[1] = arr[1];
        if(n==1){
            System.out.println(arr[1]);
        }
        if(n==2){
            System.out.println(arr[1]+arr[2]);
        }
        if(n>=3){
            dp[2] = arr[2];
            dp[3] = arr[3];
            for(int i=4;i<n+1;i++){
                dp[i] = arr[i] + Math.min(dp[i - 2], dp[i - 3]);
            }
            System.out.println(sum - Math.min(dp[n-1],dp[n-2]));
        }
    }
}
