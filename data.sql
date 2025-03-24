

INSERT INTO Categories (CategoryName, Description)
VALUES 
    ('Classic Pizza', 'Traditional pizzas with basic ingredients like tomato sauce, cheese, and simple toppings.'),
    ('Meat Pizza', 'Pizzas loaded with various types of meat such as sausage, beef, bacon, and chicken.'),
    ('Seafood Pizza', 'Pizzas featuring fresh seafood like shrimp, squid, tuna, and clams.'),
    ('Vegetarian Pizza', 'Vegetarian pizzas with fresh vegetables such as bell peppers, onions, mushrooms, and tomatoes.'),
    ('Specialty Pizza', 'Unique pizzas with creative toppings and preparations like Buffalo Chicken, Taco Pizza, or Pesto Pizza.');


INSERT INTO Suppliers (CompanyName, Address, Phone)
VALUES 
    ('Domino''s Pizza', 'Ann Arbor, Michigan, USA', '+1-734-930-3030'),
    ('Pizza Hut', 'Plano, Texas, USA', '+1-800-948-8488'),
    ('The Pizza Company', 'Bangkok, Thailand', '+66-1112'),
    ('Simple Simon''s Pizza', 'Glenpool, Oklahoma, USA', '+1-918-322-5300'),
    ('Juno''s Pizza', 'São Paulo, Brazil', '+55-11-98765-4321'); 




INSERT INTO Products (ProductName, SupplierID, CategoryID, Quantity, UnitPrice, ProductImage, Description)
VALUES 
    -- Domino's Pizza
    ('Pepperoni Pizza', 1, 1, 50, 12.99, 'p1.jpg', 'Classic pepperoni pizza with mozzarella and tomato sauce.'),
    ('Margherita Pizza', 1, 1, 50, 10.99, 'p2.jpg', 'Traditional Margherita pizza with fresh basil and mozzarella.'),
    ('Chicken Alfredo Pizza', 1, 5, 30, 14.99, 'p3.jpg', 'Rich Alfredo sauce, grilled chicken, and mozzarella cheese.'),
    ('Deluxe Pizza', 1, 1, 30, 13.99, 'p4.jpg', 'A mix of pepperoni, sausage, mushrooms, green peppers, and onions.'),

    -- Pizza Hut
    ('Meat Lover''s Pizza', 2, 2, 40, 15.99, 'p5.jpg', 'Loaded with pepperoni, sausage, bacon, and beef.'),
    ('Hawaiian Pizza', 2, 1, 40, 13.99, 'p6.avif', 'Ham and pineapple on a classic crust.'),
    ('Supreme Pizza', 2, 2, 25, 16.99, 'p7.jpg', 'Packed with pepperoni, sausage, beef, green peppers, onions, and mushrooms.'),
    ('Triple Cheese Pizza', 2, 1, 25, 14.99, 'p8.jpg', 'Loaded with mozzarella, cheddar, and parmesan cheese.'),

    -- The Pizza Company
    ('Seafood Deluxe Pizza', 3, 3, 30, 18.99, 'p9.jpg', 'Shrimp, squid, and clams with a creamy white sauce.'),
    ('Tom Yum Pizza', 3, 5, 20, 16.99, 'p10.jpg', 'A fusion of Thai flavors with shrimp, mushrooms, and spicy tom yum sauce.'),
    ('Spicy Seafood Pizza', 3, 3, 20, 17.99, 'p11.jpg', 'A spicy mix of shrimp, squid, and mussels with chili sauce.'),
    ('BBQ Chicken Pizza', 3, 5, 20, 15.99, 'p12.jpg', 'Grilled chicken with tangy BBQ sauce, onions, and cheddar cheese.'),

    -- Simple Simon''s Pizza
    ('Vegetarian Pizza', 4, 4, 25, 11.99, 'p13.jpg', 'Fresh vegetables including bell peppers, onions, and mushrooms.'),
    ('Bacon Cheeseburger Pizza', 4, 2, 20, 14.99, 'p14.png', 'Ground beef, bacon, and cheddar cheese.'),
    ('Garlic Veggie Pizza', 4, 4, 20, 12.99, 'p15.jpg', 'Fresh vegetables with garlic butter sauce.'),
    ('Philly Cheesesteak Pizza', 4, 2, 15, 15.49, 'p16.jpg', 'Thinly sliced steak, onions, green peppers, and provolone cheese.'),

    -- Juno''s Pizza
    ('Calzone Pizza', 5, 5, 15, 12.49, 'p17.jpg', 'Folded pizza filled with mozzarella, ricotta, and salami.'),
    ('Brazilian Style Pizza', 5, 1, 15, 13.99, 'p18.jpg', 'Unique toppings with fresh ingredients from Brazil.'),
	('4 Cheese Brazilian Pizza', 5, 5, 10, 14.49, 'p19.jpg', 'A Brazilian take on classic 4-cheese pizza with local ingredients.'),
    ('Sweet Corn Pizza', 5, 4, 10, 13.49, 'p20.jpg', 'A light pizza topped with sweet corn, mozzarella, and basil.');


	SELECT * FROM Products

	SELECT * FROM REWARDS
INSERT INTO REWARDS (name, point, limitExchange, description, ImageUrl, quantity)
VALUES 
('Insulated Water Bottle', 12.50, 1, 'High-quality insulated bottle that keeps drinks hot or cold.', 'water_bottle.png', 200),
('Branded Drinking Glass', 14.80, 1, 'Elegant glass with our pizza brand logo.', 'drinking_glass.png', 150),
('Ceramic Pizza Plate', 18.20, 1, 'Premium ceramic plate, perfect for enjoying pizza at home.', 'plate.png', 100),
('Kaicourses Tote Bag', 22.50, 1, 'Eco-friendly reusable tote bag for shopping.', 'totebag.png', 40),
('Kaicourses Helmet', 30.55, 1, 'Stylish safety helmet with our pizza brand logo.', 'helmet.png', 50),
('Kaicourses Coat', 38.55, 1, 'Lightweight and durable raincoat for easy carrying.', 'coat.png', 20),
('Pizza Keychain', 8.12, 1, 'Cute pizza-shaped keychain, perfect for pizza lovers.', 'keychain.png', 200),
('ID Badge Lanyard', 5.40, 1, 'Convenient lanyard for employees or loyal customers.', 'lanyard.png', 300);

UPDATE REWARDS SET quantity = 200 where id = 1000










