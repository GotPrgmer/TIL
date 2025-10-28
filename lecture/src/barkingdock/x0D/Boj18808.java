package lecture.src.barkingdock.x0D;
// 회전을 생각하는데 조금 애를 먹었다.
// -> 하나씩 손으로 풀어서 해결
// rotate할때 전부 포함하는 영역을 넓게 잡아서 현재 스티커를 임시 배열에 복사 후
// 기존 스티커에 값을 넣는다. sticker -> tmp -> 회전된 sticker
// check함수에 스티커를 붙이는 코드를 넣어도 됐을 거 같다.
// while(-k)식으로 해서 스티커 개수만큼 돌려도 좋았을거 같다.
// 변수가 복잡할땐 1순위로 x, y로 하고 그 다음 행 열을 r c로 하자.
// check에서 시작하는 첨자를 x, y로 하고 스티커 전체 영역을 r c로 하자.
// -> 헷갈리지 않도록!

import java.util.*;
import java.io.*;;
public class Boj18808 {
    static int[][] sticker;
    static int[][] copy;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        board = new int[N][M];


        for(int t=0;t<K;t++){
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            sticker = new int[R][C];
            copy = new int[R][C];
            //모눈종이에 숫자 넣기
            for(int i=0;i<R;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<C;j++){
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                    copy[i][j] = sticker[i][j];
                }
            }
            int cur_R = R;
            int cur_C = C;
            boolean isFit = false;
            for(int d=0;d<4;d++){
                if(d==1){
                    cur_R = C;
                    cur_C = R;
                }
                else if(d==2){
                    cur_R = R;
                    cur_C = C;
                }
                else if(d==3){
                    cur_R = C;
                    cur_C = R;
                }
                copy = new int[cur_R][cur_C];
                //rotate
                rotate(cur_R,cur_C,d);

                //해당 스티커가 들어갈 수 있는 지 체크하기
                for(int start_x=0;start_x<N-cur_R+1;start_x++){
                    for(int start_y=0;start_y<M-cur_C+1;start_y++){
                        if(check(cur_R,cur_C,start_x,start_y)){
                            isFit = true;
                            //스티커 붙이기
                            fillSticker(cur_R,cur_C,start_x,start_y);
                            break;
                        }
                    }
                    if(isFit){
                        break;
                    }
                }
                //스티커
                if(isFit){
                    break;
                }

            }



        }
        int ans = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j] == 1){
                    ans ++;
                }
            }
        }
        System.out.println(ans);

    }
    static public boolean check(int N, int M, int start_x, int start_y){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(copy[i][j] == 1 && board[start_x+i][start_y+j] == copy[i][j]) return false;
            }
        }
        return true;
    }
    static public void fillSticker(int N, int M, int start_x, int start_y){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(copy[i][j] == 1){
                    board[start_x+i][start_y+j] = copy[i][j];
                }
            }
        }
    }
    static public void rotate(int cur_R, int cur_C, int d){
        int R = sticker.length;
        int C = sticker[0].length;
        if(d==0){
            for(int i=0;i<R;i++){
                for(int j=0;j<C;j++){
                    copy[i][j] = sticker[i][j];

                }
            }
        }
        else{
            for(int i=0;i<R;i++){
                for(int j=0;j<C;j++){
                    if(d==1){
                        copy[j][cur_C-1-i] = sticker[i][j];
                    }
                    else if(d==2){
                        // 5 2
                        copy[cur_R-1-i][cur_C-1-j] = sticker[i][j];
                    }
                    else if(d==3){
                        copy[cur_R-1-j][i] = sticker[i][j];
                    }

                }
            }
        }

    }
}
