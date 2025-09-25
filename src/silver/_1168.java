package silver;

import java.io.*;

public class _1168 {
    static int N, K;
    static int[] arr, tree;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int treeStorage = (int) (Math.log(N) / Math.log(2))+1;

        tree = new int[treeStorage];
        int findIdx = 1;
        init(1, N, 1);
        bw.append("<");
        for (int i = 0; i < N; i++) {
            findIdx += K - 1;
            int size = N - i;
            if(findIdx % size == 0) findIdx = size;
            else if (findIdx > size) findIdx %= size;
//            int num =
        }

    }

    static int init(int startIdx, int endIdx, int node) {
        if (startIdx == endIdx) {
            return tree[startIdx] = 1;
        }
        int mid = (startIdx + endIdx) / 2;
        return tree[node] = init(startIdx, mid, node * 2) + init(mid + 1, endIdx, node * 2 + 1);

    }

    static int query(int node, int start, int end, int findNum) {
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (findNum <= tree[2 * node]) {
            return query(2 * node, start, mid, findNum);
        }
        else{
            return query(2 * node + 1, mid + 1, end, findNum - tree[2 * node]);
        }
    }

//    static int update(int node, int start, int end, int del) {
//        tree[node]--;
//        if (start == end) {
//            return 0;
//        }
//        else{
//            int mid = (start + end) / 2;
//            if (del <= tree[node * 2]) {
//
//            }
//        }
//    }


}
