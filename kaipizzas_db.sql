CREATE DATABASE kaipizzas_db

USE kaipizzas_db

-- Bảng Customers
CREATE TABLE Customers (
    CustomerID BIGINT IDENTITY(100,1) PRIMARY KEY,
    ContactName NVARCHAR(255),
    Address NVARCHAR(255),
    Phone VARCHAR(20),
	AccountID VARCHAR(255),
	Email VARCHAR(255)
);

ALTER TABLE Customers ADD Email VARCHAR(255)

-- Bảng Categories
CREATE TABLE Categories (
    CategoryID INT IDENTITY PRIMARY KEY,
    CategoryName NVARCHAR(255) NOT NULL,
    Description NVARCHAR(MAX)
);

select * from Categories

-- Bảng Suppliers
CREATE TABLE Suppliers (
    SupplierID INT IDENTITY PRIMARY KEY,
    CompanyName NVARCHAR(255) NOT NULL,
    Address NVARCHAR(255),
    Phone VARCHAR(20)
);

-- Bảng Products
CREATE TABLE Products (
    ProductID BIGINT IDENTITY(10000,1) PRIMARY KEY,
    ProductName NVARCHAR(255) NOT NULL,
    SupplierID INT FOREIGN KEY REFERENCES Suppliers(SupplierID),
    CategoryID INT FOREIGN KEY REFERENCES Categories(CategoryID),
    Quantity BIGINT,
    UnitPrice DECIMAL(10, 2),
    ProductImage VARCHAR(MAX),
	Description NVARCHAR(MAX)
);

-- Bảng Orders
CREATE TABLE Orders (
    OrderID BIGINT IDENTITY(1000,1) PRIMARY KEY,
    CustomerID BIGINT FOREIGN KEY REFERENCES Customers(CustomerID),
    OrderDate DATETIME,	
    RequiredDate DATETIME,
    ShippedDate DATETIME,
    Freight DECIMAL(10, 2),
	Total DECIMAL(10,2),
    ShipAddress NVARCHAR(255),
	Status VARCHAR(200),
	Note TEXT,
	PaymentMethod VARCHAR(200)
);

SELECT * FROM Orders where ShippedD



SELECT * FROM Orders 
WHERE OrderDate >= DATEADD(MONTH, -3, GETDATE());

-- Bảng Order Details
CREATE TABLE OrderDetails (
    OrderID BIGINT FOREIGN KEY REFERENCES Orders(OrderID),
    ProductID BIGINT FOREIGN KEY REFERENCES Products(ProductID),
    UnitPrice DECIMAL(10, 2),
    Quantity INT,
	Size VARCHAR(10) not null,
	Total DECIMAL(10,2),
    PRIMARY KEY (OrderID, ProductID)
);

SELECT * FROM OrderDetails

SELECT * FROM Customers where AccountID = '3b3f62e5-2dbd-4602-bc8a-4862d168d94d'
SELECT * FROM Orders WHERE CustomerID IN (SELECT CustomerID FROM Customers WHERE AccountId = '3b3f62e5-2dbd-4602-bc8a-4862d168d94d')

SELECT * FROM Accounts

-- Bảng Roles
CREATE TABLE Roles(
	RoleID INT IDENTITY PRIMARY KEY,
	Name NVARCHAR(200) NOT NULL
);

INSERT INTO Roles values('ADMIN')
INSERT INTO Roles values('USER')

SELECT * FROM Roles

-- Bảng Account
CREATE TABLE Accounts (
    AccountID VARCHAR(255) PRIMARY KEY,
    UserName VARCHAR(255) UNIQUE NOT NULL,
    Password VARCHAR(255) NOT NULL,
	Email VARCHAR(255) UNIQUE NOT NULL,
    FirstName NVARCHAR(255),
	LastName NVARCHAR(255),
	PointRewards DECIMAL(10,2),
	DateOfBirth DATE,
    RoleID INT,
	Phone VARCHAR(20) UNIQUE,
	imageUrl VARCHAR(MAX),
	status VARCHAR(255),
	CONSTRAINT FK_ACCOUNTS_ROLES FOREIGN KEY(RoleID) REFERENCES Roles(RoleID)
);


CREATE TABLE TokenVerify(
	token VARCHAR(255) PRIMARY KEY,
	AccountID VARCHAR(255) REFERENCES Accounts(AccountID),
	ExpirationTime BIGINT,
	createdAt DATETIME 
)

SELECT * FROM TokenVerify WHERE AccountID=? AND createdAt = (SELECT MAX(createdAt) FROM TokenVerify WHERE AccountID=?)

ALTER TABLE Accounts DROP CONSTRAINT [UQ__Accounts__5C7E359ECDAB1336]

ALTER TABLE Accounts ADD About TEXT;

ALTER TABLE TokenVerify ADD createdAt DATETIME 
ALTER TABLE Accounts DROP COLUMN status VARCHAR(255)
ALTER TABLE Accounts ADD CONSTRAINT DF_Account_Status DEFAULT 'unverify' FOR status;

UPDATE Accounts SET status = 'active' where UserName = 'admin'

SELECT * FROM Accounts
ALTER TABLE Accounts DROP CONSTRAINT FK_ACCOUNTS_ROLES
DROP TABLE Accounts

CREATE TABLE Contact(
	Id BIGINT IDENTITY PRIMARY KEY,
	FirstName NVARCHAR(255),
	LastName NVARCHAR(255),
	Email VARCHAR(255),
	Phone VARCHAR(15),
	DateOfBirth Date,
	Address TEXT,
	Message TEXT
)

