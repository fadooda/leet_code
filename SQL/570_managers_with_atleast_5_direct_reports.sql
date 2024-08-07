# Write your MySQL query statement below
 with getemp as(
    select  e.managerId, count(*) as countManger
    from employee e
    group by  managerId
    having countManger>=5
 )
 select e.name 
 from employee e 
 inner join getemp ge on ge.managerId= e.id

