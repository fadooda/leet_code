WITH cte AS (
    SELECT 
        a.player_id,
        a.event_date,
        -- Check if this login happened exactly one day after the first login
        CASE 
            WHEN DATEDIFF(a.event_date, 
                FIRST_VALUE(a.event_date) OVER (PARTITION BY a.player_id ORDER BY a.event_date)) = 1 
            THEN 1 
            ELSE 0 
        END AS userLoggedInNextDay
    FROM Activity a
)
SELECT 
    ROUND(SUM(userLoggedInNextDay) / COUNT(DISTINCT player_id), 2) AS fraction
FROM cte;
