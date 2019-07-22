
create table user_details (user_id varchar(50) primary key,first_Name varchar(50),last_name varchar(50),
nick_name varchar(50),dob date,email_id varchar(50),address1 varchar(250),address2 varchar(250),
city varchar(50), state varchar(50), country varchar(50), pin varchar(50));

SELECT * FROM USER_DETAILS;

create sequence user_id_sequence increment by 1 maxvalue 999999999 no cycle owned by user_details.userId;