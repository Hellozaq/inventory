CREATE TABLE person (
id BIGINT (20) PRIMARY KEY,
name VARCHAR(50) NOT NULL,
mail VARCHAR (50) NOT NULL,
password VARCHAR(150) NOT NULL
);

CREATE TABLE permission (
	id BIGINT(20) PRIMARY KEY,
	description VARCHAR(50) NOT NULL
);

CREATE TABLE person_permission (
	id_person BIGINT(20) NOT NULL,
	id_permission BIGINT(20) NOT NULL,
	PRIMARY KEY (id_person, id_permission),
	FOREIGN KEY (id_person) REFERENCES person(id),
	FOREIGN KEY (id_permission) REFERENCES permission(id)
);
INSERT INTO person (id, name, mail, password) values (1, 'Administrateur', 'admin@gmail.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO person (id, name, mail, password) values (2, 'Maria Silva', 'maria@gmail.com', '$2a$10$Zc3w6HyuPOPXamaMhh.PQOXvDnEsadztbfi6/RyZWJDzimE8WQjaq');
INSERT INTO person (id, name, mail, password) values (3, 'Miria Fassarella', 'miria@fassarella.dev', '$2a$10$31NHI9xEps83R6CvbIeml.6YRmMwBOVfvoXPcAYyTaOL8CNXlAeJO');
INSERT INTO person (id, name, mail, password) values (4, 'Leonardo da Silva', 'leosilva@gmail.com', '$2a$10$fXTIoEyJNEcc5muRy9pl3eKwAw13IapXrNxOYkL3/sOgYF2wxIUGq');


INSERT INTO permission (id, description) values (1, 'ROLE_CADASTRAR_CATEGORIA');
INSERT INTO permission (id, description) values (2, 'ROLE_PESQUISAR_CATEGORIA');

INSERT INTO permission (id, description) values (3, 'ROLE_CADASTRAR_PESSOA');
INSERT INTO permission (id, description) values (4, 'ROLE_REMOVER_PESSOA');
INSERT INTO permission (id, description) values (5, 'ROLE_PESQUISAR_PESSOA');

INSERT INTO permission (id, description) values (6, 'ROLE_REGISTER_PRODUCT');
INSERT INTO permission (id, description) values (7, 'ROLE_DELETE_PRODUCT');
INSERT INTO permission (id, description) values (8, 'ROLE_SEARCH_PRODUCT');
INSERT INTO permission (id, description) values (9, 'ROLE_UPDATE_PRODUCT');

-- admin
INSERT INTO person_permission (id_person, id_permission) values (1, 1);
INSERT INTO person_permission (id_person, id_permission) values (1, 2);
INSERT INTO person_permission (id_person, id_permission) values (1, 3);
INSERT INTO person_permission (id_person, id_permission) values (1, 4);
INSERT INTO person_permission (id_person, id_permission) values (1, 5);
INSERT INTO person_permission (id_person, id_permission) values (1, 6);
INSERT INTO person_permission (id_person, id_permission) values (1, 7);
INSERT INTO person_permission (id_person, id_permission) values (1, 8);
INSERT INTO person_permission (id_person, id_permission) values (1, 9);


-- maria
INSERT INTO person_permission (id_person, id_permission) values (2, 2);
INSERT INTO person_permission (id_person, id_permission) values (2, 5);
INSERT INTO person_permission (id_person, id_permission) values (2, 8);

-- miria
INSERT INTO person_permission (id_person, id_permission) values (3, 8);