INSERT INTO t_admin_role (id, admin_id, role_id)
VALUES ('1', '1', '1');
INSERT INTO t_admin_role (id, admin_id, role_id)
VALUES ('2', '1', '2');

INSERT INTO t_admin (id, create_time, update_time, name, age, gender, status, birthday, icon, username, password, mobile, email)
VALUES ('1', now(), now(), null, null, null, 1, null, 'https://wcy-img.oss-cn-beijing.aliyuncs.com/images/avatar/default_avatar.jpg', 'admin', '$2a$10$xL/O7FotMed54uKC/XOGpurYSalY6PE2ZuX8chBdnML0TAgXZ6/Tq', null, null);

INSERT INTO t_role (id, create_time, update_time, name, description, sort)
VALUES ('1', now(), now(), 'ROOT', '超级管理员', 0);
INSERT INTO t_role (id, create_time, update_time, name, description, sort)
VALUES ('2', now(), now(), 'GUEST', '访客', 1);