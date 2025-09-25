package barkingdock.x04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class boj1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1;i<n+1;i++){
            list.add(i);
        }
        ListIterator<Integer> lstIterator = list.listIterator();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!list.isEmpty()){
            cnt += 1;
            int remember=0;
            if(lstIterator.hasNext()){
                remember = lstIterator.next();
            }
            else{
                lstIterator = list.listIterator();

                remember = lstIterator.next();


            }
            if(cnt%k == 0){
//                System.out.println(remember);
                sb.append(remember);
                lstIterator.remove();
                if(!list.isEmpty()){
                    sb.append(", ");
                }
            }
        }
        sb.append(">");
        System.out.println(sb.toString());
    }

}

