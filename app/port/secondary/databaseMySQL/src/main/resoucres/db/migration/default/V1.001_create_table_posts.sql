create table posts (
    id         bigint       primary key,
    title      varchar(255) not null,
    created_at datetime     not null,
    updated_at datetime     not null,
    created_by bigint       not null,
    content    longtext,
    thumbnail  varchar(500)
);