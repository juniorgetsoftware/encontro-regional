CREATE TABLE cargo (
	id BIGINT(20) NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	descricao VARCHAR(250),
PRIMARY KEY (id),
UNIQUE KEY UK_nome_cargo (nome)
)ENGINE=InnoDB default CHARSET=utf8;

INSERT INTO cargo(id, nome, descricao) VALUES (1, 'Pastor', 'Descrição do cargo eclesiástico');
INSERT INTO cargo(id, nome, descricao) VALUES (2, 'Evangelista', 'Descrição do cargo eclesiástico');
INSERT INTO cargo(id, nome, descricao) VALUES (3, 'Presbítero', 'Descrição do cargo eclesiástico');
INSERT INTO cargo(id, nome, descricao) VALUES (4, 'Diácono', 'Descrição do cargo eclesiástico');
INSERT INTO cargo(id, nome, descricao) VALUES (5, 'Missionário', 'Descrição do cargo eclesiástico');
INSERT INTO cargo(id, nome, descricao) VALUES (6, 'Membro', 'Descrição do cargo eclesiástico');
INSERT INTO cargo(id, nome, descricao) VALUES (7, 'Dirigente de congregação', 'Descrição do cargo eclesiástico');