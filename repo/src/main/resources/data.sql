-- initial db prefill

insert into Customer(Id, Firstname, Lastname, Email, Phone, Country, City, Status, Created) values
(101000, 'Franz', 'Müller', 'franz@yahoo.de', '+49931231754','Germany', 'Würzburg', 'non-active', CURRENT_TIMESTAMP()),
(101001, 'Adam', 'Smith', 'adam.smith@gmail.com', '+43177177889','England', 'London', 'non-active', CURRENT_TIMESTAMP() ),
(101002, 'Marc', 'Miller', 'mmiller@ph.co.nz', null,'New Zealand', 'Auckland', 'current', CURRENT_TIMESTAMP()),
(101003, 'James', 'Bush', 'bush@ibm.co.uk', null,'Schottland', 'Edinburgh', 'non-active', CURRENT_TIMESTAMP());

insert into Note(Id, Description, FK_Customer) values
(5550, 'A nice guy', 101000),
(5551, 'Who is that ?',101001),
(5552, 'It''s Marc', 101002);
