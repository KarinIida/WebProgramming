CREATE TABLE user ( 
  id SERIAL PRIMARY KEY UNIQUE NOT NULL
  , login_id varchar (255) UNIQUE NOT NULL
  , name varchar (255) NOT NULL
  , birth_date DATE NOT NULL
  , password varchar (255) NOT NULL
  , create_date DATETIME NOT NULL
  , update_date DATETIME NOT NULL
); 

INSERT 
INTO user 
VALUES ( 
  1
  , 'admin'
  , 'ä«óùé“'
  , 20000821
  , 'pass'
  , 20180801
  , 20180821
); 


select
*
from
user;
