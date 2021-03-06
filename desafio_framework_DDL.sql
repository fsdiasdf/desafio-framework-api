-- DROP SCHEMA desafio_framework;

CREATE SCHEMA desafio_framework AUTHORIZATION postgres;

-- DROP SEQUENCE desafio_framework.tb_album_id_album_seq;

CREATE SEQUENCE desafio_framework.tb_album_id_album_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE desafio_framework.tb_album_id_album_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE desafio_framework.tb_album_id_album_seq TO postgres;

-- DROP SEQUENCE desafio_framework.tb_comentario_id_comentario_seq;

CREATE SEQUENCE desafio_framework.tb_comentario_id_comentario_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE desafio_framework.tb_comentario_id_comentario_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE desafio_framework.tb_comentario_id_comentario_seq TO postgres;

-- DROP SEQUENCE desafio_framework.tb_imagem_id_imagem_seq;

CREATE SEQUENCE desafio_framework.tb_imagem_id_imagem_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE desafio_framework.tb_imagem_id_imagem_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE desafio_framework.tb_imagem_id_imagem_seq TO postgres;

-- DROP SEQUENCE desafio_framework.tb_link_id_link_seq;

CREATE SEQUENCE desafio_framework.tb_link_id_link_seq
	NO MINVALUE
	NO MAXVALUE;

-- Permissions

ALTER SEQUENCE desafio_framework.tb_link_id_link_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE desafio_framework.tb_link_id_link_seq TO postgres;

-- DROP SEQUENCE desafio_framework.tb_post_id_post_seq;

CREATE SEQUENCE desafio_framework.tb_post_id_post_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE desafio_framework.tb_post_id_post_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE desafio_framework.tb_post_id_post_seq TO postgres;

-- DROP SEQUENCE desafio_framework.tb_usuario_id_usuario_seq;

CREATE SEQUENCE desafio_framework.tb_usuario_id_usuario_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;

-- Permissions

ALTER SEQUENCE desafio_framework.tb_usuario_id_usuario_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE desafio_framework.tb_usuario_id_usuario_seq TO postgres;
-- desafio_framework.tb_usuario definition

-- Drop table

-- DROP TABLE desafio_framework.tb_usuario;

CREATE TABLE desafio_framework.tb_usuario (
	id_usuario int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	ds_nome varchar(50) NOT NULL,
	nm_usuario varchar(20) NOT NULL,
	ds_senha varchar(100) NOT NULL,
	CONSTRAINT pk_usuario PRIMARY KEY (id_usuario)
);
COMMENT ON TABLE desafio_framework.tb_usuario IS 'Tabela respons??vel pelo armazenamento do cadastro do usu??rio';

-- Permissions

ALTER TABLE desafio_framework.tb_usuario OWNER TO postgres;
GRANT ALL ON TABLE desafio_framework.tb_usuario TO postgres;


-- desafio_framework.tb_album definition

-- Drop table

-- DROP TABLE desafio_framework.tb_album;

CREATE TABLE desafio_framework.tb_album (
	id_album int4 NOT NULL GENERATED ALWAYS AS IDENTITY, -- Identificador do registro na tabela
	id_usuario int4 NOT NULL, -- Identificador do usu??rio que criou o ??lbum
	ds_titulo varchar NOT NULL, -- T??tulo do ??lbum
	dt_criacao timestamp NULL, -- Data da cria????o do ??lbum
	CONSTRAINT tb_album_pk PRIMARY KEY (id_album),
	CONSTRAINT tb_album_fk FOREIGN KEY (id_usuario) REFERENCES desafio_framework.tb_usuario(id_usuario)
);

-- Column comments

COMMENT ON COLUMN desafio_framework.tb_album.id_album IS 'Identificador do registro na tabela';
COMMENT ON COLUMN desafio_framework.tb_album.id_usuario IS 'Identificador do usu??rio que criou o ??lbum';
COMMENT ON COLUMN desafio_framework.tb_album.ds_titulo IS 'T??tulo do ??lbum';
COMMENT ON COLUMN desafio_framework.tb_album.dt_criacao IS 'Data da cria????o do ??lbum';

