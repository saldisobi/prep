package leetcode.explore;

import java.util.HashSet;
import java.util.Set;

public class MatrixZeroesInPlace {

    public void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();

        Set<Integer> columnSet = new HashSet<>();

        for(int i = 0;i<matrix.length;i++){
            for(int j  = 0 ;j< matrix[i].length;j++){
                if(matrix[i][j] == 0){
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }

        for(int i = 0;i<matrix.length;i++){
            for(int j  = 0 ;j< matrix[i].length;j++){
               if(rowSet.contains(i)||columnSet.contains(j)){
                   matrix[i][j] = 0;
               }
            }
        }

    }
}
