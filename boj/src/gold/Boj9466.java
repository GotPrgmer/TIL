package boj.src.gold;
import java.util.*;
import java.io.*;
public class Boj9466 {
    static int[] arr = new int[100005];
    static int n;
    static int[] state = new int[100005];

    static int NOT_VISITED = 0;
    static int VISITED = 1;
    static int CYCLE_IN = 2;
    static int NOT_CYCLE_IN = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-->0){
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<n+1;i++){
                arr[i] = Integer.parseInt(st.nextToken());
                state[i] = NOT_VISITED;
            }
            for(int i=1;i<n+1;i++){
                if(state[i] == NOT_VISITED) run(i);
            }
//            System.out.println(Arrays.toString(state));
            int cnt = 0;
            for(int i=1;i<n+1;i++){
                if(state[i] != CYCLE_IN){
                    cnt ++;
                }
            }
            System.out.println(cnt);


        }
    }

    static void run(int x){
        int cur = x;
        while(true){
            state[cur] = VISITED;
            cur = arr[cur];
            if(state[cur] == CYCLE_IN || state[cur] == NOT_CYCLE_IN){
                cur = x;
                while(state[cur] == VISITED){
                    state[cur] = NOT_CYCLE_IN;
                    cur = arr[cur];
                }
                return;
            }

            if(state[cur] == VISITED && cur != x){

                while (state[cur] != CYCLE_IN) {
                    state[cur] = CYCLE_IN;
                    cur = arr[cur];
                }
                cur = x;
                while (state[cur] != CYCLE_IN) {
                    state[cur] = NOT_CYCLE_IN;
                    cur = arr[cur];
                }
                return;
            }

            if(state[cur] == VISITED && cur == x){
                while(state[cur] == VISITED){
                    state[cur] = CYCLE_IN;
                    cur = arr[cur];
                }
                return;
            }
        }
    }
}
