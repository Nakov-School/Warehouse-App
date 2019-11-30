CREATE TABLE users
(

 user_id SERIAL NOT NULL,
 user_name TEXT NOT NULL UNIQUE,
 user_password TEXT NOT NULL,
 user_admin BOOLEAN NOT NULL DEFAULT FALSE,

 PRIMARY KEY (USER_ID)

);

CREATE TABLE box
(
 box_id SERIAL UNIQUE NOT NULL,
 box_content TEXT NOT NULL,
 box_quantity TEXT NOT NULL,
 box_pr boolean NOT NULL DEFAULT FALSE,

 box_sector integer NOT NULL,
 box_position integer NOT NULL,

 PRIMARY KEY (BOX_ID)
);