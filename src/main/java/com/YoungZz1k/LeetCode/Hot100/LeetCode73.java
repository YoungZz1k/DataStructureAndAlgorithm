package com.YoungZz1k.LeetCode.Hot100;

import java.util.Arrays;

/**
 * 矩阵置0
 */
public class LeetCode73 {
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(flag[i],false);
        }
        // 对数组进行遍历 记录为0的位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0){
                    // 碰到0  将该0的索引存入标记表
                    flag[i][j] = true;
                }
            }
        }

        // 对标记为true进行改值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if (flag[i][j]){
                    // 更新行
                    for (int k = 0; k < n; k++){
                        matrix[i][k] = 0;
                    }
                    // 更新列
                    for (int k = 0; k < m; k++){
                        matrix[k][j] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] array = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(array);
        System.out.println(Arrays.deepToString(array));
    }
}
