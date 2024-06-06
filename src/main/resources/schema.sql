create table if not exists vehicle
(
    id   uuid,
    type varchar(100),
    primary key (id)
);

create table if not exists parking_spot
(
    id         uuid,
    type       varchar(100),
    vehicle_id uuid references vehicle (id),
    primary key (id)
);