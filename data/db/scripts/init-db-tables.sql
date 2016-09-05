/*
 * 
 * This is the mysql db initialization script.
 * 
 * $ mysql -u username -p < init-db.sql
 * 
 */

-- select database
use rvep;

-- rvep_ categories
insert into role_category (id, name, enabled) value (1000, 'app', 1);
insert into role_category (id, name, enabled) value (1100, 'event', 1);

-- app rvep_s
insert into rvep_role (name, enabled, role_category_id) values ('ROLE_USER', 1, 1000);
insert into rvep_role (name, enabled, role_category_id) values ('ROLE_ANONYMOUS', 1, 1000);
insert into rvep_role (name, enabled, role_category_id) values ('ROLE_ADMIN', 1, 1000);

-- event rvep_s
insert into rvep_role (name, enabled, role_category_id) values ('ROLE_CREATOR', 1, 1100);
insert into rvep_role (name, enabled, role_category_id) values ('ROLE_PLANNER', 1, 1100);
insert into rvep_role (name, enabled, role_category_id) values ('ROLE_TASKER', 1, 1100);
insert into rvep_role (name, enabled, role_category_id) values ('ROLE_ATTENDE', 1, 1100);
insert into rvep_role (name, enabled, role_category_id) values ('ROLE_BYSTANDER', 1, 1100);

-- auth providers
insert into auth_provider (name, enabled) values ('google', 1);
insert into auth_provider (name, enabled) values ('twitter', 1);
insert into auth_provider (name, enabled) values ('facebook', 1);
