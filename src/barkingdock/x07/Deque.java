//package barkingdock.x07;
//
//public class Deque {
//    private static int MX = 1000005;
//    private static int[] dat = new int[2*MX+1];
//    static int head = MX, tail = MX;
//    public static void main(String[] args){
//        test();
//    }
//
//    static void push_front(int x){
//        dat[--head] = x;
//    }
//
//    static void push_back(int x){
//        dat[tail++] = x;
//    }
//
//    static void pop_front(){
//        head++;
//    }
//
//    static void pop_back(){
//        tail--;
//    }
//
//    static int front(){
//        return dat[head];
//    }
//
//    static int back(){
//        return dat[tail-1];
//    }
//
//    static void test(){
//        push_back(30); // 30
//        System.out.println(front()); // 30
//        System.out.println(back()); // 30
//        push_front(25); // 25 30
//        push_back(12); // 25 30 12
//        System.out.println(front());
//        System.out.println(back()); // 12
//        push_back(62); // 25 30 12 62
//        pop_front(); // 30 12 62
//        System.out.println(front()); // 30
//        pop_front(); // 12 62
//        System.out.println(back()); // 62
//    }
//}
