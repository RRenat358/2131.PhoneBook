select * from clients;



select clients.name, p.number
from clients
join clients_phone cp on clients.id = cp.clients_id
join phone p on p.id = cp.phone_id;

-- Hibernate:
select client0_.id as id1_0_, client0_.created_at as created_2_0_, client0_.name as name3_0_, client0_.updated_at as updated_4_0_ from clients client0_;
-- Hibernate:
select number0_.number as number3_2_0_, number0_.id as id1_2_0_, number0_.id as id1_2_1_, number0_.created_at as created_2_2_1_, number0_.number as number3_2_1_, number0_.updated_at as updated_4_2_1_ from phone number0_ where number0_.number








