package barkingdock.x07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        StringTokenizer st;
        Dq dq = new Dq();
        for(int i=0;i<t;i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push_front")){
                int x = Integer.parseInt(st.nextToken());
                dq.push_front(x);
            }
            else if(cmd.equals("push_back")) {
                int x = Integer.parseInt(st.nextToken());
                dq.push_back(x);
            }
            else if(cmd.equals("pop_front")) {
                System.out.println(dq.pop_front());
            }
            else if(cmd.equals("pop_back")) {
                System.out.println(dq.pop_back());
            }
            else if(cmd.equals("size")) {
                System.out.println(dq.size());
            }
            else if(cmd.equals("empty")) {
                System.out.println(dq.empty());
            }
            else if(cmd.equals("front")) {
                System.out.println(dq.front());
            }
            else if(cmd.equals("back")) {
                System.out.println(dq.back());
            }
        }
    }

}
class Dq{
    int head;
    int tail;
    int MX = 10001;
    int[] dat;
    Dq(){
        this.head = MX;
        this.tail = MX;
        this.dat = new int[2*MX+1];
    }

    void push_front(int x){
        dat[--head] = x;
    }

    void push_back(int x){
        dat[tail++] = x;
    }

    int pop_front(){
        if(head == tail){
            return -1;
        }
        return dat[head++];
    }

    int pop_back(){
        if(head == tail){
            return -1;
        }
        return dat[--tail];
    }

    int size(){
        return tail-head;
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
        return dat[head];
    }
    int back(){
        if(size() == 0){
            return -1;
        }
        return dat[tail-1];
    }
}
