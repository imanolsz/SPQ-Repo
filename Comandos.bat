call mvn clean compile
mysql -uroot -proot < sql/create-messages.sql
call mvn datanucleus:schema-create
mysql -uroot -proot < sql/create-admin.sql
call mvn jetty:run