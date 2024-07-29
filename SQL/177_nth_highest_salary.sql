CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
    select cte.salary 
    from (
        select salary,
        dense_rank() over (order by salary desc) as rn
        from Employee
    ) cte
    where cte.rn = N
    limit 1
  );
END