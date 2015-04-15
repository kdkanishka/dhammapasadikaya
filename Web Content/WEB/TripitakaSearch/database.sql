create database dhammame_tsearchstat;
use dhammame_tsearchstat;

create table downloads(
	dcount_win long default 0,
	dcount_lin long default 0,
	dcount_oth long default 0
);

insert into downloads values(0,0,0);