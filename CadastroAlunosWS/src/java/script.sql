use userdb;

CREATE TABLE `aluno` (
 `id` bigint NOT NULL AUTO_INCREMENT,
 `nome` varchar(80) DEFAULT NULL,
 `email` varchar(80) DEFAULT NULL,
 `curso` varchar(30) DEFAULT NULL,
 PRIMARY KEY (`id`));