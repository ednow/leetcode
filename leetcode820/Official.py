import collections
from functools import reduce
from typing import List


# https://leetcode-cn.com/problems/short-encoding-of-words/solution/dan-ci-de-ya-suo-bian-ma-by-leetcode-solution/
# 暴力删除
class Solution:
    def minimumLengthEncoding(self, words: List[str]) -> int:
        good = set(words)
        for word in words:
            for k in range(1, len(word)):
                good.discard(word[k:])

        return sum(len(word) + 1 for word in good)


# https://leetcode-cn.com/problems/short-encoding-of-words/solution/dan-ci-de-ya-suo-bian-ma-by-leetcode-solution/
class Solution2:
    def minimumLengthEncoding(self, words: List[str]) -> int:
        words = list(set(words))  # remove duplicates
        # Trie is a nested dictionary with nodes created
        # when fetched entries are missing
        Trie = lambda: collections.defaultdict(Trie)
        trie = Trie()
        # reduce(..., S, trie) is trie[S[0]][S[1]][S[2]][...][S[S.length - 1]]
        nodes = [reduce(dict.__getitem__, word[::-1], trie)
                 for word in words]

        # Add word to the answer if it's node has no neighbors
        return sum(len(word) + 1
                   for i, word in enumerate(words)
                   if len(nodes[i]) == 0)

import unittest
class Test(unittest.TestCase):
    def test_case1(self):
        Solution2().minimumLengthEncoding(["time", "me", "bell"])

# AttributeError: module 'Official' has no attribute 'Test'
# if __name__ == '__main__':
#     import unittest
#
#     class Test(unittest.TestCase):
#         def test_case1(self):
#             Solution2().minimumLengthEncoding(["time", "me", "bell"])