package leetcode127;

import java.util.Arrays;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
//        System.out.println(
//                new Solution().ladderLength("hit", "cog", Arrays.stream(new String[]{"hot","dot","dog","lot","log","cog"}).toList())
//        );
        System.out.println(
                new Solution().ladderLength("a", "c", Arrays.stream(new String[]{"a","b","c"}).toList())
        );
    }
}
