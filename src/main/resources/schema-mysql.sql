-- we don't know how to generate schema test (class Schema) :(
create table if not exists hibernate_sequence
(
	next_val bigint null
)
engine=MyISAM
;

create table if not exists part
(
	id bigint not null
		primary key,
	amount bigint null,
	name varchar(255) null,
	necessary bit null
)
engine=MyISAM
;
