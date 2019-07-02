DROP TABLE IF EXISTS employee;
 
CREATE TABLE employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  fname VARCHAR(250),
  lname VARCHAR(250) NOT NULL,
  address VARCHAR(250) DEFAULT NULL,
  dept INT NOT NULL
);
 
INSERT INTO employee (fname, lname, address, dept) VALUES
  ('Mei', 'Wang', '342 Unknown Rd, Unknown City, GA, 30042', 1),
  ('Niren', 'Patel', '987 Awsome Blvd, Twin City, SC 25879', 2),
  ('Jeff', 'Smith', '876 Canton Rd, The City, NC 32087', 3);
  
CREATE TABLE department (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(150) NOT NULL,
  address VARCHAR(250) DEFAULT NULL,
);

INSERT INTO department (name, address) VALUES
  ('Secret Dept', '342 Dept Unknown Rd, Unknown City, GA, 30042'),
  ('Awesome Dept', '987 Fairyland Blvd, Twin City, SC 25879'),
  ('Star War', '876 Far Far Away Rd, The City, NC 32087');
