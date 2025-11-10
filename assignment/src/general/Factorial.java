package assignment.src.general;
/*
어떤 수를 입력하더라도 해당 수가 팩토리얼 수 인지를 판단하는 프로그램을 만들자
 */
import java.math.BigInteger;
import java.io.*;
public class Factorial {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("N을 입력하세요.");
        String n = br.readLine();

        System.out.println(solve(n));

    }

    public static boolean solve(String n){
        BigInteger target;
        target = new BigInteger(n);
        if (target.equals(BigInteger.ONE)) {
            return true;
        }
        BigInteger current = BigInteger.ONE;
        BigInteger num = BigInteger.ONE;
        while (current.compareTo(target) < 0) {
            current = current.multiply(num);
            num = num.add(BigInteger.ONE);
        }
        return current.compareTo(target) == 0;
    }
}
