create table clients (
                         id uuid primary key,
                         name varchar(120) not null,
                         email varchar(180),
                         phone varchar(40),
                         created_at timestamptz not null,
                         updated_at timestamptz not null
);

create index idx_clients_name on clients (name);
