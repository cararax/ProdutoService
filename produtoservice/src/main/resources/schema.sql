CREATE TABLE produtos (
  id          INTEGER IDENTITY PRIMARY KEY,
  nomeProduto VARCHAR(64) NOT NULL,
  valor     DECIMAL NOT NULL,
  quantidadeDisponivel INT NOT NULL);
