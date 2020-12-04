create table orders (
    id int8 generated by default as identity,
    date date,
    email varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    phone_number varchar(255),
    total_price float8,
    user_id int8,
    primary key (id)
);
create table orders_product_list (
    order_id int8 not null,
    product_list_id int8 not null,
    product_list_order int4 not null,
    primary key (order_id, product_list_order)
);
create table product (
    id int8 not null,
    description varchar(255),
    filename varchar(255),
    product_category varchar(255),
    product_name varchar(255),
    price int4 not null,
    quantity varchar(255),
    primary key (id)
);
create table user_role (
    user_id int8 not null,
    roles varchar(255)
);
create table usr (
    id int8 not null,
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id)
);
create table user_product_list (
    user_id int8 not null,
    product_list_id int8 not null
);
create table news (
    id int8 not null,
    description varchar(255),
    filename varchar(255),
    title varchar (255),
    primary key (id)
);

alter table if exists orders
    add constraint FK7ncuqw9n77odylknbo8aikc9w
    foreign key (user_id) references usr;

alter table if exists orders_product_list
    add constraint FKi6hpa14qaenek8pc9pf3vmlei
    foreign key (product_list_id) references product;

alter table if exists orders_product_list
    add constraint FK8jft4d30d5dgvauht7ssndwau
    foreign key (order_id) references orders;

alter table if exists user_role
    add constraint FKfpm8swft53ulq2hl11yplpr5
    foreign key (user_id) references usr;

alter table if exists user_product_list
    add constraint FK1n7n8prjoexkp1twc9f6kgbtm
    foreign key (product_list_id) references product;

alter table if exists user_product_list
    add constraint FKc5b4lo20noteewtlrq1kd8nhs
    foreign key (user_id) references usr;