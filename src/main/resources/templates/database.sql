SET GLOBAL time_zone = '+2:00';

DROP DATABASE IF EXISTS spring_todo;
CREATE DATABASE IF NOT EXISTS spring_todo;

USE spring_todo;
CREATE TABLE todos(
                      id int not null auto_increment,
                      description text not null,
                      isComplete boolean default false,
                      createdAt timestamp default current_timestamp,
                      updatedAt timestamp default current_timestamp
                          on update current_timestamp,
                      primary key (id)
)