package lecture.src.barkingdock.x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1629 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         int A = Integer.parseInt(st.nextToken());
         int B = Integer.parseInt(st.nextToken());
         int C = Integer.parseInt(st.nextToken());
        System.out.println(solve(A,B,C));

    }

    //현재 B만큼 곱함 (1부터 시작)
    //1 -> 2,3 식으로 나감
    static long solve(int A, int B, int C){
        if(B==1) return A%C;
        long val = solve(A, B / 2, C);
        val = val * val % C;
        if(B%2==0) return val;
        return val*A%C;
    }
}

//    static long cal(int A, int B, int C) {
//        if(B==0){
//            return 1;
//        }
//        else if(B==1){
//            return A%C;
//        }
//        else{
//            long val = cal(A,B/2,C)%C;
//            val = val*val%C;
//            if(B%2 == 0){
//                return val;
//            }
//            else{
//                return val*A%C;
//            }
//        }
//    }
