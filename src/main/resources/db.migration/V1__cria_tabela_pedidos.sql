CREATE TABLE pedidos (
  id BINARY(16) NOT NULL,
  data_hora datetime NOT NULL,
  status varchar(255) NOT NULL,
  PRIMARY KEY (id)
)