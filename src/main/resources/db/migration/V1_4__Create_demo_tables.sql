create table demo_customer (
    id         int          not null primary key,
    email      varchar(255) null,
    first_name varchar(20)  not null,
    last_name  varchar(20)  null,
    phone      varchar(255) null,
    status     varchar(20)  null
);

create table demo_role (
    id   bigint       not null primary key,
    name varchar(255) null
);

create table demo_user (
    id       int          not null primary key,
    password varchar(255) null,
    username varchar(255) null
);

create table demo_user_roles (
    user_id  int    not null,
    roles_id bigint not null,
    constraint UK_172eobe6juyh2bwe8u8n7t2qt unique (roles_id),
    constraint FKitt3obmd8608gu1kwoo9qd5gs foreign key (roles_id) references demo_role (id),
    constraint FKkrvnd9yrt3jcp1qcavk9imqo5 foreign key (user_id) references demo_user (id)
);

