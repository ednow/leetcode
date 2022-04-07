package leetcode240;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66140/My-concise-O(m%2Bn)-Java-solution
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false, isFind = false;
        int col = 0, row = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    row = i;
                    col = j;
                    isFind = true;
                    break;
                }
            }
            if (isFind) {
                break;
            }
        }
        // 找不到是false
        // [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
        // 20
        if (!isFind) {
            return false;
        }
        // 列
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            list.add(matrix[i][col]);
        }
        return list.equals(list.stream().sorted().collect(Collectors.toList())) &&
                Arrays.equals(matrix[row], Arrays.stream(matrix[row]).sorted().toArray());
    }
}
