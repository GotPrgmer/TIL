package lecture.src.barkingdock.x09;
import java.util.*;
import java.io.*;
/*
이번 문제를 풀지 못한 이유는 BFS를 ‘플레이어별로 분리된 큐 배열로 관리한다’는 발상을 떠올리지 못했기 때문이다.
하나의 큐로 전체를 돌리려다 보니, 각 플레이어가 동시에 확장하되 자신의 이동력(numP[i])만큼만 진행해야 한다는 조건을 처리하지 못했다.

또한, 각 플레이어의 턴에서 큐의 현재 크기(size)만큼만 돌려 한 단계(한 거리 레벨)씩 확장하고,
이 과정을 이동력만큼(moveLimit) 반복해야 한다는 BFS의 레벨 단위 확장 구조를 설계하지 못했다.

마지막으로, expanded 플래그를 통해 이번 턴에서 확장이 일어났는지를 확인함으로써
전체 while 루프(모든 플레이어 턴 반복)를 제어해야 한다는 점을 놓쳤다.
 */
public class Boj16920 {
    static int N;
    static int M;
    static int P;
    static int[] numP;
    static int[][] board;
    static int[][] visited;
    static int[] dX = {-1, 0, 1, 0};
    static int[] dY = {0, 1, 0, -1};
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        numP = new int[P+1];
        board = new int[N][M];
        ans = new int[P+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<P+1;i++){
            numP[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            char[] c = br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                if (c[j] == '#') board[i][j] = -1;
                else if (c[j] != '.') board[i][j] = c[j] - '0';
            }
        }
        bfs();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<P+1;i++){
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);


    }
    static void bfs() {
        Queue<Pair16920>[] q = new ArrayDeque[P + 1];
        for (int i = 1; i <= P; i++) q[i] = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] > 0) {
                    int num = board[i][j];
                    q[num].add(new Pair16920(i, j));
                    ans[num]++;
                }
            }
        }
        boolean expanded = true;
        while (expanded) {
            expanded = false;
            // moveLimit를 줘서 성의 갯수만큼 돌리기
            for (int i = 1; i < P + 1; i++) {
                int moveLimit = numP[i];
                Queue<Pair16920> tempQ = new ArrayDeque<>();
                // 각 성 별 q의 사이즈 만큼 돌리고 tempQ에 새로운 확장 좌표를 넣고
                while (!q[i].isEmpty()) {
                    for (int s = 0, size = q[i].size(); s < size; s++) {
                        Pair16920 cur = q[i].poll();
                        for (int d = 0; d < 4; d++) {
                            int nX = cur.x + dX[d];
                            int nY = cur.y + dY[d];
                            if (check(nX, nY)) continue;
                            if (board[nX][nY] != 0) continue;
                            board[nX][nY] = i;
                            ans[i]++;
                            tempQ.add(new Pair16920(nX, nY));
                            // 하나라도 확장하면
                            expanded = true;
                        }
                    }
                    moveLimit--;
                    if (moveLimit == 0) break;
                    q[i].addAll(tempQ);
                    tempQ = new ArrayDeque<>();
                }
                q[i] = tempQ;
            }

        }
    }
    static boolean check(int x, int y){
        return x<0 || x>=N || y<0 || y>=M;
    }
    static class Pair16920{
        int x;
        int y;
        Pair16920(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
