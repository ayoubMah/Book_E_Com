-- -----------------------------------------------------
-- Schema full-stack-sports-center
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS `ayoubCenter`;

USE `ayoubCenter` ;

-- Drop existing tables if they exist
DROP TABLE IF EXISTS Book;
DROP TABLE IF EXISTS Category;
DROP TABLE IF EXISTS Product;

-- Create the Book table
CREATE TABLE `Book` (
                        `Id` INT AUTO_INCREMENT PRIMARY KEY,
                        `Name` VARCHAR(255) NOT NULL,
                        `Author` VARCHAR(255) NOT NULL
);


-- Insert data into the Book table
INSERT INTO Book (Name, Author) VALUES
                                    ('Al-Muwatta', 'Imam Malik'),
                                    ('Al-Umm', 'Imam Shafi'),
                                    ('Ar-Raheeq Al-Makhtum (The Sealed Nectar)', 'Safi-ur-Rahman al-Mubarakpuri'),
                                    ('Al-Sira al-Nabawiyya', 'Ibn Hisham'),
                                    ('Al-Shamail al-Muhammadiyya', 'Imam Tirmidhi'),
                                    ('Al-Ajurrumiyya', 'Ibn Ajurrum'),
                                    ('Alfiyya Ibn Malik', 'Ibn Malik'),
                                    ('Mughni al-Labib', 'Ibn Hisham'),
                                    ('Sahih al-Bukhari', 'Imam Bukhari'),
                                    ('Sahih Muslim', 'Imam Muslim'),
                                    ('Riyadh as-Salihin', 'Imam Nawawi');

-- Create the Category table
CREATE TABLE `Category` (
                            `Id` INT AUTO_INCREMENT PRIMARY KEY,
                            `Name` VARCHAR(255) NOT NULL
);

-- Insert data into the Category table
INSERT INTO Category (Name) VALUES
                                ('Alfiqh'),
                                ('Assira'),
                                ('Anahw'),
                                ('Alhadith');

-- Create the Product table
CREATE TABLE `Product` (
                           `Id` INT AUTO_INCREMENT PRIMARY KEY,
                           `Name` VARCHAR(255) NOT NULL,
                           `Description` TEXT,
                           `Price` DECIMAL(10, 2) NOT NULL,
                           `PictureUrl` VARCHAR(255),
                           `ProductCategoryId` INT NOT NULL,
                           `ProductBookId` INT NOT NULL,
                           FOREIGN KEY (`ProductCategoryId`) REFERENCES `Category`(`Id`),
                           FOREIGN KEY (`ProductBookId`) REFERENCES `Book`(`Id`)
);

-- Insert data into the Product table
INSERT INTO Product (Name, Description, Price, PictureUrl, ProductCategoryId, ProductBookId) VALUES
    ('Al-Muwatta', 'Description1', 100.00, 'images/Product1.png', 1, 1),
    ('Al-Umm ', 'Description2', 200.00, 'images/Product2.png', 1, 2),
    ('Al-Majmu', 'Description3', 300.00, 'images/Product3.png', 1, 3),
    ('Ar-Raheeq Al-Makhtum', 'Description4', 400.00, 'images/Product4.png', 2, 4),
    ('Al-Sira al-Nabawiyya', 'Description5', 500.00, 'images/Product5.png', 2, 5),
    ('Al-Shamail al-Muhammadiyya', 'Description6', 600.00, 'images/Product6.png', 2, 6),
    ('Al-Ajurrumiyya', 'Description7', 700.00, 'images/Product7.png', 3, 7),
    ('Alfiyya Ibn Malik', 'Description8', 800.00, 'images/Product8.png', 3, 8),
    ('Mughni al-Labib', 'Description9', 900.00, 'images/Product9.png', 3, 9),
    ('Sahih al-Bukhari', 'Description10', 1000.00, 'images/Product10.png', 4, 10),
    ('Sahih Muslim', 'Description11', 1100.00, 'images/Product11.png', 4, 11),
    ('Riyadh -Salihin', 'Description12', 1200.00, 'images/Product12.png', 4, 12);
