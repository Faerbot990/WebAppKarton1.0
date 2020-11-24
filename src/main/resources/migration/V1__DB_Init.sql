create table goods (
    id bigint not null auto_increment,
    name varchar(255),
    category varchar(255),
    description varchar(255),
    primary key (id)
);

create table user (
    id bigint not null auto_increment,
    username varchar(255),
    password varchar(255),
    primary key (id)
);

create table user_role (
    user_id bigint not null,
    roles varchar(255)
);