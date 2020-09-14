CREATE TABLE `autoridade` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `cargo` varchar(255) DEFAULT NULL,
                              `data_atualizacao` datetime NOT NULL,
                              `data_cadastro` datetime NOT NULL,
                              `nome` varchar(60) NOT NULL,
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `UK_dtjo3dv50nykveg7ub2hrt786` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `permissao` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `descricao` varchar(50) NOT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `unidade` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `data_atualizacao` datetime NOT NULL,
                           `data_cadastro` datetime NOT NULL,
                           `email` varchar(50) NOT NULL,
                           `endereco_bairro` varchar(255) DEFAULT NULL,
                           `endereco_cep` varchar(255) DEFAULT NULL,
                           `cidade` varchar(255) DEFAULT NULL,
                           `complemento` varchar(255) DEFAULT NULL,
                           `endereco_latitude` double DEFAULT NULL,
                           `endereco_logradouro` varchar(255) DEFAULT NULL,
                           `endereco_longitude` double DEFAULT NULL,
                           `endereco_numero` varchar(255) DEFAULT NULL,
                           `nome` varchar(50) NOT NULL,
                           `telefone` varchar(15) DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `UK_srkl9l04deftdvdtel96lw5hd` (`email`),
                           UNIQUE KEY `UK_qb849dysiaug9hm77b9puawvp` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `grupo` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `nome` varchar(60) NOT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `UK_2iij2lspt3u2dj6c5max7ktt3` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `grupo_permissao` (
                                   `grupo_id` bigint NOT NULL,
                                   `permissao_id` bigint NOT NULL,
                                   KEY `FKh21kiw0y0hxg6birmdf2ef6vy` (`permissao_id`),
                                   KEY `FKta4si8vh3f4jo3bsslvkscc2m` (`grupo_id`),
                                   CONSTRAINT `FKh21kiw0y0hxg6birmdf2ef6vy` FOREIGN KEY (`permissao_id`) REFERENCES `permissao` (`id`),
                                   CONSTRAINT `FKta4si8vh3f4jo3bsslvkscc2m` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `usuario` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `avatar` varchar(255) DEFAULT NULL,
                           `celular` varchar(255) DEFAULT NULL,
                           `cpf` varchar(255) NOT NULL,
                           `data_atualizacao` datetime NOT NULL,
                           `data_cadastro` datetime NOT NULL,
                           `data_nascimento` date NOT NULL,
                           `email` varchar(50) NOT NULL,
                           `nome` varchar(50) NOT NULL,
                           `perfil` varchar(255) DEFAULT NULL,
                           `grupo_id` bigint NOT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `UK_692bsnqxa8m9fmx7m1yc6hsui` (`cpf`),
                           UNIQUE KEY `UK_5171l57faosmj8myawaucatdw` (`email`),
                           KEY `FKsb0gm9wgivb6lcp3sm5gh2vt7` (`grupo_id`),
                           CONSTRAINT `FKsb0gm9wgivb6lcp3sm5gh2vt7` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `perito` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `data_atualizacao` datetime NOT NULL,
                          `data_cadastro` datetime NOT NULL,
                          `nome` varchar(100) NOT NULL,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `UK_lhqd4v28igxf5i3kq8vs0lnwr` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `dna` (
                       `id` bigint NOT NULL AUTO_INCREMENT,
                       `cpf` varchar(255) NOT NULL,
                       `data_atualizacao` datetime NOT NULL,
                       `data_cadastro` datetime NOT NULL,
                       `data_hora_da_coleta` datetime NOT NULL,
                       `data_nascimento` date NOT NULL,
                       `foto` varchar(255) DEFAULT NULL,
                       `gemeo` tinyint(1) DEFAULT '0',
                       `local_da_coleta` varchar(255) DEFAULT NULL,
                       `naturalidade` varchar(70) NOT NULL,
                       `nome` varchar(70) NOT NULL,
                       `nome_mae` varchar(70) NOT NULL,
                       `nome_pai` varchar(70) DEFAULT NULL,
                       `notas_gerais` longtext,
                       `rg` varchar(255) NOT NULL,
                       `sexo` varchar(255) NOT NULL,
                       `testemunha` varchar(60) NOT NULL,
                       `tipo_penal` varchar(255) NOT NULL,
                       `transfusionado` tinyint(1) DEFAULT '0',
                       `transplantado` tinyint(1) DEFAULT '0',
                       `unidade_federativa` varchar(255) DEFAULT NULL,
                       `unidade_prisional` varchar(255) DEFAULT NULL,
                       `dna_perito_id` bigint DEFAULT NULL,
                       PRIMARY KEY (`id`),
                       KEY `FKrgf9nmea0n4ye6bk27flysbpo` (`dna_perito_id`),
                       CONSTRAINT `FKrgf9nmea0n4ye6bk27flysbpo` FOREIGN KEY (`dna_perito_id`) REFERENCES `perito` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `genero_ocorrencia` (
                                     `id` bigint NOT NULL AUTO_INCREMENT,
                                     `codigo` varchar(10) NOT NULL,
                                     `data_atualizacao` datetime NOT NULL,
                                     `data_cadastro` datetime NOT NULL,
                                     `descricao` varchar(100) NOT NULL,
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `especie_ocorrencia` (
                                      `id` bigint NOT NULL AUTO_INCREMENT,
                                      `data_atualizacao` datetime NOT NULL,
                                      `data_cadastro` datetime NOT NULL,
                                      `descricao` varchar(100) NOT NULL,
                                      `subcodigo` varchar(10) NOT NULL,
                                      `genero_ocorrencia_id` bigint DEFAULT NULL,
                                      PRIMARY KEY (`id`),
                                      KEY `FKfhwk6ko7i1wyse1hhbnw84if8` (`genero_ocorrencia_id`),
                                      CONSTRAINT `FKfhwk6ko7i1wyse1hhbnw84if8` FOREIGN KEY (`genero_ocorrencia_id`) REFERENCES `genero_ocorrencia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `setor` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `data_atualizacao` datetime NOT NULL,
                         `data_cadastro` datetime NOT NULL,
                         `nome` varchar(60) NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




CREATE TABLE `ocorrencia` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `data_atualizacao` datetime NOT NULL,
                              `data_cadastro` datetime NOT NULL,
                              `data_hora_registro_ocorrencia` datetime NOT NULL,
                              `data_ocorrencia` date NOT NULL,
                              `endereco_bairro` varchar(255) DEFAULT NULL,
                              `endereco_cep` varchar(255) DEFAULT NULL,
                              `cidade` varchar(255) DEFAULT NULL,
                              `complemento` varchar(255) DEFAULT NULL,
                              `endereco_latitude` double DEFAULT NULL,
                              `endereco_logradouro` varchar(255) DEFAULT NULL,
                              `endereco_longitude` double DEFAULT NULL,
                              `endereco_numero` varchar(255) DEFAULT NULL,
                              `notas_gerais` longtext NOT NULL,
                              `numero_da_requisicao` varchar(12) DEFAULT NULL,
                              `numero_do_procedimento` varchar(12) DEFAULT NULL,
                              `origem` varchar(255) DEFAULT NULL,
                              `procedimento` varchar(255) DEFAULT NULL,
                              `autoridade_id` bigint NOT NULL,
                              `especie_id` bigint NOT NULL,
                              `perito_id` bigint NOT NULL,
                              `setor_id` bigint NOT NULL,
                              `unidade_id` bigint NOT NULL,
                              `usuario_id` bigint NOT NULL,
                              PRIMARY KEY (`id`),
                              KEY `FKmq78u2mhhnpyqj9867y8efxkx` (`autoridade_id`),
                              KEY `FKihlo2ycwqwl62381jkra74oyf` (`especie_id`),
                              KEY `FKm8tsqrt7uypdigjr3xvnyh25n` (`perito_id`),
                              KEY `FKj1ejv71ha4c31n1vx6gvhgdqo` (`setor_id`),
                              KEY `FK28xaixkw2vtf1dayn5m3nsc3a` (`unidade_id`),
                              KEY `FK8vyx5i6two7max2jhlodwew57` (`usuario_id`),
                              CONSTRAINT `FK28xaixkw2vtf1dayn5m3nsc3a` FOREIGN KEY (`unidade_id`) REFERENCES `unidade` (`id`),
                              CONSTRAINT `FK8vyx5i6two7max2jhlodwew57` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
                              CONSTRAINT `FKihlo2ycwqwl62381jkra74oyf` FOREIGN KEY (`especie_id`) REFERENCES `especie_ocorrencia` (`id`),
                              CONSTRAINT `FKj1ejv71ha4c31n1vx6gvhgdqo` FOREIGN KEY (`setor_id`) REFERENCES `setor` (`id`),
                              CONSTRAINT `FKm8tsqrt7uypdigjr3xvnyh25n` FOREIGN KEY (`perito_id`) REFERENCES `perito` (`id`),
                              CONSTRAINT `FKmq78u2mhhnpyqj9867y8efxkx` FOREIGN KEY (`autoridade_id`) REFERENCES `autoridade` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `historico` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `ordens_servicos_reiteradas` int DEFAULT NULL,
                             `upload_laudo` varchar(255) DEFAULT NULL,
                             `data_atualizacao` datetime NOT NULL,
                             `data_cadastro` datetime NOT NULL,
                             `data_entrega_do_laudo` datetime NOT NULL,
                             `notas_gerais` longtext NOT NULL,
                             `remessa` datetime(6) DEFAULT NULL,
                             `situacao_da_ocorrencia` varchar(255) DEFAULT NULL,
                             `ocorrencia_id` bigint NOT NULL,
                             PRIMARY KEY (`id`),
                             KEY `FKbplgupi8ow4k5qpxbr7gnyl85` (`ocorrencia_id`),
                             CONSTRAINT `FKbplgupi8ow4k5qpxbr7gnyl85` FOREIGN KEY (`ocorrencia_id`) REFERENCES `ocorrencia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `historico_usuario` (
                                     `historico_id` bigint NOT NULL,
                                     `usuario_id` bigint NOT NULL,
                                     KEY `FKb6bi8rjm7i5kqcdgx0hpwoil6` (`usuario_id`),
                                     KEY `FK6oflj5uafngju5b81a9b6ys7u` (`historico_id`),
                                     CONSTRAINT `FK6oflj5uafngju5b81a9b6ys7u` FOREIGN KEY (`historico_id`) REFERENCES `historico` (`id`),
                                     CONSTRAINT `FKb6bi8rjm7i5kqcdgx0hpwoil6` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `ordem_servico` (
                                 `id` bigint NOT NULL AUTO_INCREMENT,
                                 `data_atualizacao` datetime NOT NULL,
                                 `data_cadastro` datetime NOT NULL,
                                 `data_da_ordem_de_servico` datetime NOT NULL,
                                 `data_do_recebimento_da_ordem_de_servico` datetime NOT NULL,
                                 `data_do_vencimento` datetime NOT NULL,
                                 `notas_gerais` longtext NOT NULL,
                                 `prazo_em_dias` int NOT NULL,
                                 `quantidade_de_reiteracoes` int NOT NULL,
                                 `upload_requisicao` varchar(255) DEFAULT NULL,
                                 `ocorrencia_id` bigint NOT NULL,
                                 `perito_id` bigint NOT NULL,
                                 PRIMARY KEY (`id`),
                                 KEY `FKmgu9x53fchteucu1711ggt90j` (`ocorrencia_id`),
                                 KEY `FKqr4qh502wenrha2x9jolvgsqy` (`perito_id`),
                                 CONSTRAINT `FKmgu9x53fchteucu1711ggt90j` FOREIGN KEY (`ocorrencia_id`) REFERENCES `ocorrencia` (`id`),
                                 CONSTRAINT `FKqr4qh502wenrha2x9jolvgsqy` FOREIGN KEY (`perito_id`) REFERENCES `perito` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `ordem_servico_usuario` (
                                         `ordem_servico_id` bigint NOT NULL,
                                         `usuario_id` bigint NOT NULL,
                                         KEY `FK50dt1y7m4mv5b0j7mg4lov4wf` (`usuario_id`),
                                         KEY `FK98k7b0ypsfjexyod4aveu1d8k` (`ordem_servico_id`),
                                         CONSTRAINT `FK50dt1y7m4mv5b0j7mg4lov4wf` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
                                         CONSTRAINT `FK98k7b0ypsfjexyod4aveu1d8k` FOREIGN KEY (`ordem_servico_id`) REFERENCES `ordem_servico` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



