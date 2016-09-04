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

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema rvep
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `rvep` ;

-- -----------------------------------------------------
-- Schema rvep
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rvep` DEFAULT CHARACTER SET utf8 ;
USE `rvep` ;

CREATE TABLE event_item_task
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    created_on DATETIME,
    enabled TINYINT(4) NOT NULL,
    status TINYINT(4) NOT NULL,
    updated_on VARCHAR(255),
    rvep_user_id INT(11),
    CONSTRAINT FKnosokfxq1to767nk01u0ivis1 FOREIGN KEY (rvep_user_id) REFERENCES rvep_user (id)
);
CREATE INDEX FKnosokfxq1to767nk01u0ivis1 ON event_item_task (rvep_user_id);
CREATE TABLE event_profile
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    description VARCHAR(255),
    hash_id VARCHAR(255),
    is_open_enrollment TINYINT(4),
    is_public TINYINT(4),
    person_limit INT(11),
    picture TINYBLOB,
    title VARCHAR(255),
    updated_on DATETIME,
    rvep_event_id INT(11),
    CONSTRAINT FK87unl3krwlecoikwilugb2v8t FOREIGN KEY (rvep_event_id) REFERENCES rvep_event (id)
);
CREATE INDEX FK87unl3krwlecoikwilugb2v8t ON event_profile (rvep_event_id);
CREATE TABLE hibernate_sequence
(
    next_val BIGINT(20)
);
CREATE TABLE invite
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    accepted TINYINT(4) NOT NULL,
    created_on DATETIME,
    enabled TINYINT(4) NOT NULL,
    updated_on DATETIME
);
CREATE TABLE role_category
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    enabled TINYINT(4) NOT NULL,
    name VARCHAR(255)
);
CREATE TABLE rolling_vote
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    created_on DATETIME,
    enabled TINYINT(4) NOT NULL,
    updated_on DATETIME,
    value TINYINT(4) NOT NULL,
    rvep_user_id INT(11),
    CONSTRAINT FKp69mwff2yky2phl51soslajme FOREIGN KEY (rvep_user_id) REFERENCES rvep_user (id)
);
CREATE INDEX FKp69mwff2yky2phl51soslajme ON rolling_vote (rvep_user_id);
CREATE TABLE rolling_vote_rvep_event
(
    rolling_vote_id INT(11) NOT NULL,
    rvep_event_id INT(11) NOT NULL,
    CONSTRAINT FKk06jtf6y3sjtwdtjitikntob8 FOREIGN KEY (rolling_vote_id) REFERENCES rolling_vote (id),
    CONSTRAINT FKi3vj4ysyndyypw1t720ssqe3a FOREIGN KEY (rvep_event_id) REFERENCES rvep_event (id)
);
CREATE INDEX FKi3vj4ysyndyypw1t720ssqe3a ON rolling_vote_rvep_event (rvep_event_id);
CREATE INDEX FKk06jtf6y3sjtwdtjitikntob8 ON rolling_vote_rvep_event (rolling_vote_id);
CREATE TABLE rolling_vote_rvep_event_item
(
    rolling_vote_id INT(11) NOT NULL,
    rvep_event_item_id INT(11) NOT NULL,
    CONSTRAINT FKb0ft56onherq8evf67rr448ri FOREIGN KEY (rolling_vote_id) REFERENCES rolling_vote (id),
    CONSTRAINT FKs06h4cx1lwek56ycnyg89uqnn FOREIGN KEY (rvep_event_item_id) REFERENCES rvep_event_item (id)
);
CREATE INDEX FKb0ft56onherq8evf67rr448ri ON rolling_vote_rvep_event_item (rolling_vote_id);
CREATE INDEX FKs06h4cx1lwek56ycnyg89uqnn ON rolling_vote_rvep_event_item (rvep_event_item_id);
CREATE TABLE rolling_vote_suggestion
(
    rolling_vote_id INT(11) NOT NULL,
    suggestion_id INT(11) NOT NULL,
    CONSTRAINT FKgw00kbu7rsmgq8ys9d67eetw7 FOREIGN KEY (rolling_vote_id) REFERENCES rolling_vote (id),
    CONSTRAINT FKs3thot4cw39nrlcmqmix7j88o FOREIGN KEY (suggestion_id) REFERENCES suggestion (id)
);
CREATE INDEX FKgw00kbu7rsmgq8ys9d67eetw7 ON rolling_vote_suggestion (rolling_vote_id);
CREATE INDEX FKs3thot4cw39nrlcmqmix7j88o ON rolling_vote_suggestion (suggestion_id);
CREATE TABLE rvep_event
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    created_on DATETIME,
    enabled TINYINT(4) NOT NULL
);
CREATE TABLE rvep_event_invite
(
    rvep_event_id INT(11) NOT NULL,
    invite_id INT(11) NOT NULL,
    CONSTRAINT FKab1twaqvioe6p5mlm1kcbwvw3 FOREIGN KEY (rvep_event_id) REFERENCES rvep_event (id),
    CONSTRAINT FK9r3m44bcl5h7ogympktc17gs5 FOREIGN KEY (invite_id) REFERENCES invite (id)
);
CREATE INDEX FK9r3m44bcl5h7ogympktc17gs5 ON rvep_event_invite (invite_id);
CREATE INDEX FKab1twaqvioe6p5mlm1kcbwvw3 ON rvep_event_invite (rvep_event_id);
CREATE TABLE rvep_event_item
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    created_on DATETIME,
    date_time DATETIME,
    description VARCHAR(255),
    enabled TINYINT(4) NOT NULL,
    title VARCHAR(255),
    updated_on DATETIME,
    rvep_event_id INT(11),
    rvep_location_id INT(11),
    todo_list_id INT(11),
    CONSTRAINT FKa8ha1fcx0vc95154gf5nkq1cg FOREIGN KEY (rvep_event_id) REFERENCES rvep_event (id),
    CONSTRAINT FKt9jdbouqoq85alvlh147lh2a3 FOREIGN KEY (rvep_location_id) REFERENCES rvep_location (id),
    CONSTRAINT FKslh8ylev1r58jcwlusmgsp3mh FOREIGN KEY (todo_list_id) REFERENCES todo_list (id)
);
CREATE INDEX FKa8ha1fcx0vc95154gf5nkq1cg ON rvep_event_item (rvep_event_id);
CREATE INDEX FKslh8ylev1r58jcwlusmgsp3mh ON rvep_event_item (todo_list_id);
CREATE INDEX FKt9jdbouqoq85alvlh147lh2a3 ON rvep_event_item (rvep_location_id);
CREATE TABLE rvep_event_item_suggestion
(
    rvep_event_item_id INT(11) NOT NULL,
    suggestion_id INT(11) NOT NULL,
    CONSTRAINT FKd0ig3h34naweyaegxuee8adx6 FOREIGN KEY (rvep_event_item_id) REFERENCES rvep_event_item (id),
    CONSTRAINT FKop58ixloyhtxqi3j7dcs06dg7 FOREIGN KEY (suggestion_id) REFERENCES suggestion (id)
);
CREATE INDEX FKd0ig3h34naweyaegxuee8adx6 ON rvep_event_item_suggestion (rvep_event_item_id);
CREATE INDEX FKop58ixloyhtxqi3j7dcs06dg7 ON rvep_event_item_suggestion (suggestion_id);
CREATE TABLE rvep_event_item_task
(
    rvep_event_item_id INT(11) NOT NULL,
    event_item_task_id INT(11) NOT NULL,
    CONSTRAINT FKe4qv55jthtls9od95ci66alrj FOREIGN KEY (rvep_event_item_id) REFERENCES rvep_event_item (id),
    CONSTRAINT FKqt7nyibebmpyi2ab1ampk64an FOREIGN KEY (event_item_task_id) REFERENCES event_item_task (id)
);
CREATE INDEX FKe4qv55jthtls9od95ci66alrj ON rvep_event_item_task (rvep_event_item_id);
CREATE INDEX FKqt7nyibebmpyi2ab1ampk64an ON rvep_event_item_task (event_item_task_id);
CREATE TABLE rvep_event_suggestion
(
    rvep_event_id INT(11) NOT NULL,
    suggestion_id INT(11) NOT NULL,
    CONSTRAINT FK25kqrd21qy2f4wnsd5cj1yhsf FOREIGN KEY (rvep_event_id) REFERENCES rvep_event (id),
    CONSTRAINT FK1qr1d1b4bfn14ha2sjbeajyvs FOREIGN KEY (suggestion_id) REFERENCES suggestion (id)
);
CREATE INDEX FK1qr1d1b4bfn14ha2sjbeajyvs ON rvep_event_suggestion (suggestion_id);
CREATE INDEX FK25kqrd21qy2f4wnsd5cj1yhsf ON rvep_event_suggestion (rvep_event_id);
CREATE TABLE rvep_location
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    description VARCHAR(255),
    enabled TINYINT(4) NOT NULL,
    geolat FLOAT NOT NULL,
    geolng FLOAT NOT NULL,
    title VARCHAR(255)
);
CREATE TABLE rvep_role
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    enabled TINYINT(4) NOT NULL,
    name VARCHAR(255),
    role_category_id INT(11),
    CONSTRAINT FKiiph1utuan8a8bobljfidnbjc FOREIGN KEY (role_category_id) REFERENCES role_category (id)
);
CREATE INDEX FKiiph1utuan8a8bobljfidnbjc ON rvep_role (role_category_id);
CREATE TABLE rvep_user
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    created_on DATETIME,
    enabled TINYINT(4) NOT NULL
);
CREATE TABLE rvep_user_event
(
    rvep_user_id INT(11) NOT NULL,
    rvep_event_id INT(11) NOT NULL,
    CONSTRAINT FKthoc906vwix6ppqdk2fwcbry3 FOREIGN KEY (rvep_user_id) REFERENCES rvep_user (id),
    CONSTRAINT FK6vwegiuliwb5xgv69yxv9rf29 FOREIGN KEY (rvep_event_id) REFERENCES rvep_event (id)
);
CREATE INDEX FK6vwegiuliwb5xgv69yxv9rf29 ON rvep_user_event (rvep_event_id);
CREATE INDEX FKthoc906vwix6ppqdk2fwcbry3 ON rvep_user_event (rvep_user_id);
CREATE TABLE rvep_user_invite
(
    rvep_user_id INT(11) NOT NULL,
    invite_id INT(11) NOT NULL,
    CONSTRAINT FKobnwvggpbl2y856kd6mjij027 FOREIGN KEY (rvep_user_id) REFERENCES rvep_user (id),
    CONSTRAINT FKht8p1q5nw3xabgfdvny75r4ej FOREIGN KEY (invite_id) REFERENCES invite (id)
);
CREATE INDEX FKht8p1q5nw3xabgfdvny75r4ej ON rvep_user_invite (invite_id);
CREATE INDEX FKobnwvggpbl2y856kd6mjij027 ON rvep_user_invite (rvep_user_id);
CREATE TABLE suggestion
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    created_on DATETIME,
    description VARCHAR(255),
    enabled TINYINT(4) NOT NULL,
    status TINYINT(4) NOT NULL,
    title VARCHAR(255),
    updated_on DATETIME,
    rvep_user_id INT(11),
    CONSTRAINT FKlh398cjncst39ccsoqsw4fsob FOREIGN KEY (rvep_user_id) REFERENCES rvep_user (id)
);
CREATE INDEX FKlh398cjncst39ccsoqsw4fsob ON suggestion (rvep_user_id);
CREATE TABLE todo_list
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    created_on DATETIME,
    description VARCHAR(255),
    enabled TINYINT(4) NOT NULL,
    title VARCHAR(255),
    updated_on DATETIME,
    rvep_event_id INT(11),
    CONSTRAINT FKshsdekch6vj9wvpdhn2klfpsf FOREIGN KEY (rvep_event_id) REFERENCES rvep_event (id)
);
CREATE INDEX FKshsdekch6vj9wvpdhn2klfpsf ON todo_list (rvep_event_id);
CREATE TABLE todo_list_event_item_task
(
    todo_list_id INT(11) NOT NULL,
    event_item_task_id INT(11) NOT NULL,
    CONSTRAINT FKacq4g4bb6xuwf9wud6hxdmdbg FOREIGN KEY (todo_list_id) REFERENCES todo_list (id),
    CONSTRAINT FKq3k7v6ie74nqxjw5vaym7phs2 FOREIGN KEY (event_item_task_id) REFERENCES event_item_task (id)
);
CREATE INDEX FKacq4g4bb6xuwf9wud6hxdmdbg ON todo_list_event_item_task (todo_list_id);
CREATE INDEX FKq3k7v6ie74nqxjw5vaym7phs2 ON todo_list_event_item_task (event_item_task_id);
CREATE TABLE todo_list_item
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    description VARCHAR(255),
    enabled TINYINT(4) NOT NULL,
    title VARCHAR(255),
    todo_list_id INT(11),
    CONSTRAINT FK18gqgn05xl4ixjn92holx697t FOREIGN KEY (todo_list_id) REFERENCES todo_list (id)
);
CREATE INDEX FK18gqgn05xl4ixjn92holx697t ON todo_list_item (todo_list_id);
CREATE TABLE todo_list_item_event_item_task
(
    todo_list_item_id INT(11) NOT NULL,
    event_item_task_id INT(11) NOT NULL,
    CONSTRAINT FKimhbn1noh775vcjulrjtrcpq FOREIGN KEY (todo_list_item_id) REFERENCES todo_list_item (id),
    CONSTRAINT FKbkxy7wl7om03yncs5w8ubtikr FOREIGN KEY (event_item_task_id) REFERENCES event_item_task (id)
);
CREATE INDEX FKbkxy7wl7om03yncs5w8ubtikr ON todo_list_item_event_item_task (event_item_task_id);
CREATE INDEX FKimhbn1noh775vcjulrjtrcpq ON todo_list_item_event_item_task (todo_list_item_id);
CREATE TABLE user_contact
(
    user_profile_id INT(11) NOT NULL,
    rvep_user_id INT(11) NOT NULL,
    CONSTRAINT FKrpixjlw5yb4nq967y5sdubq25 FOREIGN KEY (user_profile_id) REFERENCES user_profile (id),
    CONSTRAINT FKgjxhbernlwtocpuyynu0493em FOREIGN KEY (rvep_user_id) REFERENCES rvep_user (id)
);
CREATE INDEX FKgjxhbernlwtocpuyynu0493em ON user_contact (rvep_user_id);
CREATE INDEX FKrpixjlw5yb4nq967y5sdubq25 ON user_contact (user_profile_id);
CREATE TABLE user_event_role
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    rvep_event_id INT(11),
    rvep_role_id INT(11),
    rvep_user_id INT(11),
    CONSTRAINT FK2dc7iij0lsabr399wdd7hwuwo FOREIGN KEY (rvep_event_id) REFERENCES rvep_event (id),
    CONSTRAINT FKb6y4kaupqeog2r9mh7g9l17o3 FOREIGN KEY (rvep_role_id) REFERENCES rvep_role (id),
    CONSTRAINT FKooqysp8fm7uu0k8ydnb9i256m FOREIGN KEY (rvep_user_id) REFERENCES rvep_user (id)
);
CREATE INDEX FK2dc7iij0lsabr399wdd7hwuwo ON user_event_role (rvep_event_id);
CREATE INDEX FKb6y4kaupqeog2r9mh7g9l17o3 ON user_event_role (rvep_role_id);
CREATE INDEX FKooqysp8fm7uu0k8ydnb9i256m ON user_event_role (rvep_user_id);
CREATE TABLE user_profile
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    email VARCHAR(255),
    last_login DATETIME,
    rvep_user_id INT(11),
    CONSTRAINT FK4l7ry9xflimgjgilotbmhi8wi FOREIGN KEY (rvep_user_id) REFERENCES rvep_user (id)
);
CREATE INDEX FK4l7ry9xflimgjgilotbmhi8wi ON user_profile (rvep_user_id);
CREATE TABLE user_role
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    rvep_role_id INT(11),
    rvep_user_id INT(11),
    CONSTRAINT FK227047fs5imxgmh8s02eu2ntq FOREIGN KEY (rvep_role_id) REFERENCES rvep_role (id),
    CONSTRAINT FKgpr8wn9oktyyqd0cnvvlcks3f FOREIGN KEY (rvep_user_id) REFERENCES rvep_user (id)
);
CREATE INDEX FK227047fs5imxgmh8s02eu2ntq ON user_role (rvep_role_id);
CREATE INDEX FKgpr8wn9oktyyqd0cnvvlcks3f ON user_role (rvep_user_id);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
