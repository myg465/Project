create table notice_list (
	seq int auto_increment primary key,
	title varchar(255),
    contents varchar(255),
    username varchar(255),
    file varchar(255),
	date varchar(255)
);

create table question (
	username varchar(255) primary key,
    title varchar(255),
	contents varchar(255),
    date varchar(255)
);

create table eventlist (
	seq int auto_increment primary key,
	title varchar(255),
    contents varchar(255),
    username varchar(255),
    file varchar(255),
	date varchar(255)
);