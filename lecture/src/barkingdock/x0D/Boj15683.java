package lecture.src.barkingdock.x0D;

// 해당 문제는 못풀었다.
// 그래서 블로그 답을 참고하였다.
// 못푼 이유는 백트래킹 시간복잡도계산이 어려워서 문제에 맞는 시간복잡도 계산을 할 수 없었다.

// 해답을 보니 백트래킹 시간복잡도는 완전탐색하는 시간복잡도라고 생각하면 될거같다.
// 그래서 4^8 * 8 * 8 이기에 2의 16승 = 65,536 이기에 시간복잡도 상에서 문제없다는 것을 알게 되었다.

// 또한 각 좌표당 방향을 4번 돌릴 수 있으므로 4진법을 통해서 구현을 하였다.

import java.util.*;
import java.io.*;
public class Boj15683 {
    static int[][] map;
    static int[][] map_for_cnt;
    static List<Pair> cctv;
    static int[] d_x = new int[]{-1,0,1,0};
    static int[] d_y = new int[]{0,1,0,-1};
    static int ans = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        map_for_cnt = new int[N][M];

        cctv = new ArrayList<>();
        // map 기록
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //cctv 찾기
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]>0 && map[i][j]<6){
                    cctv.add(new Pair(i,j));
                }
            }
        }

        //0부터 4^(size)-1까지 돌리기
        for(int t=0;t<1<<2*cctv.size();t++){
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    map_for_cnt[i][j] = map[i][j];
                }
            }
            int brute = t;
            for(int i=0;i<cctv.size();i++){
                int d = brute%4;
                brute = brute/4;

                Pair cctv_cur = cctv.get(i);
                int kind_cctv = map[cctv_cur.x][cctv_cur.y];
                if(kind_cctv == 1){
                    mark(cctv_cur,d);
                }
                else if(kind_cctv == 2){
                    mark(cctv_cur,d);
                    mark(cctv_cur,d+2);
                }
                else if(kind_cctv == 3){
                    mark(cctv_cur,d);
                    mark(cctv_cur,d+3);
                }
                else if(kind_cctv == 4){
                    mark(cctv_cur,d);
                    mark(cctv_cur,d+2);
                    mark(cctv_cur,d+3);
                }
                else if(kind_cctv == 5){
                    mark(cctv_cur,d);
                    mark(cctv_cur,d+1);
                    mark(cctv_cur,d+2);
                    mark(cctv_cur,d+3);
                }
            }
            int cnt_tmp = 0;
            //벽이 아니고 9도 아닌곳 카운트
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map_for_cnt[i][j] != 6 && map_for_cnt[i][j] != 9){
                        cnt_tmp += 1;
                    }
                }
            }
            ans = Math.min(ans,cnt_tmp);

        }
        System.out.println(ans);

    }
    static void mark(Pair pair, int d){
        d = d%4;
        //d 방향으로 맵에 부딪칠때까지 이동 or 벽에 부딪칠때까지
        int move = 0;
        int N= map_for_cnt.length;
        int M = map_for_cnt[0].length;
        while(true){
            int cur_x = pair.x + move*d_x[d];
            int cur_y = pair.y + move*d_y[d];
            map_for_cnt[cur_x][cur_y] = 9;

            //다음 진행해도 될까?
            int n_x = cur_x+d_x[d];
            int n_y = cur_y+d_y[d];
            if(n_x<0 || n_x>=N || n_y<0 || n_y>=M) break;
            if(map_for_cnt[n_x][n_y] == 6) break;
            move += 1;
        }

    }

    //특정 좌표와 d에 따라 좌표에서부터 d방향으로 진행
}
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
