package barkingdock.x06;

public class queue {
    private static int MX = 1000005;
    private static int[] dat = new int[MX];
    private static int head = 0;
    private static int tail = 0;
    public static void main(String[] args){
        test();
    }
    static void push(int x){
        dat[tail++] = x;
    }
    static void pop(){
        head += 1;
    }
    static int front(){
        return dat[head];
    }
    static int back(){
        return dat[tail-1];
    }
    static void test(){
        push(10);push(20);push(30);
        System.out.println(front());
        System.out.println(back());
        pop(); pop();
        push(15); push(25);
        System.out.println(front());
        System.out.println(back());
    }
}
