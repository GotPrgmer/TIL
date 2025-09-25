package barkingdock.x04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1406 {
    private static int M = 1000005;
    private static char[] data = new char[M];
    private static int[] nxt = new int[M];
    private static int[] pre = new int[M];
    private static int unused = 1;


    public static void init(){
        for(int i=0;i<M;i++){
            pre[i] = -1;
            nxt[i] = -1;
        }
    }
    public static void insert(int idx, char c){
        data[unused] = c;
        pre[unused] = idx;
        nxt[unused] = nxt[idx];
        if(nxt[idx]!= -1){
            pre[nxt[idx]] = unused;
        }
        nxt[idx] = unused;
        unused++;
    }

    public static void erase(int idx){
        nxt[pre[idx]] =nxt[idx];
        if(nxt[idx]!=-1){
            pre[nxt[idx]] = pre[idx];
        }
    }



    public static void main(String[] args) throws IOException {
    init();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String initialString = br.readLine();
    int cursor = 0;
    for(char c : initialString.toCharArray()){
        insert(cursor,c);
        cursor = nxt[cursor];
    }

    int T = Integer.parseInt(br.readLine());
    for(int i=0;i<T;i++){
        String[] input = br.readLine().split(" ");
        char cmd = input[0].charAt(0);
        if(cmd == 'L' && pre[cursor] != -1){
            cursor = pre[cursor];
        }
        else if(cmd == 'D' && nxt[cursor] != -1){
            cursor = nxt[cursor];
        }
        else if(cmd == 'B' && pre[cursor] != -1){
            int nodeToRemove = pre[cursor];
            erase(cursor);
            cursor = nodeToRemove;
        }
        else if(cmd == 'P'){
            insert(cursor,input[1].charAt(0));
            cursor = nxt[cursor];
        }
    }
    StringBuilder sb = new StringBuilder();
    int outputCursor = nxt[0];
    while(outputCursor != -1){
        sb.append(data[outputCursor]);
        outputCursor = nxt[outputCursor];
    }
    System.out.println(sb.toString());
    }
}

