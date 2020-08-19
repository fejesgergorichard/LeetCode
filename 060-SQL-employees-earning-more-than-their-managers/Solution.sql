# The Employee table holds all employees including their managers. 
# Every employee has an Id, and there is also a column # for the manager Id.
# 
# +----+-------+--------+-----------+
# | Id | Name  | Salary | ManagerId |
# +----+-------+--------+-----------+
# | 1  | Joe   | 70000  | 3         |
# | 2  | Henry | 80000  | 4         |
# | 3  | Sam   | 60000  | NULL      |
# | 4  | Max   | 90000  | NULL      |
# +----+-------+--------+-----------+
# Given the Employee table, write a SQL query that finds out employees who earn more than their managers. 
# For the above # table, Joe is the only employee who earns more than his manager.
# 
# +----------+
# | Employee |
# +----------+
# | Joe      |
# +----------+
# # # # # # # # # # # # # # # # # # # # # # # # 
# Write your MySQL query statement below

SELECT Employee.Name AS 'Employee'      # We only need the name in an Employee column
FROM 
    Employee AS Employee,               # We select the names twice: once as an Employee table
    Employee AS Manager                 # and once as a Manager table
WHERE
    Employee.ManagerId = Manager.Id     # We check that the manager's ID is equal to the employee's manager's id
   AND
    Employee.Salary > Manager.Salary    # And we check that the employee's salary is greater than the manager's