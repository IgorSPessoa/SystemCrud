DROP DATABASE IF EXISTS lixoeletronico;
    CREATE DATABASE lixoeletronico;
    USE lixoeletronico;

    /*********** CREATE TABLES ***********/

    /* administradores*/
    CREATE TABLE administracao(
        id            INT AUTO_INCREMENT,
        user_name           VARCHAR(255) NOT NULL,
        user_email            VARCHAR(255) NOT NULL UNIQUE,
        user_password         VARCHAR(255) NOT NULL,
        user_type           VARCHAR(255) NOT NULL,
        PRIMARY KEY(id)
    );

    /* Pedidos*/
    CREATE TABLE Pedidos(
        id               INT AUTO_INCREMENT,
        user_name        VARCHAR(255) NOT NULL,
        user_email       VARCHAR(255) NOT NULL,
        order_created    VARCHAR(255) NOT NULL,
        date_order       VARCHAR(255) NOT NULL,
        created_by       INT NOT NULL,
        type_pedido      VARCHAR(255) NOT NULL,
        street           VARCHAR(255) NOT NULL,
        city             VARCHAR(255) NOT NULL,
        house_number     INT NOT NULL,
        FOREIGN KEY(created_by) REFERENCES administracao(id),
        PRIMARY KEY(id)
    );


    /*ADM padrão*/
    INSERT INTO `administracao` (`id`, `user_name`, `user_email`, `user_password`, `user_type`) VALUES ('1', 'Igor', 'adm@gmail.com', '123', 'ADM');
    INSERT INTO `administracao` (`id`, `user_name`, `user_email`, `user_password`, `user_type`) VALUES ('2', 'funcionário', 'funcionario@gmail.com', '123', 'FUNCIONARIO');


    /*Pedidos de população de tabela para exemplos*/
    INSERT INTO `Pedidos` (`id`, `user_name`,`user_email`, `order_created`, `date_order`,`created_by`,`type_pedido`,`street`,`city`,`house_number`) VALUES ('1', 'Pedro','Pedro@gmail.com', '2022-06-01', '2022-06-13','1','M','rua Osvalso Prático','São Paulo','2073');
    INSERT INTO `Pedidos` (`id`, `user_name`,`user_email`, `order_created`, `date_order`,`created_by`,`type_pedido`,`street`,`city`,`house_number`) VALUES ('2', 'Paulo','Paulo@gmail.com', '2022-02-01', '2022-05-13','1','P','rua Eubelo','São Paulo','2003');
    INSERT INTO `Pedidos` (`id`, `user_name`,`user_email`, `order_created`, `date_order`,`created_by`,`type_pedido`,`street`,`city`,`house_number`) VALUES ('3', 'Jose','Jose@gmail.com', '2022-04-01', '2022-04-13','1','M','Rua Porto Seguro','São Paulo','2074');
    INSERT INTO `Pedidos` (`id`, `user_name`,`user_email`, `order_created`, `date_order`,`created_by`,`type_pedido`,`street`,`city`,`house_number`) VALUES ('4', 'Felipe','Felipe@gmail.com', '2022-03-01', '2022-06-10','1','P','Rua Rodrigues das Neves','São Paulo','1073');
    INSERT INTO `Pedidos` (`id`, `user_name`,`user_email`, `order_created`, `date_order`,`created_by`,`type_pedido`,`street`,`city`,`house_number`) VALUES ('5', 'Amanda','Amanda@gmail.com', '2022-05-01', '2022-06-03','1','M','Viela Cinco','São Paulo','2273');
    INSERT INTO `Pedidos` (`id`, `user_name`,`user_email`, `order_created`, `date_order`,`created_by`,`type_pedido`,`street`,`city`,`house_number`) VALUES ('6', 'Maria','Maria@gmail.com', '2022-04-01', '2022-06-23', '1','G','Rua Capitão Ulisses Soares de Campos','São Paulo','2573');
    INSERT INTO `Pedidos` (`id`, `user_name`,`user_email`, `order_created`, `date_order`,`created_by`,`type_pedido`,`street`,`city`,`house_number`) VALUES ('7', 'Joana','Joana@gmail.com', '2022-01-01', '2022-02-09',  '1','G','Rua Guanabi','São Paulo','2773');
    INSERT INTO `Pedidos` (`id`, `user_name`,`user_email`, `order_created`, `date_order`,`created_by`,`type_pedido`,`street`,`city`,`house_number`) VALUES ('8', 'Mariana','Mariana@gmail.com', '2022-01-01', '2022-01-13', '1','G','Rua Oliveira Alves','São Paulo','2373');
    INSERT INTO `Pedidos` (`id`, `user_name`,`user_email`, `order_created`, `date_order`,`created_by`,`type_pedido`,`street`,`city`,`house_number`) VALUES ('9', 'Mateus','Mateus@gmail.com','2022-03-12', '2022-04-18', '1','M','rua Mario Menin','São Paulo','3838');

