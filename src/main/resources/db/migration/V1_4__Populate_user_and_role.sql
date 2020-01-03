insert into demo_role (id, name) values (1, 'USER');

-- password is 'password'
insert into demo_user (id, password, username) value (1, '{bcrypt}$2a$10$r0LiBc42xOqtvWXriWgmveXUbLHTCO4Z/kjo6hkMMhOBGOJtZgFVa', 'admin');

insert into demo_user_roles (user_id, roles_id) value (1, 1);
