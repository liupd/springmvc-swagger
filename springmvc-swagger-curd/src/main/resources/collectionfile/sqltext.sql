create table student
(
   id      int not null auto_increment,
   name    varchar(50),
   stuNo   varchar(20),
   age     varchar(11),
   primary key(id)
)engine=innodb default charset=utf8;