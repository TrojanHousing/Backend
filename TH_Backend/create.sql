CREATE SCHEMA TrojanHousingDB;
USE TrojanHousingDB;

CREATE TABLE UserTable (
	UserId int NOT NULL AUTO_INCREMENT,
    EmailAddress varchar(30) NOT NULL,
    Password varchar(20) NOT NULL,
    PRIMARY KEY(UserId)
);

CREATE TABLE RentalListings(
	PropertyID int NOT NULL AUTO_INCREMENT,
    URL varchar(255) NOT NULL,
    AverageRating double NOT NULL, 
    Description varchar(255) NOT NULL,
    Price double NOT NULL,
    Beds int NOT NULL,
    Baths int NOT NULL,
    Address varchar(40) NOT NULL,
    Distance double NOT NULL,
    TopPicture varchar(255) NOT NULL,
	PRIMARY KEY(PropertyID)
);
CREATE TABLE SavedListings(
	UserID int,
	PropertyID int,
	FOREIGN KEY(UserID) REFERENCES UserTable(UserID),
	FOREIGN KEY(PropertyID) REFERENCES RentalListings(PropertyID)
);
CREATE TABLE Comments(
	CommentID int NOT NULL AUTO_INCREMENT,
    PropertyID int, 
    UserID int, 
    Text varchar(255) NOT NULL,
    Rating double NOT NULL,
    PRIMARY KEY(CommentID),
    FOREIGN KEY(PropertyID) REFERENCES RentalListings(PropertyID),
    FOREIGN KEY(UserId) REFERENCES UserTable(UserID)
);
CREATE TABLE Images(
	ImageID int NOT NULL AUTO_INCREMENT,
    PropertyID int,
    ImageURL varchar(255) NOT NULL,
    PRIMARY KEY(ImageID),
    FOREIGN KEY(PropertyID) REFERENCES RentalListings(PropertyID)
);


