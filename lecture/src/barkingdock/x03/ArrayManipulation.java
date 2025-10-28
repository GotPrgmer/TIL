package lecture.src.barkingdock.x03;
import java.util.*;

public class ArrayManipulation {

    public static int[] insert(int idx, int num, int[] arr){
        int[] tmp = new int[arr.length+1];
        for(int i=0;i<idx;i++){
            tmp[i] = arr[i];
        }
        tmp[idx] = num;
        for(int i=idx;i<arr.length;i++){
            tmp[i+1] = arr[i];
        }
        return tmp;

    }

    public static int[] erase(int idx, int[] arr){
        int[] tmp = new int[arr.length-1];
        //idx전은 복사
        for(int i=0;i<idx;i++){
            tmp[i] = arr[i];
        }
        for(int i=idx;i<arr.length;i++){
            tmp[i-1] = arr[i];
        }
        return tmp;
    }

    // 배열 내용을 출력하는 메서드
    public static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    public static void insertTest() {
        System.out.println("***** insert_test *****");
        int[] arr = {10, 20, 30};

        // 인덱스 3에 40 삽입
        arr = insert(3, 40, arr); // 10 20 30 40
        printArr(arr);

        // 인덱스 1에 50 삽입
        arr = insert(1, 50, arr); // 10 50 20 30 40
        printArr(arr);

        // 인덱스 0에 15 삽입
        arr = insert(0, 15, arr); // 15 10 50 20 30 40
        printArr(arr);
    }

    public static void eraseTest() {
        System.out.println("***** erase_test *****");
        int[] arr = {10, 50, 40, 30, 70, 20};

        // 인덱스 4의 원소 삭제
        arr = erase(4, arr); // 10 50 40 30 20
        printArr(arr);

        // 인덱스 1의 원소 삭제
        arr = erase(1, arr); // 10 40 30 20
        printArr(arr);

        // 인덱스 3의 원소 삭제
        arr = erase(3, arr); // 10 40 30
        printArr(arr);
    }

    public static void main(String[] args) {
        insertTest();
        eraseTest();
    }
}
