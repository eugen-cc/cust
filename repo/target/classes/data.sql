-- initial db prefil

insert into Customer(Id, Firstname, Lastname, Email, Phone, Country, City, Status, Created) values
(101000, 'Franz', 'Müller', 'franz@yahoo.de', '+49931231754','Germany', 'Würzburg', 'non-active', CURRENT_TIMESTAMP()),
(101001, 'Adam', 'Smith', 'adam.smith@gmail.com', '+43177177889','England', 'London', 'non-active', CURRENT_TIMESTAMP() ),
(101002, 'Marc', 'Miller', 'mmiller@ph.co.nz', null,'New Zealand', 'Auckland', 'current', CURRENT_TIMESTAMP());

insert into Note(Id, Description) values
(5550, 'A nice guy'),
(5551, 'Who is that ?'),
(5552, 'It''s Marc');

insert into Customer_Notes values
(101000,5550),
(101001,5551),
(101002,5552);