CREATE TABLE users
(

 USER_ID SERIAL NOT NULL,

 PRIMARY KEY (USER_ID)

);
CREATE TABLE boxes
(
 BOX_ID SERIAL NOT NULL,
 USER_ID INTEGER REFERENCES users(USER_ID),


 PRIMARY KEY (BOX_ID)

);

CREATE TABLE palletes
(

 PALETTE_ID SERIAL NOT NULL,
 BOX_ID SERIAL REFERENCES boxes(BOX_ID),
 PALETTE_CONTENTS TEXT,

 PRIMARY KEY(PALETTE_ID)

);
