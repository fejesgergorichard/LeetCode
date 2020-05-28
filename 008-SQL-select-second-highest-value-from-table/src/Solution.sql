# Write your MySQL query statement below
# the last select in the text is the first in practice.
# the first selection is selecting the maximum amount from a table that does not contain the highest maximum value

SELECT MAX(Salary) SecondHighestSalary
FROM Employee
WHERE Salary NOT IN (SELECT MAX(Salary) FROM Employee)