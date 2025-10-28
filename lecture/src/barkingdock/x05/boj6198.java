package lecture.src.barkingdock.x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj6198 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        Stack<Long> st = new Stack<>();
        long ans = 0;
        for(int i=l-1;i>-1;i--){
            long h = Long.parseLong(br.readLine());
            //ans기록
            while(!st.isEmpty() && st.peek() <= h){
                st.pop();
            }
            if(st.isEmpty()){
                System.out.println("stack empty");
            }
            else{
                System.out.println(st.peek());
            }
            ans += st.size();
            st.add(h);
        }
        System.out.println(ans);
    }
}
