package lecture.src.barkingdock.x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _3 {
    public static void main(String[] args) throws IOException {
        System.out.println(func2(new int[]{20,40,80},3));
    }
    private static int func2(int[] arr, int num){
        Arrays.sort(arr);
        int s = 0;
        int e = num-1;
        while(s<e){
            int tmpSum = arr[s]+arr[e];
            if(tmpSum<100){
                s += 1;
            }
            else if(tmpSum > 100){
                e -= 1;
            }
            //100이 존재
            else{
                return 1;
            }
        }
        return 0;
    }
}

//private static int func2(int[] arr, int num){
//    int[] check = new int[101];
//    for(int i=0;i<arr.length;i++){
//        if(check[100-arr[i]] != 0){
//            return 1;
//        }
//        else{
//            check[arr[i]] += 1;
//        }
//    }
//    return 0;
//}