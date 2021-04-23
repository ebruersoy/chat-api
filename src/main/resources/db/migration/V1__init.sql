SET TIME ZONE 'UTC';
create sequence seq_message increment by 1 minvalue 1;

create table message(
  id bigint primary key not null ,
  content varchar not null,
  sender varchar not null,
  created_at TIMESTAMP WITH TIME ZONE not null
);
