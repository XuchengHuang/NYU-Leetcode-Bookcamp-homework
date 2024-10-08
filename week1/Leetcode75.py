class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """

        zero_pointer, list_pointer, two_pointer = 0, 0, len(nums) - 1

        while list_pointer <= two_pointer:
            if nums[list_pointer] == 0:
                nums[zero_pointer], nums[list_pointer] = nums[list_pointer], nums[zero_pointer]
                zero_pointer = zero_pointer + 1
                list_pointer = list_pointer + 1
            elif nums[list_pointer] == 1:
                list_pointer = list_pointer + 1
            else:
                nums[list_pointer], nums[two_pointer] = nums[two_pointer], nums[list_pointer]
                two_pointer = two_pointer - 1

        return nums
