SELECT * FROM clients;



/*
select clients.name, p.number
from clients
join clients_phone cp on clients.id = cp.clients_id
join phone p on p.id = cp.phone_id;
*/

-- Hibernate:
select client0_.id as id1_0_, client0_.created_at as created_2_0_, client0_.name as name3_0_, client0_.updated_at as updated_4_0_ from clients client0_;
-- Hibernate:
select number0_.number as number3_2_0_, number0_.id as id1_2_0_, number0_.id as id1_2_1_, number0_.created_at as created_2_2_1_, number0_.number as number3_2_1_, number0_.updated_at as updated_4_2_1_ from phone number0_ where number0_.number

SELECT e.address
FROM email e
WHERE e.client_id = ?1;

SELECT e.address
FROM Email e
WHERE e.client_id = ?1;

SELECT e.address
FROM email e
WHERE e.client_id = ?1;

SELECT *
FROM email e
WHERE e.client_id = ?1;

SELECT c.id
FROM clients c
JOIN Email e ON e.address = 'some03@gmial.com'
GROUP BY e.client_id = c.id
-- HAVING e.client_id = c.id;




SELECT id
FROM Clients
WHERE 2 = (
    SELECT client_id
    FROM Email
    GROUP BY client_id
    )
GROUP BY id
;


SELECT client_id
FROM Email
GROUP BY client_id;


SELECT c.*
FROM Clients c
JOIN Email e ON c.id = e.client_id;

/*
3,Oleg,2023-09-04 14:55:38.179120,2023-09-04 14:55:38.179120
2,Piter,2023-09-04 14:55:38.179120,2023-09-04 14:55:38.179120
2,Piter,2023-09-04 14:55:38.179120,2023-09-04 14:55:38.179120
*/


SELECT c.*
FROM Clients c
JOIN Email e ON c.id = e.client_id
GROUP BY e.address, c.id, name, c.created_at, c.updated_at
HAVING e.address = 'some03@gmial.com';

--     column "c.id" must appear in the GROUP BY clause or be used in an aggregate function
--     Column address must be either aggregated, or mentioned in GROUP BY clause
--

SELECT c.*
FROM Clients c
INNER JOIN Email e ON c.id = e.client_id
WHERE e.address = 'some03@gmial.com';

SELECT c.*
FROM Clients c
JOIN Email e ON c.id = e.client_id
WHERE e.address = 'some03@gmial.com';


SELECT c.*
FROM Clients c
INNER JOIN Email e ON c.id = e.client_id
WHERE e.address = 'some03@gmial.com'
GROUP BY c.id;


SELECT c.name
FROM Clients c
INNER JOIN Email e ON c.id = e.client_id
WHERE e.address = 'some03@gmial.com'
GROUP BY c.id;



















