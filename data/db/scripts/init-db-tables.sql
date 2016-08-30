/*
 * 
 * This is the mysql db initialization script.
 * 
 * $ mysql -u username -p < init-db.sql
 * 
 */

-- select database
use rvep;

-- role categories
insert into role_category (id, name, enabled) value (1000, 'app', 1);
insert into role_category (id, name, enabled) value (1100, 'event', 1);

-- app roles
insert into rvep_role (name, role_category_id, enabled) values ('ROLE_USER', 1000, 1);
insert into rvep_role (name, role_category_id, enabled) values ('ROLE_ANONYMOUS', 1000, 1);
insert into rvep_role (name, role_category_id, enabled) values ('ROLE_ADMIN', 1000, 1);

-- event roles
insert into rvep_role (name, role_category_id, enabled) values ('ROLE_CREATOR', 1100, 1);
insert into rvep_role (name, role_category_id, enabled) values ('ROLE_PLANNER', 1100, 1);
insert into rvep_role (name, role_category_id, enabled) values ('ROLE_TASKER', 1100, 1);
insert into rvep_role (name, role_category_id, enabled) values ('ROLE_ATTENDE', 1100, 1);
insert into rvep_role (name, role_category_id, enabled) values ('ROLE_BYSTANDER', 1100, 1);
