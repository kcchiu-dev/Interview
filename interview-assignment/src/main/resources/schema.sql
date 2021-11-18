-- Drop table
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS list;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS activity;

create table account
(
	user_id varchar(38) NOT NULL,
	username varchar(50) NULL,
	disable varchar(1) NULL,
	create_date date NULL,
	update_date date NULL
);
create unique index pk_account on account (user_id);

create table activity
(
	activity_id varchar(38) NULL,
	list_id varchar(38) NULL,
	user_id varchar(38) NULL,
	create_date date NULL,
	update_date date NULL
);
create unique index pk_activity on activity (activity_id);

create table list
(
	list_id varchar(38) NULL,
    list_name varchar(50) NULL,
	due_date date NULL,
	create_date date NULL,
	update_date date NULL
);
create unique index pk_list on list (list_id);

create table item
(
    item_id varchar(38) NULL,
    list_id varchar(38) NULL,
    item_name varchar(50) NULL,
    description varchar(100) NULL,
    deadline date NULL,
    create_date date NULL,
	update_date date NULL
);
create unique index pk_item on item (item_id);