package barkingdock.x0E;
import java.util.*;
import java.io.*;
public class QuickSort {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        //pivot 선정은 리스트 맨앞
        //피봇을 기준으로 1은 l n-1은 r로 둬서 피봇보다 l(크고)r(작은)값이 나올때 스왑
        //l과 r이 교차된다면 그때 pivot이랑 r을 교체
        arr = new int[]{6, -8, 1, 12, 8, 3, 7, -7};
        quickSort(arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static void quickSort(int n){
        //l과 r
        int l = 1;
        int r = n-1;
        while(l<=r && l<n){
            if(arr[r]>=arr[0]){
                r-= 1;
            }
            if(arr[l]<=arr[0]){
                l+=1;
            }
            if(l<r && arr[r]<arr[0] && arr[l]>arr[0]){
                swap(l,r);
            }
        }
        if(r==0){
            return;
        }
        else{
            swap(0,r);
            quickSort(n);
        }
    }

    static void swap(int idx1, int idx2){
        int tmp = arr[idx2];
        arr[idx2] = arr[idx1];
        arr[idx1] = tmp;
    }
}
