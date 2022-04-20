# https://leetcode-cn.com/problems/implement-trie-prefix-tree/
import collections
from functools import reduce
class Trie:

    def __init__(self):
        # Tree = lambda: collections.defaultdict(Tree)
        # self.tree = Tree()
        pass
    def insert(self, word: str) -> None:
        # reduce(dict.__getitem__, word, self.tree)
        pass

    def search(self, word: str) -> bool:
        return True

    def startsWith(self, prefix: str) -> bool:
        return True