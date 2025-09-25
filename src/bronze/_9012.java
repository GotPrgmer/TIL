package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testLine = Integer.parseInt(br.readLine());
        for(int idx=0;idx<testLine;idx++){
            System.out.println(solve(br.readLine()));

        }


    }
    public static String solve(String s){
        Stack<Character> stack = new Stack<>();
        for(int idx=0;idx<s.length();idx++){
            if (s.charAt(idx) == '(') {
                stack.push('(');

            } else if (stack.empty()) {
                return "NO";
            } else {
                stack.pop();
            }
        }
        if (stack.empty()) {
            return "YES";
        }else{
            return "NO";
        }
    }
}
