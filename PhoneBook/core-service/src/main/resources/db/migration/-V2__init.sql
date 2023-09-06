
-- drop table clients_email;
-- drop table clients_phone;
-- drop table email;
-- drop table phone;
-- drop table clients;

-- //============================================================
create table clients (
    id                  bigserial primary key,
    name                varchar(255) not null,
    created_at          timestamp default current_timestamp,
    updated_at          timestamp default current_timestamp
                      );

insert into clients (
    name)
values
    ('Ivan'),
    ('Piter'),
    ('Oleg');

-- //============================================================
create table email (
    id                  bigserial primary key,
    client_id          bigint not null references clients (id),
    address             varchar(255) not null,
    created_at          timestamp default current_timestamp,
    updated_at          timestamp default current_timestamp
);

insert into email (client_id, address)
values
    (3,'some01@gmial.com'),
    (2,'some02@gmial.com'),
    (2,'some03@gmial.com');

-- //============================================================
create table phone (
    id                  bigserial primary key,
    client_id          bigint not null references clients (id),
    number              varchar(255) not null,
    created_at          timestamp default current_timestamp,
    updated_at          timestamp default current_timestamp
);

insert into phone (client_id, number)
values
    (2,'+79670670112'),
    (1,'+79670670113'),
    (1,'+79670670114');
/*
-- //============================================================
create table clients_email
(
    clients_id      bigint not null references clients (id),
    email_id        bigint not null references email (id),
    created_at      timestamp default current_timestamp,
    updated_at      timestamp default current_timestamp,
    primary key (clients_id, email_id)
);

insert into clients_email (clients_id, email_id)
values
    (1, 1),
    (2, 1),
    (3, 2);

-- //============================================================
create table clients_phone
(
    clients_id      bigint not null references clients (id),
    phone_id        bigint not null references phone (id),
    created_at      timestamp default current_timestamp,
    updated_at      timestamp default current_timestamp,
    primary key (clients_id, phone_id)
);

insert into clients_phone (clients_id, phone_id)
values
    (1, 1),
    (2, 1),
    (3, 2);

-- //============================================================
*/

