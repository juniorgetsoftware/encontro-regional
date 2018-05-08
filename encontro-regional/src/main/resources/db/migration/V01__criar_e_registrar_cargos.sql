CREATE TABLE cargo (
	id BIGINT(20) NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	descricao VARCHAR(250),
	ativo BOOLEAN NOT NULL,
	data_cadastro DATE NOT NULL,
PRIMARY KEY (id),
UNIQUE KEY UK_cargo_nome (nome)
)ENGINE=InnoDB default CHARSET=utf8;

CREATE INDEX cargo_nome_index ON cargo(nome);

INSERT INTO cargo(id, ativo, data_cadastro, nome, descricao) VALUES (1, true, '2018-05-01', 'Pastor', 'Descrição do cargo eclesiástico');
INSERT INTO cargo(id, ativo, data_cadastro, nome, descricao) VALUES (2, true, '2018-05-01', 'Evangelista', 'Descrição do cargo eclesiástico');
INSERT INTO cargo(id, ativo, data_cadastro, nome, descricao) VALUES (3, true, '2018-05-01', 'Presbítero', 'Descrição do cargo eclesiástico');
INSERT INTO cargo(id, ativo, data_cadastro, nome, descricao) VALUES (4, true, '2018-05-01', 'Diácono', 'Descrição do cargo eclesiástico');
INSERT INTO cargo(id, ativo, data_cadastro, nome, descricao) VALUES (5, true, '2018-05-01', 'Missionário', 'Descrição do cargo eclesiástico');
INSERT INTO cargo(id, ativo, data_cadastro, nome, descricao) VALUES (6, true, '2018-05-01', 'Membro', 'Descrição do cargo eclesiástico');
INSERT INTO cargo(id, ativo, data_cadastro, nome, descricao) VALUES (7, true, '2018-05-01', 'Dirigente de congregação', 'Descrição do cargo eclesiástico');