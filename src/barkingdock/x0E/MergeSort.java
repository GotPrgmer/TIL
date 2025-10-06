package barkingdock.x0E;

import java.util.*;
import java.io.*;
public class MergeSort {
    static int n = 10;
    static int[] arr = new int[1000001];
    static int[] tmp = new int[1000001]; // merge 함수에서 리스트 2개를 합친 결과를 임시로 저장하고 있을 변수
    public static void main(String[] args) throws IOException {
        int[] input_arr = new int[]{15, 25, 22, 357, 16, 23, -53, 12, 46, 3};

        for(int i=0;i<n;i++){
            arr[i] = input_arr[i];
        }

        merge_sort(0,n);
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    // mid = (st+en)/2라고 할 때 arr[st:mid], arr[mid:en]은 이미 정렬이 되어있는 상태일 때 arr[st:mid]와 arr[mid:en]을 합친다.
    static void merge(int st, int en){
        int mid = (st+en)/2;
        int[] arr1 = Arrays.copyOfRange(arr,st,mid);
        int[] arr2 = Arrays.copyOfRange(arr,mid,en);
        int l1 = arr1.length;
        int l2 = arr2.length;
        int idx1 = 0;
        int idx2 = 0;
        for(int i=0;i<l1+l2;i++){
            if(idx1==l1) tmp[i] = arr2[idx2++];
            else if(idx2==l2) tmp[i] = arr1[idx1++];
            else if(arr1[idx1]>arr2[idx2]) tmp[i] = arr2[idx2++];
            else tmp[i] = arr1[idx1++];
        }
        for(int i=st;i<en;i++){
            arr[i] = tmp[i-st];
        }
    }

    // arr[st:en]을 정렬하고 싶다.
    static void merge_sort(int st, int en){
        if(st+1==en) return;
        int mid = (st+en)/2;
        merge_sort(st, mid); // arr[st:mid]를 정렬한다.
        merge_sort(mid, en); // arr[mid:en]을 정렬한다.
        merge(st, en); // arr[st:mid]와 arr[mid:en]을 합친다.
    }
}


