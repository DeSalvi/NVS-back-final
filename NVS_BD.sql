USE master IF EXISTS(select * from sys.databases where name='NVS_BD')
DROP DATABASE NVS_BD
GO
CREATE DATABASE NVS_BD
GO
USE NVS_BD
GO

CREATE TABLE Usuario
( 
   id            INT IDENTITY,
   nome          VARCHAR(255)	NOT NULL,
   re            VARCHAR(6)	NOT NULL,
   senha         VARCHAR(100)	NOT NULL,
   nivelAcesso   VARCHAR(8)    NULL, -- ADMIN, TECNICO ou OPERADOR
   dataCadastro	 SMALLDATETIME	NOT NULL,
   statusUsuario VARCHAR(14)    NOT NULL, -- ATIVO ou INATIVO ou TROCAR_SENHA

   PRIMARY KEY (id)
)

INSERT Usuario (nome, re, senha, nivelAcesso, dataCadastro, statusUsuario)
VALUES ('Kellvyn Thiago Pereira da Costa', '000001', 'MjcwOTIwMDYNCg==', 'ADMIN', GETDATE(), 'ATIVO')
INSERT Usuario (nome, re, senha, nivelAcesso, dataCadastro, statusUsuario)
VALUES ('Pedro Henrique De Salvi Pedroso', '000002', 'MjMwNzIwMDYNCg==', 'TECNICO', GETDATE(), 'ATIVO')
INSERT Usuario (nome, re, senha, nivelAcesso, dataCadastro, statusUsuario)
VALUES ('Rodrigo do Santos Carlos', '000003', 'MTEwNjIwMDYNCg==', 'TECNICO', GETDATE(), 'INATIVO')
INSERT Usuario (nome, re, senha, nivelAcesso, dataCadastro, statusUsuario)
VALUES ('Miguel Cavalcante Barbosa', '000004', 'MTQwNDIwMDYNCg==', 'OPERADOR', GETDATE(),'TROCAR_SENHA')

CREATE TABLE Categoria
(
	id		 INT IDENTITY,
	nomeCat  VARCHAR(25) NOT NULL,  -- Jersey, Tênis, Bola, Acessórios

	PRIMARY KEY(id)
)

INSERT Categoria (nomeCat) VALUES ('Jersey')
INSERT Categoria (nomeCat) VALUES ('Tênis')
INSERT Categoria (nomeCat) VALUES ('Bola')
INSERT Categoria (nomeCat) VALUES ('Acessórios')

CREATE TABLE Produto
(
	id			 INT IDENTITY,
	nome	     VARCHAR(100) NOT NULL,
	descricao	 VARCHAR(1000) NOT NULL,
	codigoBarras VARCHAR(100) NOT NULL,
	foto		 varbinary(max) NULL,
	urlFoto		 VARCHAR(max)	NULL,
	preco		 DECIMAL(8,2) NOT NULL,
	categoria_id INT	      NOT NULL,
	statusProd	 VARCHAR(10)  NOT NULL, -- ATIVO ou INATIVO

	PRIMARY KEY (id),
	FOREIGN KEY (categoria_id) REFERENCES Categoria (id)
)

INSERT Produto (nome, descricao, codigoBarras, foto, urlFoto, preco, categoria_id, statusProd) 
VALUES ('Jersey Celtics 2k24 - Away ', 'Jersey Celtics temporada 2024 fora de casa', '7899001234',NULL, NULL, 450.00, 1, 'ATIVO')

CREATE TABLE Mensagem
(
	id	            INT			  IDENTITY,
	dataMensagem    SMALLDATETIME NOT NULL,
	emissorMensagem VARCHAR(255)  NOT NULL,
	email 	        VARCHAR(36)  NOT NULL,
	telefone	    VARCHAR(11)       NULL,
	texto 	        VARCHAR(400)  NOT NULL,
	statusMensagem  VARCHAR(10)   NOT NULL, -- CRITICA ou ELOGIO ou SUGESTÃO

	PRIMARY KEY (id)
)

INSERT Mensagem (dataMensagem, emissorMensagem, email, telefone, texto, statusMensagem)
VALUES (GETDATE(), 'Victoria Xavier de Lima Viana', 'vickxavdlv@gmail.com', '11987654321', 'Produtos de alta qualidade, adorei!','ELOGIO')

CREATE TABLE Campanha
(
	id	            INT			  IDENTITY,
	dataInicio    SMALLDATETIME NOT NULL,
	dataFim    SMALLDATETIME NOT NULL,
	nome VARCHAR(255)  NOT NULL,
	statusCampanha  VARCHAR(6)   NOT NULL, -- ATIVA ou INATIVA

	PRIMARY KEY (id)
)
INSERT Campanha (dataInicio, dataFIM, nome, statusCampanha)
VALUES ('06/06/2024 21:00:00','17/06/2024','Finais NBA','ATIVO')

CREATE TABLE CampanhaProduto
(
	id	            INT			  IDENTITY,
	produto_id INT NOT NULL,
	campanha_id INT NOT NULL,
	statusCampanhaProduto  VARCHAR(6)   NOT NULL, -- ATIVA ou INATIVA

	PRIMARY KEY (id),
	FOREIGN KEY (produto_id) REFERENCES Produto (id),
	FOREIGN KEY (campanha_id) REFERENCES Campanha (id)
)
INSERT CampanhaProduto (produto_id, campanha_id, statusCampanhaProduto)
VALUES (1, 1, 'ATIVO')

SELECT * FROM Usuario
SELECT * FROM Produto
SELECT * FROM Categoria
SELECT * FROM Mensagem
SELECT * FROM Campanha
SELECT * FROM CampanhaProduto

