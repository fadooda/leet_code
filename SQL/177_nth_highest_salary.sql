CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
    SELECT e1.Salary
    FROM (SELECT DISTINCT Salary FROM Employee) e1
    WHERE (
        SELECT COUNT(1) FROM (SELECT DISTINCT Salary FROM Employee) e2 WHERE e2.Salary > e1.Salary
    ) = N - 1      
  );
END