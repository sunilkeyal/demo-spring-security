insert into demo_role (id, name) values (1, 'USER');

insert into demo_user (id, password, username) values (1, '{bcrypt}$2a$10$r0LiBc42xOqtvWXriWgmveXUbLHTCO4Z/kjo6hkMMhOBGOJtZgFVa', 'admin');

insert into demo_user_roles (user_id, roles_id) values (1, 1);
