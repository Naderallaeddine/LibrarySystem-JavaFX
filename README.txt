This is a library system using JavaFX and MySQL. 

DEPENDENCIES

Make sure to have:

1. mysql-connector-java-8.0.25.jar
2. library.sql (To be imported in PhpMyAdmin)

Jar files are included in the librarires folder

DESCRIPTION 

The user needs to create an account and then to login in order to use the system. After being stored to the database, the app offers the below features: 
1. User can add a new book to the system. 
2. User can add a new student to the system. 
3. User can issue books to students. 
4. User can return books to the system.
5. User can check on statistics; how many books are borrowed and how many are returned. 

The maximum number of borrowed books a student can have is 3.


DESIGN PATTERNS

1. MVC : Files are seperated into Models , view, can controllers. We have models for the statistics and that can also
be implemented to the book and user classes, and we have a controller and opens the views and links it with the models.
2. Observer : An observer design pattern is used when adding a book to send a notification to the user that the book was 
added successfully, you can find the  observer.java, popup.java, subject.java files in the utils folder containing the code.
3. Proxy : The proxy design pattern was used in the login method to prevent certain users to login, it restricts certain usernames
found in an array from logging in. login.java, FXMLDocumentController.java
4. Visitor : This design pattern can be used to add new features to several controllers without affecting the old code.
The Visitor files are in the utils folder.


Main Class : LibraryFX in the controller folder


SQL Database
----------------------------------------
Database Name : library

Admin credentials: 
Username : admin
Password : 12345678
or signup as a new user

Book IDS (To be used in the searching system)
Harry Potter 100
Game Of Thrones 101
The Lord of the rings 102
To Kill a Mockingbird 103
Brave New World 104
The Slight EdgeBook 105
Beloved 106

Students with IDS (To be used in the searching system)
user1 2
user2 3
user3 4

----------------------------------------
Project was developed in Visual Studio Code IDE

Thank you


