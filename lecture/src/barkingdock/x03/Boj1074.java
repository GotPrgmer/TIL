package lecture.src.barkingdock.x03;
import java.util.*;
import java.io.*;
public class Boj1074 {
    static int N;
    static int r;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        System.out.println(solve(N, r, c));
    }
    //왜 if else가 아니지?
    //
    private static int solve(int n, int r, int c){
        if(n == 0) return 0;
        // 중간 값 보존
        int half = 1<<(n-1);
        //r이 1상자
        if(r< half && c< half) return solve(n - 1, r, c);
        //r이 2상자
        if(r< half && half<=c) return half * half + solve(n - 1, r, c - half);
        //r이 3상자
        if(half<=r  && c< half) return 2 * half * half + solve(n - 1, r - half, c);
        //r이 4상자
        else return 3 * half * half + solve(n - 1, r - half, c - half);
    }
}
