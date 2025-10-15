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
        quickSort(0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static void quickSort(int st, int en){
        if(en<=st+1) return;
        int pivot_idx = st;
        int l = st+1;
        int r = en-1;
        while(true){
            while(l<=r && arr[l]<=arr[pivot_idx]) l++;
            while(l<=r && arr[r]>=arr[pivot_idx]) r--;
            if(r<l) break;
            swap(l,r);
        }
        swap(st,r);
        quickSort(st,r);
        quickSort(r+1,en);
    }

    static void swap(int idx1, int idx2){
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
