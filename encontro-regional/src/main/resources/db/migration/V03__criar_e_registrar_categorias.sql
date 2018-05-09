CREATE TABLE categoria (
	id BIGINT(20) NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	descricao VARCHAR(250),
	ativo BOOLEAN NOT NULL,
	data_cadastro DATE NOT NULL,
PRIMARY KEY (id),
UNIQUE KEY UK_categoria_nome (nome)
)ENGINE=InnoDB default CHARSET=utf8;

CREATE INDEX categoria_nome_index ON categoria(nome);

INSERT INTO categoria(id, ativo, data_cadastro, nome, descricao) VALUES (1, true, '2018-05-01', 'Material de escritório', 'Descrição da categoria');
INSERT INTO categoria(id, ativo, data_cadastro, nome, descricao) VALUES (2, true, '2018-05-01', 'Mercantil', 'Descrição da categoria');
INSERT INTO categoria(id, ativo, data_cadastro, nome, descricao) VALUES (3, true, '2018-05-01', 'Alimentação', 'Descrição da categoria');
INSERT INTO categoria(id, ativo, data_cadastro, nome, descricao) VALUES (4, true, '2018-05-01', 'Serviço bancário', 'Descrição da categoria');
INSERT INTO categoria(id, ativo, data_cadastro, nome, descricao) VALUES (5, true, '2018-05-01', 'Serviço de cozinha', 'Descrição da categoria');
INSERT INTO categoria(id, ativo, data_cadastro, nome, descricao) VALUES (6, true, '2018-05-01', 'Taxa de inscrição', 'Descrição da categoria');
INSERT INTO categoria(id, ativo, data_cadastro, nome, descricao) VALUES (7, true, '2018-05-01', 'Oferta', 'Descrição da categoria');