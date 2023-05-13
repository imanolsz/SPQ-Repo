Cooking Mama
============================

Aplicación de reservas de restaurante realizada con Jersey + DataNucleus + MySQL.
  
  
     
     
*Opción Uno: Con un bat desde un computador con sistema operativo Windows*
-------------

Ejecutar desde la terminal en la carpeta del proyecto.

      Comandos.bat

Ejecutar en otra terminal.

      mvn exec:java -Pclient


*Opción dos: Introduciendo manualmente todos los comandos*
-------------

Ejecutar desde la terminal en la carpeta del proyecto,

Primero ejecute el siguiente comando para compilar todo y mejorar las clases de base de datos:

      mvn clean compile
      
Use el comando siguiente para crear la base de datos y otorgar privilegios.

      mysql -uroot -p < sql/create-messages.sql

Ejecute el siguiente comando para crear un esquema de base de datos.

      mvn datanucleus:schema-create
      
Use el comando siguiente para crear el usuario administador    
      
      mysql -uroot -proot < sql/create-admin.sql

Para lanzar el servidor, ejecute el  siguiente comando.

      mvn jetty:run

Ejecutar en otra terminal para lanzar el cliente.

      mvn exec:java -Pclient
