package assignment.src.general;

import java.util.Scanner;

public class Factorial {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.println("N을 입력하세요.");
        n = scanner.nextInt();

        System.out.println(solve(n));

    }

    public static int solve(int n){
        int value = 2;
        int ans = 2;
        boolean flag = false;
        while (value<=n){
            if(value==n){
                flag = true;
                break;
            }
            else{
                value *= (value+1);
                ans += 1;
            }

        }
        if(flag){
            return ans;
        }
        else{
            return -1;
        }

    }
}
