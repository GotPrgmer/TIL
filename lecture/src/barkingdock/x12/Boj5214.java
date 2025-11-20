package lecture.src.barkingdock.x12;
import java.io.*;
import java.util.*;

public class Boj5214 {
    static int N, K, M;
    static List<Integer>[] stationToHyper, hyperToStation;
    static boolean[] visitedHyper;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        hyperToStation = new ArrayList[M+1];
        stationToHyper = new ArrayList[N+1];

        for(int i=0;i<M+1;i++) hyperToStation[i] = new ArrayList<>();
        for(int i=0;i<N+1;i++) stationToHyper[i] = new ArrayList<>();
        for(int i=1;i<M+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<K;j++){
                int station = Integer.parseInt(st.nextToken());
                hyperToStation[i].add(station);
                stationToHyper[station].add(i);
            }
        }
        bfs(1);
        if(dist[N] == 0){
            System.out.println(-1);
        }
        else{
            System.out.println(dist[N]);
        }

    }
    private static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visitedHyper = new boolean[M+1];
        dist = new int[N+1];
        dist[1] = 1;
        while(!q.isEmpty()){
            int curStation = q.poll();
            //역에서 하이퍼 가기
            for (int hyper : stationToHyper[curStation]) {
                if(visitedHyper[hyper]) continue;
                visitedHyper[hyper] = true;
                for (int s : hyperToStation[hyper]) {
                    if (dist[s] != 0 ) continue;
                    dist[s] = dist[curStation] + 1;
                    q.add(s);
                }
            }
        }
    }
}
