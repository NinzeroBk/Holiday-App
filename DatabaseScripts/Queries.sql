# Suma tuturor cheltuielilor ale unui utilizator
SELECT SUM(baseCost) + SUM(price)
FROM users
JOIN holidays USING(username)
JOIN visited USING(holidayId)
JOIN attractions USING(attractionId)
LEFT JOIN expenses USING(visitedId)
WHERE username = 'TestUser';

# Cea mai vizitata locatie pentru un utilizator
SELECT locations.*
FROM locations JOIN attractions USING(locationId)
JOIN visited USING(attractionId)
JOIN holidays USING(holidayId)
JOIN users USING(username)
WHERE username LIKE 'TestUser'
GROUP BY locationId
ORDER BY count(visitedId) DESC
LIMIT 1;
                    
# Cea mai lunga vacanta a unui utilizator
SELECT holidays.*
FROM users
JOIN holidays USING(username)
WHERE username LIKE 'TestUser'
GROUP BY holidayId
ORDER BY endDate - startDate DESC
LIMIT 1;

# Cea mai scumpa vacanta a unui utilizator
SELECT holidays.*, SUM(baseCost) + SUM(price) 
FROM users
JOIN holidays USING(username)
JOIN visited USING(holidayId)
JOIN attractions USING(attractionId)
LEFT JOIN expenses USING(visitedId)
WHERE username LIKE 'TestUser'
GROUP BY holidayId
ORDER BY SUM(baseCost) + SUM(price) DESC
LIMIT 1;