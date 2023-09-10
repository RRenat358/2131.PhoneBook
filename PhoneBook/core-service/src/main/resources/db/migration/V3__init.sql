

DROP TABLE email;
DROP TABLE phone;
DROP TABLE clients;

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


-- //============================================================


