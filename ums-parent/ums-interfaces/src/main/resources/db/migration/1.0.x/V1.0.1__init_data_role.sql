INSERT INTO t_admin_role (id, admin_id, role_id)
VALUES ('1', '1', '1');
INSERT INTO t_admin_role (id, admin_id, role_id)
VALUES ('2', '1', '2');

INSERT INTO t_admin (id, create_time, update_time, name, age, gender, status, birthday, icon, username, password, mobile, email)
VALUES ('1', '2021-01-08 14:47:52', '2021-01-08 14:49:07', null, null, null, 1, null, null, 'admin', '$2a$10$xL/O7FotMed54uKC/XOGpurYSalY6PE2ZuX8chBdnML0TAgXZ6/Tq', null, null);

INSERT INTO t_role (id, create_time, update_time, name, description, sort)
VALUES ('1', '2021-01-08 14:13:57', '2021-01-08 14:13:57', 'ROOT', '超级管理员', 0);
INSERT INTO t_role (id, create_time, update_time, name, description, sort)
VALUES ('2', '2021-01-08 14:13:57', '2021-01-08 14:13:57', 'GUEST', '访客', 1);