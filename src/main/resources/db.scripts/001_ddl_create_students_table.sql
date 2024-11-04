CREATE TABLE students (
  id SERIAL PRIMARY KEY,
  last_name VARCHAR(100) NOT NULL,
  first_name VARCHAR(100) NOT NULL,
  middle_name VARCHAR(100),
  group_name VARCHAR(10) NOT NULL,
  average_score NUMERIC(3,1)
);