update user set password = '$2a$10$EWoPj8Fu/ohCFEOEDk6pAOXMjVUd4fFdyhfpknSpqb6.wiNTEBi9.' where id = 1;

update user_role set roles = 'ROLE_ADMIN' where roles = 'ADMIN';
update user_role set roles = 'ROLE_USER' where roles = 'USER';