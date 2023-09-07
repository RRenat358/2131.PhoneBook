SELECT * FROM client;

SELECT * FROM public.email;


SELECT * FROM public.phone;



SELECT e.address
FROM email e
WHERE e.client_id = ?1;

SELECT e.address
FROM Email e
WHERE e.client_id = ?1;


SELECT *
FROM email e
WHERE e.client_id = ?1;

SELECT c.id
FROM client c
JOIN Email e ON e.address = 'some03@gmial.com'
GROUP BY e.client_id = c.id
-- HAVING e.client_id = c.id;



SELECT id
FROM Client
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
FROM Client c
JOIN Email e ON c.id = e.client_id;

/*
3,Oleg,2023-09-04 14:55:38.179120,2023-09-04 14:55:38.179120
2,Piter,2023-09-04 14:55:38.179120,2023-09-04 14:55:38.179120
2,Piter,2023-09-04 14:55:38.179120,2023-09-04 14:55:38.179120
*/


SELECT c.*
FROM Client c
JOIN Email e ON c.id = e.client_id
GROUP BY e.address, c.id, name, c.created_at, c.updated_at
HAVING e.address = 'some03@gmial.com';

--     column "c.id" must appear in the GROUP BY clause or be used in an aggregate function
--     Column address must be either aggregated, or mentioned in GROUP BY clause
--

SELECT c.*
FROM Client c
JOIN Email e ON c.id = e.client_id
WHERE e.address = 'some03@gmial.com';


SELECT c.name
FROM Client c
INNER JOIN Email e ON c.id = e.client_id
WHERE e.address = 'some03@gmial.com'
GROUP BY c.id;




SELECT *
FROM Email e
JOIN Phone p ON e.client_id = p.client_id
WHERE e.client_id = 2
;

SELECT e.address, p.number
FROM Email e
JOIN Phone p ON e.client_id = p.client_id
WHERE e.client_id = 2
;

SELECT p.number
FROM Email e
JOIN Phone p ON e.client_id = p.client_id
WHERE e.client_id = 2
GROUP BY p.number
;



SELECT *
FROM Client c
JOIN Phone p ON c.id = p.client_id
JOIN Email e ON c.id = e.client_id
WHERE c.id = 2
;

SELECT c.name, e.address, p.number
FROM Client c
JOIN Phone p ON c.id = p.client_id
JOIN Email e ON c.id = e.client_id
WHERE c.id = 2
;

SELECT e.address, p.number
FROM Client c
JOIN Phone p ON c.id = p.client_id
JOIN Email e ON c.id = e.client_id
WHERE c.id = 2
;


insert into email (client_id, address)
values
    (3,'some01@gmial.com'),
    (2,'some02@gmial.com'),
    (2,'some03@gmial.com');


UPDATE Email e
SET address = 'con1@g.com'
WHERE client_id = 2
;

INSERT INTO Email (client_id, address)
VALUES (2, 'con2@g.com');


DELETE FROM Email WHERE client_id = 22
;


DELETE FROM Client WHERE id = 2;








