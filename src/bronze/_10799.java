package bronze;

import java.io.*;
import java.util.Stack;

public class _10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for(int idx=0;idx<input.length();idx++){
            if(input.charAt(idx)=='('){
                stack.push('(');
            }
            else{
                stack.pop();
                if(input.charAt(idx-1)=='('){
                    result += stack.size();
            }
                else{
                    result += 1;
                }

            }
        }
        br.close();
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
