class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        prefix_table = []
        suffix_table = []
        prefix_product = 1
        suffix_product = 1

        for i in nums:
            prefix_product = prefix_product * i
            prefix_table.append(prefix_product)

        for j in reversed(nums):
            suffix_product = suffix_product * j
            suffix_table.insert(0, suffix_product)

        res = [suffix_table[1]]
        for k in range(1, len(nums) - 1):
            res.append(prefix_table[k - 1] * suffix_table[k + 1])

        res.append(prefix_table[-2])
        return res