package lecture.src.barkingdock.x12;
import java.util.*;
import java.io.*;
public class Boj1707 {
    static int v;
    static int e;
    static List<Integer>[] graph;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            graph = new ArrayList[v+1];
            for(int i=0;i<v+1;i++) graph[i] = new ArrayList<>();
            for(int i=0;i<e;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            visited = new int[v + 1];
            boolean isBipartite = true;

            // ⚠ 모든 정점에 대해 컴포넌트 단위로 검사
            for (int i = 1; i <= v; i++) {
                if (visited[i] == 0) {      // 아직 색칠되지 않은 컴포넌트
                    if (!bfs(i)) {          // 여기서 하나라도 false면 전체 NO
                        isBipartite = false;
                        break;
                    }
                }
            }

            if (isBipartite) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    static boolean bfs(int s){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        visited[s] = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            for (int nxt : graph[cur]) {
                if(visited[nxt] == 0) {
                    visited[nxt] = -visited[cur];
                    q.add(nxt);
                }
                else{
                    if (visited[nxt] == visited[cur]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
