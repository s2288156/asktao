insert into t_role (id, create_time, update_time, name, description, sort)
values (1, now(), now(), 'ROOT', '超级管理员', 0),
       (2, now(), now(), 'GUEST', '访客', 1);
