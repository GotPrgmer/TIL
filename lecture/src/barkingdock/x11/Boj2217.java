package lecture.src.barkingdock.x11;
import java.util.*;
import java.io.*;
public class Boj2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];
        for(int i=0;i<N;i++){
            ropes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ropes);
        int w = -1;
        int k = N;
        for(int i=1;i<=N;i++){
            w = Math.max(ropes[N-i]*i,w);
        }
        System.out.println(w);
    }
}
