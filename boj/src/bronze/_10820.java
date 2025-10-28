package boj.src.bronze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10820 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/mac/Desktop/test.txt")));
        String input;
        StringBuffer sb = new StringBuffer();
        while((input = br.readLine()) != null){
            int lower = 0;
            int upper = 0;
            int num = 0;
            int space = 0;
            for(int inputIdx=0;inputIdx<input.length();inputIdx++){
                if(Character.isLowerCase(input.charAt(inputIdx))){
                    lower += 1;
                } else if (Character.isUpperCase(input.charAt(inputIdx))) {
                    upper += 1;
                } else if (Character.isDigit(input.charAt(inputIdx))) {
                    num += 1;
                } else if (input.charAt(inputIdx) == ' ') {
                    space += 1;
                }
            }
            sb.append(lower).append(' ').append(upper).append(' ').append(num).append(' ').append(space).append("\n");
        }
        System.out.print(sb);
    }

}
