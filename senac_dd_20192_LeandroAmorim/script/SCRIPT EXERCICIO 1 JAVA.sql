DROP DATABASE IF EXISTS EMPRESADB;
CREATE DATABASE EMPRESADB;
USE EMPRESADB;


CREATE TABLE EMPREGADO(
IDEMPREGADO INT NOT NULL PRIMARY KEY AUTO_INCREMENT
,NOME VARCHAR(255) NOT NULL
,CPF VARCHAR(11) NOT NULL UNIQUE
,SEXO VARCHAR(2) NOT NULL
,IDADE INT NOT NULL
,SALARIOBRUTO DOUBLE NOT NULL
,SALARIOBASE DOUBLE NOT NUL
,SALARIOLIQUIDO DOUBLE NOT NULL
, IMPOSTORENDA DOUBLE NOT NULL
, CONTRIBUICAO DOUBLE NOT NULL
, COMISSAO DOUBLE NOT NULL
,TIPO VARCHAR(50) NOT NULL
);


CREATE TABLE LOTACAO(
IDLOTACAO INT NOT NULL PRIMARY KEY AUTO_INCREMENT
,NOME VARCHAR(255) NOT NULL
,SIGLA VARCHAR(3) NOT NULL UNIQUE
,IDRESPONSAVEL INT NOT NULL
,IDLOTACAOSUPERIOR INT 
,FOREIGN KEY (IDRESPONSAVEL) REFERENCES EMPREGADO(IDEMPREGADO)
,FOREIGN KEY (IDLOTACAOSUPERIOR) REFERENCES LOTACAO(IDLOTACAO)
);

CREATE TABLE TRABALHA(
IDLOTACAO INT NOT NULL
,IDEMPREGADO INT NOT NULL
, FOREIGN KEY (IDLOTACAO) REFERENCES LOTACAO(IDLOTACAO)
FOREIGN KEY (IDEMPREGADO) REFERENCES EMPREGADO(IDEMPREGADO)
);
