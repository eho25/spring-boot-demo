IF OBJECT_ID('dbo.People', 'U') IS NOT NULL
DROP TABLE [dbo].[People];
create table people
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	email VARCHAR(50),
	age INT,
	job_id INT
);