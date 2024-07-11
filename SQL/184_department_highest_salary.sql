# Write your MySQL query statement below
/* cte below dense (keeping ties) ranks all salaries decending order and partitioned(grouped by) emp.departmentId*/
 with cte as (
    select emp.departmentId , emp.Name, emp.Salary,
dense_rank() over (partition by emp.departmentId order by emp.salary desc) as rn
from Employee emp
 )
 select dep.Name as "Department",  cte.Name as "Employee", cte.Salary
from cte
inner join Department dep
on cte.departmentId = dep.id
where cte.rn=1 /* selects all ranks that are top salary in the department */

