import random
from typing import List


# https://leetcode-cn.com/problems/sort-an-array/solution/pai-xu-shu-zu-by-leetcode-solution/
class Solution:
    def partition(self, nums: List[int], l: int, r: int) -> int:
        """

        :param nums:
        :param l: 左边界指针
        :param r: 右边界指针
        """
        pivot = random.randint(l, r)
        nums[r], nums[pivot] = nums[pivot], nums[r]
        i = l - 1
        for j in range(l, r):
            if nums[j] < nums[r]:
                i += 1
                nums[i], nums[j] = nums[j], nums[i]
        i += 1
        nums[i], nums[r] = nums[r], nums[i]  # 这里记得要把枢纽换到这里
        return i

    def sort(self, nums: List[int], l: int, r: int) -> None:
        """

        :param nums:
        :param l: 左边界指针
        :param r: 右边界指针
        """
        if l >= r:
            return None
        mid = self.partition(nums, l, r)
        self.sort(nums, l, mid - 1)  # 这里记得是sort，不是partition
        self.sort(nums, mid + 1, r)

    def sortArray(self, nums: List[int]) -> List[int]:
        self.sort(nums, 0, len(nums) - 1)
        return nums


# if __name__ == '__main__':
import unittest


class TestSolution(unittest.TestCase):
    def test_solution(self):
        print(Solution().sortArray([5, 2, 3, 1]))
