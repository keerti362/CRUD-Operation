DROP TABLE IF EXISTS TBL_MOVIE;
CREATE TABLE TBL_MOVIE
(
   movie_id int IDENTITY
   (
      1,
      1
   )
   PRIMARY KEY,
   movie_name varchar (50),
   description varchar (50),
   genre varchar (10),
   user_name varchar (50),
   rating int
);