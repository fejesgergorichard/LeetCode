# Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where indices[i] = [ri, ci].
# For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.
# Return the number of cells with odd values in the matrix after applying the increment to all indices.
# # # # # # # # # #
# Example 1:
# Input: n = 2, m = 3, indices = [[0,1],[1,1]]
# Output: 6
# Explanation: Initial matrix = [[0,0,0],[0,0,0]].
# After applying first increment it becomes [[1,2,1],[0,1,0]].
# The final matrix will be [[1,3,1],[1,3,1]] which contains 6 odd numbers.
# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #

class Solution:
    def oddCells(self, n: int, m: int, indices: List[List[int]]) -> int:
        # List comprehension for initializing a matrix of zeros
        matrix = [[0 for col in range(m)] for row in range(n)]
        odds = 0
        for entry in indices:
            ri = entry[0]
            ci = entry[1]
            # m is number of columns
            for i in range(m):
                matrix[ri][i] += 1
            # n is number of rows
            for i in range(n):
                matrix[i][ci] += 1

        # count all the odd numbers in the matrix
        for row in matrix:
            for entry in row:
                if entry % 2 != 0:
                    odds += 1
        return odds