Cooking Mama
============================

Esto es una aplicación de reservas de restaurante realizada con Jersey + DataNucleus + MySQL.

--> Opción Uno: Con un bat desde un computador con sistema operativo Windows

Ejecutar desde la terminal en la carpeta del proyecto

      Comandos.bat

Ejecutar en otra terminal 

      mvn exec:java -Pclient

--> Opción dos: Introduciendo manualmente todos los comandos

Ejecutar desde la terminal en la carpeta del proyecto

      mvn clean compile

      mysql -uroot -p < sql/create-messages.sql

      mvn datanucleus:schema-create

      mvn jetty:run

Ejecutar en otra terminal 

      mvn exec:java -Pclient