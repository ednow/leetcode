package leetcode509;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> cache = new HashMap<>();
    {
        cache.put(0, 0);
        cache.put(1, 1);
    }
    public int fib(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        return fib(n - 1) + fib(n - 2);
    }
}
