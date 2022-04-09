package leetcode503;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        var s = new Solution();
//        System.out.println(Arrays.stream(s.nextGreaterElements(new int[]{1,2,1})).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        System.out.println(Arrays.stream(s.nextGreaterElements(new int[]{5,4,3,2,1})).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }
}
