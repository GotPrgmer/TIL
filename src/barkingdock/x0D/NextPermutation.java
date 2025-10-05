package barkingdock.x0D;
import java.util.*;
import java.io.IOException;
public class NextPermutation {
    public static void main(String[] args) throws IOException {
        System.out.println(nextPermutation(new int[]{1, 0, 1, 0}));
    }

    public static boolean nextPermutation(int[] a) {
        int n = a.length;
        int i = n - 2;

        // 1) 뒤에서 오름차순 깨지는 지점 찾기
        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i < 0) { // 이미 마지막 순열
            reverse(a, 0, n - 1);
            return false;
        }

        // 2) i 뒤쪽에서 a[i]보다 큰 값 찾기
        int j = n - 1;
        while (a[j] <= a[i]) j--;

        // 3) swap 후 뒤집기
        swap(a, i, j);
        reverse(a, i + 1, n - 1);

        // 4) 배열 출력
        System.out.println(Arrays.toString(a));
        return true;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private static void reverse(int[] a, int l, int r) {
        while (l < r) swap(a, l++, r--);
    }
}
