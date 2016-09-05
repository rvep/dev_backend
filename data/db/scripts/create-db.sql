/*
 * 
 * This is the mysql db create script. 
 * Warning this script will drop the entire database.
 * Run using...
 * 
 * $ mysql -u username -p < create-db.sql
 * 
 * Warning: this will drop the existing database
 * 
 */

-- -----------------------------------------------------
-- Schema rvep
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `rvep` ;

-- -----------------------------------------------------
-- Schema rvep
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rvep` DEFAULT CHARACTER SET utf8 ;
USE `rvep` ;

CREATE TABLE hibernate_sequence
(
    next_val BIGINT(20)
);
CREATE TABLE rvep_user
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    created_on DATETIME NOT NULL,
    enabled TINYINT(1) DEFAULT '1' NOT NULL
);
CREATE TABLE rvep_user_profile
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    last_login DATETIME NOT NULL,
    rvep_user_id INT(10) unsigned NOT NULL,
    CONSTRAINT rvep_user_profile_rvep_user_id_fk FOREIGN KEY (rvep_user_id) REFERENCES rvep_user (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX rvep_user_profile_email_uindex ON rvep_user_profile (email);
CREATE INDEX rvep_user_profile_rvep_user_id_fk ON rvep_user_profile (rvep_user_id);
CREATE TABLE auth_provider
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    enabled TINYINT(1) DEFAULT '1' NOT NULL
);
CREATE TABLE rvep_user_auth_provider
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    auth_provider_id INT(10) unsigned NOT NULL,
    rvep_user_id INT(10) unsigned NOT NULL,
    CONSTRAINT rvep_user_auth_provider_auth_provider_id_fk FOREIGN KEY (auth_provider_id) REFERENCES auth_provider (id),
    CONSTRAINT rvep_user_auth_provider_rvep_user_id_fk FOREIGN KEY (rvep_user_id) REFERENCES rvep_user (id) ON DELETE CASCADE
);
CREATE INDEX rvep_user_auth_provider_auth_provider_id_fk ON rvep_user_auth_provider (auth_provider_id);
CREATE INDEX rvep_user_auth_provider_rvep_user_id_fk ON rvep_user_auth_provider (rvep_user_id);
CREATE TABLE role_category
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    enabled TINYINT(1) DEFAULT '1' NOT NULL
);
CREATE UNIQUE INDEX role_category_name_uindex ON role_category (name);
CREATE TABLE rvep_role
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    enabled TINYINT(1) DEFAULT '1' NOT NULL,
    role_category_id INT(10) unsigned NOT NULL,
    CONSTRAINT rvep_role_role_category_id_fk FOREIGN KEY (role_category_id) REFERENCES role_category (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX role_name_uindex ON rvep_role (name);
CREATE INDEX rvep_role_role_category_id_fk ON rvep_role (role_category_id);
CREATE TABLE rvep_event
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    created_on DATETIME NOT NULL,
    enabled TINYINT(1) DEFAULT '1' NOT NULL
);
CREATE TABLE rvep_user_role
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    rvep_role_id INT(10) unsigned NOT NULL,
    rvep_user_id INT(10) unsigned NOT NULL,
    CONSTRAINT rvep_user_role_rvep_role_id_fk FOREIGN KEY (rvep_role_id) REFERENCES rvep_role (id) ON DELETE CASCADE,
    CONSTRAINT rvep_user_role_rvep_user_rvep_user_id_fk FOREIGN KEY (rvep_user_id) REFERENCES rvep_user (id) ON DELETE CASCADE
);
CREATE INDEX rvep_user_role_rvep_role_id_fk ON rvep_user_role (rvep_role_id);
CREATE INDEX rvep_user_role_rvep_user_rvep_user_id_fk ON rvep_user_role (rvep_user_id);
CREATE TABLE rvep_user_event_role
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    rvep_role_id INT(10) unsigned NOT NULL,
    rvep_event_id INT(10) unsigned NOT NULL,
    rvep_user_id INT(10) unsigned NOT NULL,
    CONSTRAINT rvep_user_event_role_rvep_role_id_fk FOREIGN KEY (rvep_role_id) REFERENCES rvep_role (id) ON DELETE CASCADE,
    CONSTRAINT rvep_user_event_role_rvep_event_id_fk FOREIGN KEY (rvep_event_id) REFERENCES rvep_event (id) ON DELETE CASCADE,
    CONSTRAINT rvep_user_event_role_rvep_user_id_fk FOREIGN KEY (rvep_user_id) REFERENCES rvep_user (id) ON DELETE CASCADE
);
CREATE INDEX rvep_user_event_role_rvep_role_id_fk ON rvep_user_event_role (rvep_role_id);
CREATE INDEX rvep_user_event_role_rvep_event_id_fk ON rvep_user_event_role (rvep_event_id);
CREATE INDEX rvep_user_event_role_rvep_user_id_fk ON rvep_user_event_role (rvep_user_id);
CREATE TABLE rvep_user_contact
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    rvep_user_id INT(10) unsigned NOT NULL,
    rvep_user_profile_id INT(10) unsigned NOT NULL,
    CONSTRAINT rvep_user_contact_rvep_user_id_fk FOREIGN KEY (rvep_user_id) REFERENCES rvep_user (id) ON DELETE CASCADE,
    CONSTRAINT rvep_user_contact_rvep_user_profile_id_fk FOREIGN KEY (rvep_user_profile_id) REFERENCES rvep_user_profile (id) ON DELETE CASCADE
);
CREATE INDEX rvep_user_contact_rvep_user_id_fk ON rvep_user_contact (rvep_user_id);
CREATE INDEX rvep_user_contact_rvep_user_profile_id_fk ON rvep_user_contact (rvep_user_profile_id);
CREATE TABLE rolling_vote
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    value INT(10) unsigned DEFAULT '0' NOT NULL,
    created_on DATETIME NOT NULL,
    updated_on DATETIME NOT NULL,
    enabled TINYINT(1) DEFAULT '1' NOT NULL
);
CREATE TABLE rvep_user_event_rolling_vote
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    rolling_vote_id INT(10) unsigned NOT NULL,
    rvep_event_id INT(10) unsigned NOT NULL,
    rvep_user_id INT(10) unsigned NOT NULL,
    CONSTRAINT rvep_user_event_rolling_vote_rolling_vote_id_fk FOREIGN KEY (rolling_vote_id) REFERENCES rolling_vote (id) ON DELETE CASCADE,
    CONSTRAINT rvep_user_event_rolling_vote_rvep_event_id_fk FOREIGN KEY (rvep_event_id) REFERENCES rvep_event (id) ON DELETE CASCADE,
    CONSTRAINT rvep_user_event_rolling_vote_rvep_user_id_fk FOREIGN KEY (rvep_user_id) REFERENCES rvep_user (id) ON DELETE CASCADE
);
CREATE INDEX rvep_user_event_rolling_vote_rolling_vote_id_fk ON rvep_user_event_rolling_vote (rolling_vote_id);
CREATE INDEX rvep_user_event_rolling_vote_rvep_event_id_fk ON rvep_user_event_rolling_vote (rvep_event_id);
CREATE INDEX rvep_user_event_rolling_vote_rvep_user_id_fk ON rvep_user_event_rolling_vote (rvep_user_id);
CREATE TABLE suggestion
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    accepted TINYINT(1),
    created_on DATETIME NOT NULL,
    updated_on DATETIME NOT NULL
);
CREATE TABLE rvep_event_suggestion
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    rvep_event_id INT(10) unsigned NOT NULL,
    suggestion_id INT(10) unsigned NOT NULL,
    CONSTRAINT rvep_event_suggestion_rvep_event_id_fk FOREIGN KEY (rvep_event_id) REFERENCES rvep_event (id) ON DELETE CASCADE,
    CONSTRAINT rvep_event_suggestion_suggestion_id_fk FOREIGN KEY (suggestion_id) REFERENCES suggestion (id) ON DELETE CASCADE
);
CREATE INDEX rvep_event_suggestion_rvep_event_id_fk ON rvep_event_suggestion (rvep_event_id);
CREATE INDEX rvep_event_suggestion_suggestion_id_fk ON rvep_event_suggestion (suggestion_id);
CREATE TABLE invite
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    accepted TINYINT(1) DEFAULT '0' NOT NULL,
    created_on DATETIME NOT NULL,
    enabled TINYINT(1) DEFAULT '1' NOT NULL
);
CREATE TABLE rvep_event_invite
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    invite_id INT(10) unsigned NOT NULL,
    rvep_event_id INT(10) unsigned NOT NULL,
    rvep_user_id INT(10) unsigned NOT NULL,
    rvep_user_profile_id INT(10) unsigned NOT NULL,
    CONSTRAINT rvep_event_invite_invite_id_fk FOREIGN KEY (invite_id) REFERENCES invite (id) ON DELETE CASCADE,
    CONSTRAINT rvep_event_invite_rvep_event_id_fk FOREIGN KEY (rvep_event_id) REFERENCES rvep_event (id) ON DELETE CASCADE,
    CONSTRAINT rvep_event_invite_rvep_user_id_fk FOREIGN KEY (rvep_user_id) REFERENCES rvep_user (id),
    CONSTRAINT rvep_event_invite_rvep_user_profile_id_fk FOREIGN KEY (rvep_user_profile_id) REFERENCES rvep_user_profile (id) ON DELETE CASCADE
);
CREATE INDEX rvep_event_invite_invite_id_fk ON rvep_event_invite (invite_id);
CREATE INDEX rvep_event_invite_rvep_event_id_fk ON rvep_event_invite (rvep_event_id);
CREATE INDEX rvep_event_invite_rvep_user_id_fk ON rvep_event_invite (rvep_user_id);
CREATE INDEX rvep_event_invite_rvep_user_profile_id_fk ON rvep_event_invite (rvep_user_profile_id);
CREATE TABLE rvep_user_contact_invite
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    invite_id INT(10) unsigned NOT NULL,
    rvep_user_id INT(10) unsigned NOT NULL,
    rvep_user_profile_id INT(10) unsigned NOT NULL,
    CONSTRAINT rvep_user_contact_invite_rvep_user_id_fk FOREIGN KEY (rvep_user_id) REFERENCES rvep_user (id) ON DELETE CASCADE,
    CONSTRAINT rvep_user_contact_invite_rvep_user_profile_id_fk FOREIGN KEY (rvep_user_profile_id) REFERENCES rvep_user_profile (id) ON DELETE CASCADE
);
CREATE INDEX rvep_user_contact_invite_rvep_user_id_fk ON rvep_user_contact_invite (rvep_user_id);
CREATE INDEX rvep_user_contact_invite_rvep_user_profile_id_fk ON rvep_user_contact_invite (rvep_user_profile_id);
CREATE TABLE rvep_location
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    geolat FLOAT,
    geolng FLOAT,
    egnabled TINYINT(1) DEFAULT '1' NOT NULL
);
CREATE TABLE rvep_event_item
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    date_time DATETIME NOT NULL,
    created_on DATETIME NOT NULL,
    updated_on DATETIME NOT NULL,
    enabled TINYINT(1) DEFAULT '1' NOT NULL,
    rvep_event_id INT(10) unsigned NOT NULL,
    rvep_location_id INT(10) unsigned NOT NULL,
    CONSTRAINT rvep_event_item_rvep_event_id_fk FOREIGN KEY (rvep_event_id) REFERENCES rvep_event (id),
    CONSTRAINT rvep_event_item_rvep_location_id_fk FOREIGN KEY (rvep_location_id) REFERENCES rvep_location (id)
);
CREATE INDEX rvep_event_item_rvep_event_id_fk ON rvep_event_item (rvep_event_id);
CREATE INDEX rvep_event_item_rvep_location_id_fk ON rvep_event_item (rvep_location_id);
CREATE TABLE rvep_event_profile
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    created_on DATETIME NOT NULL,
    updated_on DATETIME NOT NULL,
    enabled TINYINT(1) DEFAULT '1' NOT NULL,
    rvep_event_id INT(10) unsigned NOT NULL,
    CONSTRAINT rvep_event_profile_rvep_event_id_fk FOREIGN KEY (rvep_event_id) REFERENCES rvep_event (id) ON DELETE CASCADE
);
CREATE INDEX rvep_event_profile_rvep_event_id_fk ON rvep_event_profile (rvep_event_id);
CREATE TABLE todo_list
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    created_on DATETIME NOT NULL,
    updated_on DATETIME NOT NULL,
    enabled TINYINT(1) DEFAULT '1' NOT NULL
);
CREATE TABLE todo_list_item
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    complete TINYINT(1) DEFAULT '0' NOT NULL,
    created_on DATETIME NOT NULL,
    updated_on DATETIME NOT NULL,
    enabled TINYINT(1) DEFAULT '1' NOT NULL,
    todo_list_id INT(10) unsigned NOT NULL,
    CONSTRAINT todo_list_item_todo_list_id_fk FOREIGN KEY (todo_list_id) REFERENCES todo_list (id) ON DELETE CASCADE
);
CREATE INDEX todo_list_item_todo_list_id_fk ON todo_list_item (todo_list_id);
CREATE TABLE rvep_event_todo_list
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    rvep_event_id INT(10) unsigned,
    rvep_user_id INT(10) unsigned NOT NULL,
    todo_list_id INT(10) unsigned NOT NULL,
    CONSTRAINT rvep_event_todo_list_rvep_event_id_fk FOREIGN KEY (rvep_event_id) REFERENCES rvep_event (id),
    CONSTRAINT rvep_event_todo_list_rvep_user_id_fk FOREIGN KEY (rvep_user_id) REFERENCES rvep_user (id),
    CONSTRAINT rvep_event_todo_list_todo_list_id_fk FOREIGN KEY (todo_list_id) REFERENCES todo_list (id)
);
CREATE INDEX rvep_event_todo_list_rvep_event_id_fk ON rvep_event_todo_list (rvep_event_id);
CREATE INDEX rvep_event_todo_list_rvep_user_id_fk ON rvep_event_todo_list (rvep_user_id);
CREATE INDEX rvep_event_todo_list_todo_list_id_fk ON rvep_event_todo_list (todo_list_id);
CREATE TABLE rvep_event_item_todo_list
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    rvep_event_id INT(10) unsigned NOT NULL,
    rvep_event_item_id INT(10) unsigned NOT NULL,
    todo_list_id INT(10) unsigned NOT NULL,
    CONSTRAINT rvep_event_item_todo_list_rvep_event_id_fk FOREIGN KEY (rvep_event_id) REFERENCES rvep_event (id),
    CONSTRAINT rvep_event_item_todo_list_rvep_event_item_id_fk FOREIGN KEY (rvep_event_item_id) REFERENCES rvep_event_item (id),
    CONSTRAINT rvep_event_item_todo_list_id_fk FOREIGN KEY (todo_list_id) REFERENCES todo_list (id)
);
CREATE INDEX rvep_event_item_todo_list_id_fk ON rvep_event_item_todo_list (todo_list_id);
CREATE INDEX rvep_event_item_todo_list_rvep_event_id_fk ON rvep_event_item_todo_list (rvep_event_id);
CREATE INDEX rvep_event_item_todo_list_rvep_event_item_id_fk ON rvep_event_item_todo_list (rvep_event_item_id);
CREATE TABLE todo_list_item_assignment
(
    id INT(10) unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
    rvep_user_id INT(10) unsigned NOT NULL,
    rvep_user_profile_id INT(10) unsigned NOT NULL,
    todo_list_item_id INT(10) unsigned NOT NULL,
    CONSTRAINT todo_list_item_assignment_rvep_user_id_fk FOREIGN KEY (rvep_user_id) REFERENCES rvep_user (id) ON DELETE CASCADE,
    CONSTRAINT todo_list_item_assignment_rvep_user_profile_id_fk FOREIGN KEY (rvep_user_profile_id) REFERENCES rvep_user_profile (id) ON DELETE CASCADE,
    CONSTRAINT todo_list_item_assignment_todo_list_item_id_fk FOREIGN KEY (todo_list_item_id) REFERENCES todo_list_item (id) ON DELETE CASCADE
);
CREATE INDEX todo_list_item_assignment_rvep_user_id_fk ON todo_list_item_assignment (rvep_user_id);
CREATE INDEX todo_list_item_assignment_rvep_user_profile_id_fk ON todo_list_item_assignment (rvep_user_profile_id);
CREATE INDEX todo_list_item_assignment_todo_list_item_id_fk ON todo_list_item_assignment (todo_list_item_id);