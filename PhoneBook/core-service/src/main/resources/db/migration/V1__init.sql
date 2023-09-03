
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
    address             varchar(255) not null,
    created_at          timestamp default current_timestamp,
    updated_at          timestamp default current_timestamp
);

insert into email (
    address)
values
    ('some01@gmial.com'),
    ('some02@gmial.com'),
    ('some03@gmial.com');

-- //============================================================
create table phone (
    id                  bigserial primary key,
    number              varchar(255) not null,
    created_at          timestamp default current_timestamp,
    updated_at          timestamp default current_timestamp
);

insert into phone (
    number)
values
    ('+79670670112'),
    ('+79670670113'),
    ('+79670670114');

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