-- Permissions

ALTER TABLE desafio_framework.tb_album OWNER TO postgres;
GRANT ALL ON TABLE desafio_framework.tb_album TO postgres;


-- desafio_framework.tb_imagem definition

-- Drop table

-- DROP TABLE desafio_framework.tb_imagem;

CREATE TABLE desafio_framework.tb_imagem (
	id_imagem int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	id_usuario int4 NOT NULL,
	bn_imagem bytea NOT NULL, -- Armazena bytes da imagem
	CONSTRAINT tb_imagens_pk PRIMARY KEY (id_imagem),
	CONSTRAINT tb_imagens_fk FOREIGN KEY (id_usuario) REFERENCES desafio_framework.tb_usuario(id_usuario)
);

-- Column comments

COMMENT ON COLUMN desafio_framework.tb_imagem.bn_imagem IS 'Armazena bytes da imagem';

-- Permissions

ALTER TABLE desafio_framework.tb_imagem OWNER TO postgres;
GRANT ALL ON TABLE desafio_framework.tb_imagem TO postgres;


-- desafio_framework.tb_imagem_album definition

-- Drop table

-- DROP TABLE desafio_framework.tb_imagem_album;

CREATE TABLE desafio_framework.tb_imagem_album (
	id_imagem int4 NOT NULL, -- Identificador da imagem vinculada ao ??lbum
	id_album int4 NOT NULL, -- Identificador do ??lbum
	CONSTRAINT tb_imagem_album_fk FOREIGN KEY (id_imagem) REFERENCES desafio_framework.tb_imagem(id_imagem),
	CONSTRAINT tb_imagem_album_imagem_fk FOREIGN KEY (id_album) REFERENCES desafio_framework.tb_album(id_album)
);
COMMENT ON TABLE desafio_framework.tb_imagem_album IS 'Tabela respons??vel por armazenar o v??nculo entre a imagem e os ??lbuns';

-- Column comments

COMMENT ON COLUMN desafio_framework.tb_imagem_album.id_imagem IS 'Identificador da imagem vinculada ao ??lbum';
COMMENT ON COLUMN desafio_framework.tb_imagem_album.id_album IS 'Identificador do ??lbum';

-- Permissions

ALTER TABLE desafio_framework.tb_imagem_album OWNER TO postgres;
GRANT ALL ON TABLE desafio_framework.tb_imagem_album TO postgres;


-- desafio_framework.tb_post definition

-- Drop table

-- DROP TABLE desafio_framework.tb_post;

CREATE TABLE desafio_framework.tb_post (
	id_post int4 NOT NULL GENERATED ALWAYS AS IDENTITY, -- identificador da postagem
	id_usuario int4 NOT NULL,
	tx_post text NULL,
	ds_titulo varchar NOT NULL, -- T??tulo da postagem
	dh_publicacao timestamp NOT NULL, -- Armazena a data e hora da publica????o do Post
	ds_link varchar NULL, -- Armazena um link informado no momento do post
	CONSTRAINT tb_post_pk PRIMARY KEY (id_post),
	CONSTRAINT tb_post_fk FOREIGN KEY (id_usuario) REFERENCES desafio_framework.tb_usuario(id_usuario)
);
COMMENT ON TABLE desafio_framework.tb_post IS 'Tabela respons??vle por guardar informa????es sobre a postagem realizada pelo autor';

-- Column comments

COMMENT ON COLUMN desafio_framework.tb_post.id_post IS 'identificador da postagem';
COMMENT ON COLUMN desafio_framework.tb_post.ds_titulo IS 'T??tulo da postagem';
COMMENT ON COLUMN desafio_framework.tb_post.dh_publicacao IS 'Armazena a data e hora da publica????o do Post';
COMMENT ON COLUMN desafio_framework.tb_post.ds_link IS 'Armazena um link informado no momento do post';

-- Permissions

ALTER TABLE desafio_framework.tb_post OWNER TO postgres;
GRANT ALL ON TABLE desafio_framework.tb_post TO postgres;


