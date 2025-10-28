package lecture.src.barkingdock.x01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i=1;i<Math.log(num)+1;i++){
            if(i*i==num){
                ans = 1;
            }
        }
        System.out.println(ans);
    }
}
