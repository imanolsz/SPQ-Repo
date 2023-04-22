Cooking Mama
============================

This is a restaurant reservation application made with Maven + Datanucleus + MySQL.

Run the following command to build everything and enhance the DB classes:

      mvn clean compile

Make sure that the database was correctly configured. Use the contents of the file *create-message.sql* to create the database and grant privileges. For example,

      mysql -uroot -p < sql/create-messages.sql

Run the following command to create database schema for this sample.

      mvn datanucleus:schema-create

To launch the server run the command

    mvn jetty:run

Now, the client sample code can be executed in a new command window with

    mvn exec:java -Pclient

