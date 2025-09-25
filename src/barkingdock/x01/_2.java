package barkingdock.x01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2 {
    static int[] cards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cards = new int[20];
        //카드 입력
        for(int i = 0;i<20;i++){
            cards[i] = i+1;
        }
        for(int i=0;i<10;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            reverse(s-1,e-1);
        }
        for(int i=0;i<20;i++){
            System.out.print(cards[i]+" ");
        }
    }

    private static void reverse(int s, int e){
        for(int i=0;i<(e-s+1)/2;i++){
            cards[e-i] = swap(cards[s+i],cards[s+i] = cards[e-i]);
        }
    }
    private static int swap(int a, int b){
        return a;
    }
}
