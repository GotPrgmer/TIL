package barkingdock.x09;

import java.util.*;
import java.io.*;

public class Boj9466 {
    // 현재 턴에서 방문했던
    static int[] want;

    // 전체에서 방문했던
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            want = new int[n+1];
            for(int i=1;i<n+1;i++){
                want[i] = Integer.parseInt(st.nextToken());
            }
            int ans = 0;
            for(int i=1;i<n+1;i++){
                if(isCheck(i,n)) ans++;
            }
            System.out.println(n-ans);
        }

    }
    static boolean isCheck(int idx,int n){
        int cur = idx;
        for(int i=0;i<n;i++){
            cur = want[cur];
            if(cur == idx) return true;
        }
        return false;
    }
}
