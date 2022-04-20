from typing import List

# https://leetcode-cn.com/problems/course-schedule-ii/solution/ke-cheng-biao-ii-by-leetcode-solution/
class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        # 初始化图并添加哨兵
        graph = [[i] for i in range(numCourses)]

        # 添加建立先后关系
        # graph[i],记录i的前驱课程有哪一些
        for prerequisite in prerequisites:
            graph[prerequisite[0]].append(prerequisite[1])

        # 修读顺序
        sequence = []
        # 是否有新的课程修完
        isChange = True
        while len(graph) != 0 and isChange:
            isChange = False
            for node in graph:
                if len(node) == 1:
                    sequence.append(node[0])
                    graph.remove(node)
                    # 在别的依赖关系中删除这个节点
                    for toDelete in graph:
                        if sequence[-1] in toDelete:
                            toDelete.remove(sequence[-1])
                    isChange = True
                    break
        # 不能修完
        if not isChange:
            return []

        return sequence


if __name__ == '__main__':
    import unittest

    class TestMe(unittest.TestCase):
        def test_case1(self):
            Solution().findOrder(4, [[1, 0], [2, 0], [3, 1], [3, 2]])
