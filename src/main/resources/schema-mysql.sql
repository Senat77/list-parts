drop table if exists parts;
create table parts
(
	id        bigint        not null primary key auto_increment,
	amount    bigint        null,
	name      varchar(255)  null,
	necessary bit           null
);

