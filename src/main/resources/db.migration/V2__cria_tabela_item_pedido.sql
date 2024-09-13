CREATE TABLE item_do_pedido (
  id BINARY(16) NOT NULL,
  descricao varchar(255) DEFAULT NULL,
  quantidade int(11) NOT NULL,
  pedido_id bigint(20) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (pedido_id) REFERENCES pedidos(id)
)