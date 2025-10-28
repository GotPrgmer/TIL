package lecture.src.barkingdock.x06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Q queue = new Q();
        StringTokenizer st;
        for(int i=0;i<t;i++){
            st =  new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                queue.push(x);
            }
            else if(cmd.equals("pop")){
                System.out.println(queue.pop());
            }
            else if(cmd.equals("size")){
                System.out.println(queue.size());
            }
            else if(cmd.equals("empty")){
                System.out.println(queue.empty());
            }
            else if(cmd.equals("front")){
                System.out.println(queue.front());
            }
            else if(cmd.equals("back")){
                System.out.println(queue.back());
            }
        }
    }
    static class Q{
         int h;
         int t;
        static int max = 10_001;
        int[] dat;
        Q(){
            this.h = 0;
            this.t = 0;
            this.dat = new int[max];
        }
        void push(int x){
            dat[t++] = x;
        }
        int pop(){
            if(size() == 0){
                return -1;
            }
            else{
                return dat[h++];
            }
        }
        int size(){
            return t-h;
        }
        int empty(){
            if(size() == 0){
                return 1;
            }
            else{
                return 0;
            }
        }
        int front(){
            if(size() == 0){
                return -1;
            }
            else{
                return dat[h];
            }
        }
        int back(){
            if(size() == 0){
                return -1;
            }
            else{
                return dat[t-1];
            }
        }
    }
}
