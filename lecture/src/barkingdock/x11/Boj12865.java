package lecture.src.barkingdock.x11;
import java.util.*;
import java.io.*;
/* 풀이 실패
// dp[i][j]에 대한 정의가 올바르지 않았음
// dp[i][j]를 i번째 물건을 고려할때 무게가 j인 상태에서 최대 가치
//
정확히 $j$ 무게를 요구하면, $DP[i-1][j - W_i]$가 의미하는 바가 '최대 가치'가 아닌 '정확히 $j - W_i$ 무게인 최대 가치'가 됩니다.
이 값이 0이라면, $j - W_i$ 무게보다 작은 무게로 더 큰 가치를 얻을 수 있었던 이전의 최적해를 버리게 됩니다.
또한 점화식에서는 부분문제를 기반으로 작성해야하는데 이러면 부분문제가 아니게 되므로 전체를 해결할 수 없게 됨
dp[i][j]의 올바른 정의는 무게 제한이 j일때 최대 가치 */

public class Boj12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] value = new int[N];
        int[] weight = new int[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N][100001];
        for(int i=0;i<K+1;i++){
            if(i>=weight[0]){
                dp[0][i] = value[0];
            }
        }

        for(int i=1;i<N;i++){
            for(int j=1;j<K+1;j++){
                // i를 선택하지 않을 때
                dp[i][j] = dp[i-1][j];
                // i를 선택했을때 최대값
                // dp[i-1][j]가 0이 아닐때 추가할수있음
                if(j-weight[i]>=0){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j-weight[i]]+value[i]);
                }
            }
        }
        System.out.println(dp[N-1][K]);
    }
}