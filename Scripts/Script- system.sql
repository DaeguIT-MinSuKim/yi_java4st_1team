SELECT * FROM dba_users;

CREATE USER hairrang IDENTIFIED BY rootroot;

GRANT CONNECT, RESOURCE, CREATE VIEW TO hairrang;

SELECT 
   username,
   default_tablespace,
   profile,
   authentication_type
  FROM
     dba_users
 WHERE
    USERNAME = 'hairrang';
    
   SELECT 
   username,
   default_tablespace,
   profile,
   authentication_type
  FROM
     dba_users;
     
