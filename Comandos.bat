call mvn clean compile
mysql -uroot -proot < sql/create-messages.sql
call mvn datanucleus:schema-create
call mvn jetty:run