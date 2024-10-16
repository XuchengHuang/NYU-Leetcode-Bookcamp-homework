class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """

        p_count = {}
        window = {}

        for char in p:
            if char in p_count:
                p_count[char] += 1
            else:
                p_count[char] = 1

        right_pointer = 0
        left_pointer = 0
        index_table = []
        valid_num = 0

        while right_pointer < len(s):
            c = s[right_pointer]
            right_pointer = right_pointer + 1
            if c in p_count:
                if c in window:
                    window[c] += 1
                else:
                    window[c] = 1
            else:
                left_pointer = right_pointer
                window.clear()
                valid_num = 0
                continue

            if window[c] == p_count[c]:
                valid_num += 1
            elif window[c] > p_count[c]:
                c2 = s[left_pointer]
                while c2 != c:
                    left_pointer += 1
                    if c2 in window:
                        window[c2] -= 1
                        if (window[c2] + 1) == p_count[c2]:
                            valid_num -= 1
                    c2 = s[left_pointer]
                window[c] -= 1
                left_pointer += 1
            else:
                continue

            if valid_num == len(p_count):
                index_table.append(left_pointer)
                c3 = s[left_pointer]
                left_pointer += 1
                valid_num -= 1
                window[c3] -= 1

        return index_table