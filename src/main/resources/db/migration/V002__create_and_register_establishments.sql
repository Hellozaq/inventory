CREATE TABLE establishment (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR (100) NOT NULL,
	enumber VARCHAR(5) NOT NULL,
	id_sector BIGINT (20) NOT NULL,
    FOREIGN KEY (id_sector) REFERENCES sector(id)
);

INSERT INTO establishment(name, enumber, id_sector) VALUES ('École de la Feuille-d’Or', '071', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École de la Rose-des-Vents', '078', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École de la Source', '072', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École de la Voie-Lactée', '074', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École de Saint-Romain', '089', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École de Sainte-Cécile', '082', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École des Monts-Blancs', '086', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École des Monts-et-Lacs', '075', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École des Sommets', '081', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École d’Audet', '084', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Notre-Dame-de-Fatima', '079', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Sacré-Cœur', '092', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('Centre de services Lac-Mégantic - 098', '098', 3);

INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Saint Camille', '051', 1);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École du Parchemin Côté Couvent', '047', 1);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École du Parchemin Côté Collège', '048', 1);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Notre-Dame du Paradis', '067', 1);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Notre-Dame du Sacré Coeur', '068', 1);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École des Trois Cantons', '058', 1);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Notre-Dame de Lorette', '063', 1);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Saint Paul', '055', 1);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('Siège social - 099', '099', 1);

INSERT INTO establishment(name, enumber, id_sector) VALUES ('École de Ligugé', '016', 2);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École de Sainte-Edwidge', '015', 2);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Gendreau', '014', 2);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Louis-Saint-Laurent', '017', 2);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Monseigneur-Durand', '018', 2);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Sacré-Cœur', '032', 2);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Saint-Pie-X', '034', 2);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Sancta-Maria', '036', 2);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Monseigneur-Durand', '038', 2);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Notre-Dame-de-Toutes-Aides', '035', 2);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('Centre de services Coaticook - 097', '097', 2);


