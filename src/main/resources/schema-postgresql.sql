/* Criando a tabela, esse if no exists = caso não tenha, caso não exista */ 
-- toda vez que ele for subir, vai executar essa tabela

CREATE TABLE IF NOT EXISTS cliente(
    -- serial ele sabe automatico que ele não é nulo, é mais facil paraprimary key
    id serial primary key,
    nome varchar(50),
    email varchar(50),
    telefone VARCHAR(30),
    endereco VARCHAR(100)

); 







