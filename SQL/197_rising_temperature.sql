WITH RankedWeather AS (
    SELECT id, recordDate, temperature,
           LAG(recordDate) OVER (ORDER BY recordDate) AS prev_date,
           LAG(temperature) OVER (ORDER BY recordDate) AS prev_temp
    FROM weather
)
SELECT id
FROM RankedWeather
WHERE prev_date = recordDate - INTERVAL 1 DAY  -- Ensure previous date is exactly one day before
AND temperature > prev_temp;  -- Compare temperature