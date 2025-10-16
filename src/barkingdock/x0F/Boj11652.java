package barkingdock.x0F;
import java.util.*;
import java.io.*;
public class Boj11652 {
    static long[] arr;
    public static void main(String[] argS) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new long[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        int cnt = 0;
        long maxVal = -Long.MAX_VALUE;
        int maxCnt = 0;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(i==0 || arr[i-1] == arr[i]) cnt++;
            else{
                if(cnt > maxCnt){
                    maxCnt = cnt;
                    maxVal = arr[i-1];
                }
                cnt = 1;
            }
        }
        if(cnt > maxCnt){
            maxVal = arr[n-1];
        }
        System.out.println(maxVal);
    }
}
