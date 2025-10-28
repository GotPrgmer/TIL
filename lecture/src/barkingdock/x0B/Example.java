package lecture.src.barkingdock.x0B;

import java.io.IOException;

public class Example {
    public static void main(String[] args) throws IOException {
        nToOne(10);
        System.out.println(nToOneSum(100));
    }
    static void nToOne(int num){
        if(num == 0){
            return;
        }
        System.out.println(num);
        nToOne(num-1);

    }

    static int nToOneSum(int num){
        if(num == 0){
            return 0;
        }
        return nToOneSum(num-1)+num;
    }
}
