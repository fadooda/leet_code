WITH cte AS (
    SELECT 
        a.player_id,
        a.event_date,
        -- Find the first event date for each player using a correlated subquery (slow!)
        (SELECT MIN(b.event_date) FROM Activity b WHERE b.player_id = a.player_id) AS first_event_date,
        -- Check if this login happened exactly one day after the first login
        CASE 
            WHEN DATEDIFF(a.event_date, 
                (SELECT MIN(b.event_date) FROM Activity b WHERE b.player_id = a.player_id)) = 1 
            THEN 1 
            ELSE 0 
        END AS userLoggedInNextDay
    FROM Activity a
)
SELECT 
    ROUND(SUM(userLoggedInNextDay) / COUNT(DISTINCT player_id), 2) AS fraction
FROM cte;
