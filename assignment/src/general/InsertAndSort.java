package assignment.src.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertAndSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputA = br.readLine().split(" ");
        List<Integer> aList = new ArrayList<>();
        for (int i = 0;i < inputA.length ; i++){
            aList.add(Integer.parseInt(inputA[i]));
        }
        Collections.sort(aList);
        for (int i:aList){
            System.out.print(i+" ");
        }
        String[] inputB = br.readLine().split(" ");
        List<Integer> bList = new ArrayList<>();
        for (int i = 0;i < inputB.length ; i++){
            bList.add(Integer.parseInt(inputB[i]));
        }
        int idx = 0;
        while (idx<bList.size()){
            boolean flag = false;
            for (int i=0;i<aList.size();i++){
                if (aList.get(i) == bList.get(idx)){
                    aList.add(i,bList.get(idx));
                    flag = true;
                    break;
                }
                else if(bList.get(idx)<aList.get(i)){
                    aList.add(i,bList.get(idx));
                    flag = true;
                    break;
                }

            }
            if (!flag){
                aList.add(bList.get(idx));
            }
            idx += 1;

        }
        for (int i:aList){
            System.out.print(i+" ");
        }

    }
}
