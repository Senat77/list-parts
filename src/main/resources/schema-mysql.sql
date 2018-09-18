drop table if exists hibernate_sequence;
create table hibernate_sequence
(
	next_val bigint null
)
engine=InnoDB
;

drop table if exists part;
create table part
(
	id bigint not null
		primary key,
	amount bigint null,
	name varchar(255) null,
	necessary bit null
)
engine=InnoDB
;

