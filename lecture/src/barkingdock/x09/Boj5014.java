package lecture.src.barkingdock.x09;
import java.util.*;
import java.io.*;

public class Boj5014 {
    static int[] visited;
    static Queue<Integer> q;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        visited = new int[F+1];
        q = new LinkedList<>();
        Arrays.fill(visited,-1);
        visited[S] = 0;
        q.add(S);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int d=0;d<2;d++){
                int n_num;
                if(d == 0) {
                    n_num = cur+U;
                }
                else{
                    n_num = cur-D;
                }
                if(n_num<1 || n_num >F) continue;
                if(visited[n_num] != -1) continue;
                visited[n_num] = visited[cur]+1;
                q.add(n_num);
            }
        }
        if(visited[G] != -1){
            System.out.println(visited[G]);
        }
        else{
            System.out.println("use the stairs");
        }


    }
}
