CREATE TABLE goods (
    id bigint not null auto_increment,
    name varchar(255),
    category varchar(255),
    description varchar(255),
    primary key (id)
);
CREATE TABLE categories (
    category_id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL
);

create table user (
    id bigint not null auto_increment,
    username varchar(255),
    password varchar(255),
    primary key (id)
);
create table cart (
id bigint not null auto_increment,
    name varchar(255),
    category varchar(255),
    description varchar(255),
    primary key (id)
)
create table user_role (
    user_id bigint not null,
    roles varchar(255)
);