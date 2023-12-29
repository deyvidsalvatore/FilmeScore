CREATE TABLE tb_movie(
	id INT8 AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255),
    contador INT4,
    imagem VARCHAR(255),
    score FLOAT8
);

CREATE TABLE tb_user(
	id INT8 PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255)
);

CREATE TABLE tb_score (
	usuario_id INT8 NOT NULL,
	filme_id INT8 NOT NULL,
	valor FLOAT8,
    PRIMARY KEY (filme_id, usuario_id),
	FOREIGN KEY (filme_id) REFERENCES tb_movie(id),
    FOREIGN KEY (usuario_id) REFERENCES tb_user(id)
);