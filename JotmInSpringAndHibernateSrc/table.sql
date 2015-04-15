
drop table app_hotel;

create table app_hotel(
	hotel_id number(19),
	hotel_name varchar2(255),
	room_type char(1),
	bookings number(10),
	to_place varchar2(255),
	total_rooms number(10),
	booking_date date
);

delete from app_flight;
delete from app_car;

delete from app_hotel;
commit;

select * from app_flight;
select * from app_car;

select * from app_hotel;
select count(*) from app_hotel;
