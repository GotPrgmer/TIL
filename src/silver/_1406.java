package silver;

import java.io.*;
import java.util.*;

public class _1406 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int testLine = Integer.parseInt(br.readLine());
        Stack<Character> stackLeft = new Stack<>();
        Stack<Character> stackRight = new Stack<>();
        for (int inputIdx = 0; inputIdx < input.length(); inputIdx++) {
            stackLeft.add(input.charAt(inputIdx));
        }
        for(int cmdIdx=0;cmdIdx<testLine;cmdIdx++){
            String cmd = br.readLine();
            char cmdKind = cmd.charAt(0);
            if (cmdKind=='L') {
                if (stackLeft.size()!=0) {
                    stackRight.add(stackLeft.pop());
                }
            } else if (cmdKind=='D') {
                if (stackRight.size()!=0) {
                    stackLeft.add(stackRight.pop());
                }
            } else if (cmdKind=='B') {
                if (stackLeft.size()!=0) {
                    stackLeft.pop();
                }
            } else if (cmdKind=='P') {
                char plusChar = cmd.charAt(2);
                stackLeft.add(plusChar);
            }
        }
        while (!stackLeft.isEmpty()) {
            stackRight.add(stackLeft.pop());
        }
        while (!stackRight.isEmpty()) {
            bw.append(stackRight.pop());
        }
        bw.flush();
        bw.close();
    }
}
