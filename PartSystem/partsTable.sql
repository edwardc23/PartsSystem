CREATE DATABASE  IF NOT EXISTS `Parts_Inv`;
USE `Parts_Inv`;

--
-- Table structure for table `Parts` & 'Admin Info'
--

DROP TABLE IF EXISTS `parts_inventory`;

CREATE TABLE parts (
                ID INT AUTO_INCREMENT NOT NULL,
                Part_Name VARCHAR(15) NOT NULL,
                Location VARCHAR(100) NOT NULL,
                Make VARCHAR(25) NOT NULL,
                Model VARCHAR(25) NOT NULL,
                Model_Year VARCHAR(5) NOT NULL,
                MSRP double(100,2) NOT NULL,
                Price double(100,2) NOT NULL,
                PRIMARY KEY (ID)
);
CREATE TABLE adminInfo (
                ID INT AUTO_INCREMENT NOT NULL,
                userName VARCHAR(30) NOT NULL,
                Password VARCHAR(100) NOT NULL,
               
                PRIMARY KEY (ID)
);
CREATE TABLE assets(
				ID INT AUTO_INCREMENT NOT NULL,
				Part_Name VARCHAR(15) NOT NULL,
                Amount int NOT NULL,
                Cost double NOT NULL,
                MSRP double NOT NULL,
                Total_MSRP double NOT NULL,
                Total_Cost double NOT NULL,
                Profit double NOT NULL,
                PRIMARY KEY (ID)
);

