package lecture.src.barkingdock.x0E;
import java.util.*;
import java.io.*;
public class MergeSortSimple {
    static int[] arr1 = {-9,1,6,8,12};
    static int[] arr2 = {-7,7,13,15};
    public static void main(String[] args) throws IOException {
        int idx1=0;
        int idx2=0;
        int N = arr1.length;
        int M = arr2.length;
        int[] ans = new int[N+M];
        int add_idx = 0;
        for(int i=0;i<N+M;i++){
            int num = -1;
            if(arr1[idx1]>arr2[idx2]){
                num = arr2[idx2++];
            }
            else{
                num = arr1[idx1++];
            }
            ans[i] = num;
            if(idx1==N || idx2==M){
                add_idx=i+1;
                break;
            }
        }
        for(int i=add_idx;i<N+M;i++){
            for(int j=idx1;j<N;j++){
                ans[i] = arr1[idx1];
            }
            for(int j=idx2;j<M;j++){
                ans[i] = arr2[idx2];
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
