class Solution(object):
    def myAtoi(self, s):
        """
        :type s: str
        :rtype: int
        """
        s = s.lstrip()
        if not s:
            return 0

        sign = 1
        start_index = 0
        if s[0] == '-':
            sign = -1
            start_index = 1
        elif s[0] == '+':
            start_index = 1
        result = 0
        for i in range(start_index, len(s)):
            if not s[i].isdigit():
                break
            result = result * 10 + int(s[i])

        result *= sign

        max = 2**31 - 1
        min = -2**31
        if result < min:
            return min
        if result > max:
            return max

        return result