SELECT * FROM OrderDetails
SELECT * FROM Orders
SELECT * FROM Customers
DELETE FROM Orders
DELETE FROM Customers

SELECT * FROM Orders WHERE OrderID = IDENT_CURRENT('Orders')
SELECT * FROM OrderDetails WHERE OrderID = 1004
SELECT * FROM OrderDetails o where OrderID = 1007


SELECT * FROM TokenVerify WHERE AccountID = IDENT_CURRENT('TokenVerify')


DELETE FROM OrderDetails
ALTER TABLE OrderDetails ALTER COLUMN Size VARCHAR(10) NOT NULL
ALTER TABLE OrderDetails ADD PRIMARY KEY(OrderID, ProductID, Size)

SELECT * FROM Products WHERE CategoryID = 4

update Products set CategoryID = 1 where ProductID = 10000

SET IDENTITY_INSERT Categories ON;

INSERT INTO Categories (CategoryID, CategoryName, Description)
VALUES (0, 'Uncategorized', 'Default category');

INSERT INTO Categories (CategoryID, CategoryName, Description)
VALUES (4, 'Vegetarian Pizza', 'Vegetarian pizzas with fresh vegetables such as bell peppers, onions, mushrooms, and tomatoes.');

10012 10014 10019
SELECT * FROM Products

SELECT * FROM Suppliers

SET IDENTITY_INSERT Products ON;

SET IDENTITY_INSERT Categories OFF;

DELETE FROM Products WHERE ProductID = 10022

INSERT INTO Products (ProductID, ProductName, SupplierID, CategoryID, Quantity, UnitPrice, ProductImage, Description)
VALUES 
(10012, N'Classic Veggie Pizza', 4, 4, 50, 12.99, 'p13.jpg', N'A delicious vegetarian pizza with bell peppers, onions, mushrooms, and tomatoes.'),
(10014, N'Mediterranean Veggie Pizza', 4, 4, 30, 14.99, 'p15.jpg', N'Fresh Mediterranean-style pizza topped with olives, spinach, and feta cheese.'),
(10019, N'Vegan Supreme Pizza', 4, 4, 40, 15.99, 'p20.jpg', N'A healthy vegan pizza loaded with fresh veggies and dairy-free cheese.');

SET IDENTITY_INSERT Products OFF;

DELETE FROM Products where CategoryID = 0

SELECT * FROM Accounts

DELETE FROM Accounts where username = 'cesblus204'

DELETE FROM Accounts where username = 'devkai229'

SELECT * FROM Orders
user12345 - cesblus204
SELECT * FROM Customers
DELETE FROM Customers
DELETE FROM Customers

DELETE FROM Orders WHERE OrderID = 1016
SELECT * FROM OrderDetails

DELETE FROM OrderDetails

SELECT * FROM Customers

SELECT * FROM TokenVerify

DELETE FROM TokenVerify

ALTER TABLE TokenVerify DROP COLUMN ExpirationTime

ALTER TABLE Accounts ADD CONSTRAINT about_define DEFAULT '#NoData' for About

ALTER TABLE Accounts ADD CONSTRAINT firstname_define DEFAULT '#NoData' for FirstName


ALTER TABLE Accounts ADD CONSTRAINT lastname_define DEFAULT '#NoData' for LastName

ALTER TABLE Accounts ADD CONSTRAINT phone_define DEFAULT '#NoData' for Phone


SELECT * FROM Accounts

UPDATE Accounts SET About = '#NoData' WHERE username = 'cesblus204'

UPDATE Accounts SET FirstName = '#NoData' WHERE username = 'cesblus204'

UPDATE Accounts SET LastName = '#NoData' WHERE username = 'cesblus204'

UPDATE Accounts SET Phone = '#NoData' WHERE username = 'cesblus204'

SELECT * FROM ACCOUNTS


CREATE TABLE REWARDS(
	id int identity(1000,1) primary key,
	name nvarchar(MAX),
	point DECIMAL(10,2),
	limitExchange int,
	ImageUrl TEXT,
	quantity INT,
	description NVARCHAR(MAX)
)

ALTER TABLE REWARDS ADD quantity int
select * from REWARDS

CREATE TABLE Account_Rewards (
	accountid varchar(255) references Accounts(accountid),
	rewardid int references Rewards(id),
	exchangedDate Date,
	address NVARCHAR(MAX),
	phone VARCHAR(18),
	constraint PK_Account_Reward PRIMARY KEY(accountid, rewardid)
)

select * from Account_Rewards


ALTER TABLE Account_Rewards add phone VARCHAR(18)


ALTER TABLE Account_rewards add Status VARCHAR(50)

select * from Account_Rewards

select * from REWARDS

select * from accounts

DELETE FROM Account_Rewards where accountid = '3b3f62e5-2dbd-4602-bc8a-4862d168d94d'

UPDATE Accounts SET pointRewards = 0 where username = 'cesblus204'

select * from Account_Rewards where AccountId = (SELECT AccountId FROM Accounts where Username = 'cesblus204') AND rewardid = 1000

update Accounts set PointRewards = 112.5 where Username = 'cesblus204'

UPDATE Products SET Quantity = 20 where Productid = 10016

SELECT * FROM Products
UPDATE Products set ProductImage = 'p17.jpg' where ProductID IN(10003, 10004, 10005, 10007, 10020)

DELETE FROM Accounts where username = 'devkai229'
SELECT * FROM ACCOUNTS
DELETE FROM TokenVerify
SELECT * FROM TokenVerify
SELECT * FROM Customers

SELECT * FROM ORDERS

-- admin admin12345
-- cesblus204 user12345

