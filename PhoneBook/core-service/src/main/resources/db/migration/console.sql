select * from clients;



select clients.name, p.number
from clients
join clients_phone cp on clients.id = cp.clients_id
join phone p on p.id = cp.phone_id;











