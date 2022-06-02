DROP DATABASE IF EXISTS lixoeletronico;
CREATE DATABASE lixoeletronico;
USE lixoeletronico;

/*********** CREATE TABLES ***********/

/* Clientes*/
CREATE TABLE Clientes(
	id            INT AUTO_INCREMENT,
    user_name           VARCHAR(255) NOT NULL,
    user_email            VARCHAR(255) NOT NULL UNIQUE,
    user_password         VARCHAR(255) NOT NULL,
	user_type           INT,
	PRIMARY KEY(id)
);

CREATE TABLE Pedidos(
	id               INT AUTO_INCREMENT,
    user_id          INT NOT NULL,
    pedido_criado    DATETIME NOT NULL,
    data_pedido      DATETIME NOT NULL,
	numero_pedido    INT,
	PRIMARY KEY(id),
    FOREIGN KEY(user_id ) REFERENCES Clientes(id)
);

CREATE TABLE Endereco(
	id               INT AUTO_INCREMENT,
    Pedido_id        INT NOT NULL,
    rua              VARCHAR(255) NOT NULL,
    cidade           VARCHAR(255) NOT NULL,
	numero           INT,
	PRIMARY KEY(id),
    FOREIGN KEY(Pedido_id) REFERENCES Pedidos(id)
);


INSERT INTO `Clientes` (`id`, `user_name`, `user_email`, `user_password`, `user_type`) VALUES ('1', 'Usuário Teste', 'usuario@gmail.com', '123', '1');