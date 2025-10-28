package lecture.src.barkingdock.x0F;
import java.util.*;
import java.io.*;
public class Boj11652 {
    static long[] arr;
    public static void main(String[] argS) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new long[n+1];
        for(int i=0;i<n;i++){
            arr[i] = Long.parseLong(br.readLine());
        }
        int cnt = 1;
        long maxVal = -Long.MAX_VALUE;
        int maxCnt = 0;
        arr[n] = Long.MAX_VALUE;
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i++){
            if( arr[i-1] == arr[i]) cnt++;
            else{
                if(cnt > maxCnt){
                    maxCnt = cnt;
                    maxVal = arr[i-1];
                }
                cnt = 1;
            }
        }
        System.out.println(maxVal);
    }
}
