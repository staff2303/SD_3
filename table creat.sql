use staff_board;
select * from staff_board;
create table member(
m_name char(20) not null,
m_id char(20) not null UNIQUE,
m_password char(20) not null,
m_nickname char(20) not null UNIQUE,
m_role char(10) DEFAULT 'user',
m_date datetime not null
);