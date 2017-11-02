create table users (username varchar(50) not null primary key, password varchar(255) not null,
    enabled boolean not null) engine = InnoDb;
create table authorities (username varchar(50) not null, authority varchar(50) not null, foreign key (username) references users (username), 
unique index authorities_idx_1 (username, authority)) engine = InnoDb;

INSERT INTO user(username, password, enabled) VALUES('admin', 'password', '1');
INSERT INTO authorities VALUES('admin', 'ROLE_ADMIN');

INSERT INTO users(username, password, enabled) VALUES('user', 'password', '1');
INSERT INTO authorities VALUES('admin', 'ROLE_USER');
