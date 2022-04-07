package leetcode84;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int min = Arrays.stream(heights).min().orElse(0);
        int index = Arrays.stream(heights).boxed().collect(Collectors.toList()).indexOf(min);
        return Math.max(
                min * heights.length,
                Math.max(
                        largestRectangleArea(Arrays.copyOfRange(heights, 0, index)),
                        largestRectangleArea(Arrays.copyOfRange(heights, index+1, heights.length))
                )
        );
    }
}
