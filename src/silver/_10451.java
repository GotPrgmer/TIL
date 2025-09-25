package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _10451 {
    static StringTokenizer st;
    static boolean[] check;
    static List<List<Integer>> graph;
    static int ans;
    static Queue<Integer> q;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test=0;test<T;test++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            check = new boolean[N+1];
            //그래프 초기화
            graph = new ArrayList<>();
            ans = 0;
            q = new LinkedList<>();
            for(int idx=0;idx<N+1;idx++){
                graph.add(new ArrayList<>());
            }
            st = new StringTokenizer(br.readLine());
            for(int numList=1;numList<N+1;numList++){
                graph.get(numList).add(Integer.parseInt(st.nextToken()));
            }
            for(int node=1;node<N+1;node++){
                if(!check[node]){
                    bfs(node);
                }

            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int start){
        q.add(start);
        check[start] = true;
        while (!q.isEmpty()) {
            start = q.poll();
            for (int node : graph.get(start)) {
                if(!check[node]){
                    check[node] = true;
                    q.add(node);
                }
                else{
                    ans += 1;
                }
            }

        }
    }
}
