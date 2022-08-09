create schema marvel_finder;

set search_path to marvel_finder;

create table roles (
	roleid int primary key,
	name varchar
);

insert into roles (roleid, name) values
(1, 'admin'), (2, 'basic');

create table comics (
    comicid varchar primary key,
    comicurl varchar not null
);

create table users (
    userid int generated always as identity primary key,
    email varchar unique not null,
    username varchar unique not null,
    pw varchar not null check (length(pw) >= 6),
    roleid int,

	constraint roles_fk
	foreign key (roleid)
	references roles(roleid)
);

create table UserFavoriteComics (
	userid int,
    comicid varchar,
    primary key (userid, comicid),

	constraint comicf_fk
	foreign key (comicid)
	references comics (comicid),

  constraint usersf_fk
	foreign key (userid)
	references users (userid)
);


select * from users;  
select * from roles;