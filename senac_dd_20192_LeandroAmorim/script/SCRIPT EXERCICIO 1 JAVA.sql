DROP DATABASE IF EXISTS EMPRESADB;
CREATE DATABASE EMPRESADB;
USE EMPRESADB;


CREATE TABLE GERENTE(
IDGERENTE INT NOT NULL PRIMARY KEY AUTO_INCREMENT
,NOME VARCHAR(255) NOT NULL
,CPF VARCHAR(11) NOT NULL UNIQUE
,SEXO VARCHAR(2) NOT NULL
,IDADE INT NOT NULL
,SALARIOBRUTO DOUBLE NOT NULL
,SALARIOLIQUIDO DOUBLE NOT NULL
, IMPOSTORENDA DOUBLE NOT NULL
, CONTRIBUICAO DOUBLE NOT NULL
, COMISSAO DOUBLE NOT NULL
);


CREATE TABLE FUNCIONARIO_OP(
IDFUNCIONARIO_OP INT NOT NULL PRIMARY KEY AUTO_INCREMENT
,NOME VARCHAR(255) NOT NULL
,CPF VARCHAR(11) NOT NULL UNIQUE
,SEXO VARCHAR(2) NOT NULL
,IDADE INT NOT NULL
,SALARIOBRUTO DOUBLE NOT NULL
,SALARIOLIQUIDO DOUBLE NOT NULL
, IMPOSTORENDA DOUBLE NOT NULL
, CONTRIBUICAO DOUBLE NOT NULL
,IDGERENTE INT NOT NULL
,FOREIGN KEY (IDGERENTE) REFERENCES GERENTE (IDGERENTE)
);

CREATE TABLE DIRETOR(
IDDIRETOR INT NOT NULL PRIMARY KEY AUTO_INCREMENT
,NOME VARCHAR(255) NOT NULL
,CPF VARCHAR(11) NOT NULL UNIQUE
,SEXO VARCHAR(2) NOT NULL
,IDADE INT NOT NULL
,SALARIOBRUTO DOUBLE NOT NULL
,SALARIOLIQUIDO DOUBLE NOT NULL
, IR DOUBLE NOT NULL
, CONTRIBUICAO DOUBLE NOT NULL
,IDGERENTE INT NOT NULL
, FOREIGN KEY (IDGERENTE) REFERENCES GERENTE(IDGERENTE)
);
