with cte as (
    select id, salary, dense_rank() over ( order by salary desc) as rn
    from employee
)
select 
(select cte.salary SecondHighestSalary from cte where cte.rn =2 limit 1) SecondHighestSalary