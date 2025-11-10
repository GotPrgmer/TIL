package assignment.src.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String[] input_list = br.readLine().split("");
            if(input_list[1].equals("+")){
                System.out.println(Integer.parseInt(input_list[0])+Integer.parseInt(input_list[2]));
            }
            else if(input_list[1].equals("-")){
                System.out.println(Integer.parseInt(input_list[0])-Integer.parseInt(input_list[2]));
            }
            else if(input_list[1].equals("*")){
                System.out.println(Integer.parseInt(input_list[0])*Integer.parseInt(input_list[2]));
            }
            else if(input_list[1].equals("/")){
                System.out.println(Integer.parseInt(input_list[0])/Integer.parseInt(input_list[2]));
            }

        }


    }
}
