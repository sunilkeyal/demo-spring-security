create table hibernate_sequence (
    next_val bigint null
);

insert into hibernate_sequence (next_val) values (1);