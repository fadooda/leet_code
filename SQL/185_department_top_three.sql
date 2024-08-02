with cte as (
    select *, dense_rank() over (partition by departmentId  order by salary desc) rn
    from Employee
)
select d.name as Department, cte.name as Employee, cte.salary from cte
left join Department d on d.id = cte.departmentId
where cte.rn<=3