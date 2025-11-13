package lecture.src.barkingdock.x18;
import java.util.*;
import java.io.*;
public class Boj2606 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int comNum = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());
        parent = new int[comNum+1];
        for(int i=0;i<comNum;i++) parent[i] = i;
        for(int i=0;i<pair;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            union(first,second);
        }

        int root = find(1);
        int ans = 0;
        for(int i=2;i<comNum+1;i++){
            if(find(i) == root){
                ans++;
            }
        }
        System.out.println(ans);
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y) parent[y] = x;
    }
    static int find(int x){

        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}
