create table users
(
    username varchar(20) NOT NULL,
    password varchar(100) NOT NULL,
    enabled  boolean NOT NULL DEFAULT FALSE,
    primary key (username)
);
create table user_roles (
    user_role_id SERIAL PRIMARY KEY,
    username varchar(20) NOT NULL,
    role varchar(20) NOT NULL,
    UNIQUE (username,role),
    FOREIGN KEY (username) REFERENCES users(username)
);

insert  into users (username,password, enabled) values ('foo','foo',true);
insert  into users (username,password, enabled) values ('bar','bar',true);

insert  into user_roles (username,role) values ('foo', 'ADMIN');
insert into user_roles (username,role) values ('bar','USER');
