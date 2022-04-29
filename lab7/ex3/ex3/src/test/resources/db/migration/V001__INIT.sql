CREATE TABLE books (
  id BIGSERIAL PRIMARY KEY,
  name varchar(255) not null,
  author varchar(255) not null
);

INSERT INTO books (name, author) VALUES ('Mais 365 Dias', 'Blanka Lipinska');
INSERT INTO books (name, author) VALUES ('Endometriose', 'Dr. Francisco Carmona');
INSERT INTO books (name, author) VALUES ('Se Fosse Perfeito', 'Colleen Hoover');