-- desafio_framework.tb_usuario_roles definition

-- Drop table

-- DROP TABLE desafio_framework.tb_usuario_roles;

CREATE TABLE desafio_framework.tb_usuario_roles (
	id_usuario int4 NOT NULL,
	ds_role varchar NOT NULL,
	CONSTRAINT tb_usuario FOREIGN KEY (id_usuario) REFERENCES desafio_framework.tb_usuario(id_usuario)
);
COMMENT ON TABLE desafio_framework.tb_usuario_roles IS 'Respons??vel por guardar informa????es do v??nculo entre usu??rio e sua ROLE ';

-- Permissions

ALTER TABLE desafio_framework.tb_usuario_roles OWNER TO postgres;
GRANT ALL ON TABLE desafio_framework.tb_usuario_roles TO postgres;


-- desafio_framework.tb_comentario definition

-- Drop table

-- DROP TABLE desafio_framework.tb_comentario;

CREATE TABLE desafio_framework.tb_comentario (
	id_comentario int4 NOT NULL GENERATED ALWAYS AS IDENTITY, -- Identificador do coment??rio
	id_post int4 NOT NULL, -- Identificador do post onde est?? sendo feito o coment??rio
	ds_comentario varchar NOT NULL, -- Descri????o do coment??rio
	id_autor_comentario int4 NOT NULL, -- Autor do coment??rio
	dh_publicacao timestamp NOT NULL, -- Armazena a data e hora da cria????o do coment??rio
	CONSTRAINT tb_comentario_pk PRIMARY KEY (id_comentario),
	CONSTRAINT tb_comentario_fk FOREIGN KEY (id_post) REFERENCES desafio_framework.tb_post(id_post)
);
COMMENT ON TABLE desafio_framework.tb_comentario IS 'Respons??vel por armazenar os coment??rios feitos em cada Post';

-- Column comments

COMMENT ON COLUMN desafio_framework.tb_comentario.id_comentario IS 'Identificador do coment??rio';
COMMENT ON COLUMN desafio_framework.tb_comentario.id_post IS 'Identificador do post onde est?? sendo feito o coment??rio';
COMMENT ON COLUMN desafio_framework.tb_comentario.ds_comentario IS 'Descri????o do coment??rio';
COMMENT ON COLUMN desafio_framework.tb_comentario.id_autor_comentario IS 'Autor do coment??rio';
COMMENT ON COLUMN desafio_framework.tb_comentario.dh_publicacao IS 'Armazena a data e hora da cria????o do coment??rio';

-- Permissions

ALTER TABLE desafio_framework.tb_comentario OWNER TO postgres;
GRANT ALL ON TABLE desafio_framework.tb_comentario TO postgres;


-- desafio_framework.tb_imagem_post definition

-- Drop table

-- DROP TABLE desafio_framework.tb_imagem_post;

CREATE TABLE desafio_framework.tb_imagem_post (
	id_imagem int4 NOT NULL, -- Identificador da imagem no Post
	id_post int4 NOT NULL, -- Identificador do Post
	CONSTRAINT tb_imagem_post_fk FOREIGN KEY (id_imagem) REFERENCES desafio_framework.tb_imagem(id_imagem),
	CONSTRAINT tb_imagem_post_fk_1 FOREIGN KEY (id_post) REFERENCES desafio_framework.tb_post(id_post)
);
COMMENT ON TABLE desafio_framework.tb_imagem_post IS 'Tabela respons??vel por armazenar o v??nculo de uma imagem a um post';

-- Column comments

COMMENT ON COLUMN desafio_framework.tb_imagem_post.id_imagem IS 'Identificador da imagem no Post';
COMMENT ON COLUMN desafio_framework.tb_imagem_post.id_post IS 'Identificador do Post';

-- Permissions

ALTER TABLE desafio_framework.tb_imagem_post OWNER TO postgres;
GRANT ALL ON TABLE desafio_framework.tb_imagem_post TO postgres;




-- Permissions

GRANT ALL ON SCHEMA desafio_framework TO postgres;
