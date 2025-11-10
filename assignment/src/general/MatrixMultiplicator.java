package assignment.src.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MatrixMultiplicator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] matrixStructure = br.readLine().split(" ");
        List<Integer[][]> matrices = new ArrayList<>();
        for(int i=0 ; i<n;i++){
            int horizon = Integer.parseInt(matrixStructure[i]);
            int vertical = Integer.parseInt(matrixStructure[i+1]);
            Integer[][] matrix = new Integer[horizon][vertical];
            for (int r=0;r<horizon;r++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int c=0;c<vertical;c++){
                    matrix[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            matrices.add(matrix);
            //행열 곱셈
        }
        Integer[][] ansMatrix = matrixMultiplication(matrices);
        for (int r=0;r<ansMatrix.length;r++){
            if(r!=0){
                System.out.println();
            }
            for(int c=0;c<ansMatrix[0].length;c++){
                System.out.print(ansMatrix[r][c]);
                System.out.print(" ");
            }
        }


    }

    public static Integer[][] matrixMultiplication(List<Integer[][]> matrices){
        //i번째와 i+1번째를 서로 행렬 곱셈하면서 곱하기
        Integer[][] oldMatrix = matrices.get(0);

        for (int i=1;i<matrices.size();i++){

            Integer[][] objMatrix = matrices.get(i);
            //새로운 매트릭스 만들기



            //행이랑 열이랑 각 곱하고 더해서
            // 새로운 매트릭스의 (r,c)에 넣기
            Integer[][] tmpMatrix = new Integer[oldMatrix.length][objMatrix[0].length];
            for (int r=0;r<oldMatrix.length;r++){
                for (int c=0; c<objMatrix[0].length;c++){
                    // 곱하고 더한 값
                    int eachResult = 0;
                    for (int e=0;e<oldMatrix[r].length;e++){
                        eachResult = eachResult + oldMatrix[r][e]*objMatrix[e][c];
                    }
                    tmpMatrix[r][c]=eachResult;
                }
            }
            oldMatrix = tmpMatrix;
        }
        return oldMatrix;

    }
}
