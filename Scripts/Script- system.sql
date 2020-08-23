SELECT * FROM dba_users;

CREATE USER HAIRRANG IDENTIFIED BY rootroot;

GRANT CONNECT, RESOURCE, CREATE VIEW TO HAIRRANG;

SELECT 
   username,
   default_tablespace,
   profile,
   authentication_type
  FROM
     dba_users
 WHERE
    USERNAME = 'HAIRRANG';