/* DELETE 'messagesDB' database*/
DROP SCHEMA IF EXISTS messagesDB;
/* DELETE USER 'spq' AT LOCAL SERVER*/
DROP USER IF EXISTS 'spq'@'localhost';

/* CREATE 'messagesDB' DATABASE */
CREATE SCHEMA messagesDB;
/* CREATE THE USER 'spq' AT LOCAL SERVER WITH PASSWORD 'spq' */
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';

GRANT ALL ON messagesDB.* TO 'spq'@'localhost';

/* Tabla Reservas */
CREATE TABLE IF NOT EXISTS Reservas ( /* Creamos la tabla de reservas solo sino existe */
  id INTEGER PRIMARY KEY,
  nombre TEXT,
  fecha TEXT,
  hora TEXT,
  cantidad_personas INTEGER,
  Cancelada BOOLEAN /* Si esta cancelado se pone atrue, sino la reseva esta confirmada por defecto */ 
);
