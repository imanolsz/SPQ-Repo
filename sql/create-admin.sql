    USE messagesDB;
    INSERT INTO USER(id, admin, password) 
    SELECT 'ADMIN', 1, 'admin'
    WHERE NOT EXISTS (SELECT * FROM USER WHERE id='ADMIN');