# LibraryApp
The LibraryApp is a  free and simple app for the 'librarian' where you can perform CRUD actions on members and books using Hibernate JPA.

# Instructions
In the resources package(src/resources/library_app_rev_database.sql) you will find the sql script to create the database.

Before running the application select the Java class persistence.xml (src/META-INF) and change the value to "create-drop".
Example: <property name="hibernate.hbm2ddl.auto" value="create-drop" />

In the main you can run the application on different command lines after removing the // lines.
