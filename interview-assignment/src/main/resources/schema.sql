-- Drop table
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS list;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS activity;

create table account
(
	user_id varchar(38) PRIMARY KEY NOT NULL,
	username varchar(50) NOT NULL,
	disable varchar(1) NOT NULL,
	create_date date NOT NULL,
	update_date date NOT NULL
);

create table activity
(
	activity_id varchar(38) PRIMARY KEY NOT NULL,
	list_id varchar(38) NOT NULL,
	user_id varchar(38) NOT NULL,
	create_date date NOT NULL,
	update_date date NOT NULL
);

create table list
(
	list_id varchar(38) PRIMARY KEY NOT NULL,
    list_name varchar(50) NOT NULL,
	due_date date NOT NULL,
	create_date date NOT NULL,
	update_date date NOT NULL
);

create table item
(
    item_id varchar(38) PRIMARY KEY NOT NULL,
    list_id varchar(38) NOT NULL,
    item_name varchar(50) NOT NULL,
    description varchar(100) NOT NULL,
    deadline date NOT NULL,
    create_date date NOT NULL,
	update_date date NOT NULL
);