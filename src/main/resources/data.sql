-- ROLES
INSERT INTO role VALUES('ROLE_USER')
ON DUPLICATE KEY UPDATE name = 'ROLE_USER';	
	
INSERT INTO role VALUES('ROLE_ADMIN')
ON DUPLICATE KEY UPDATE name = 'ROLE_ADMIN';
-- /ROLES

-- CATEGORIES 
INSERT INTO category VALUES(1, 'Salgados feitos com massa por isso é massa', 'Massa')
ON DUPLICATE KEY UPDATE idCategory = 1;

INSERT INTO category VALUES(2, 'Carne com sangue, sangue mesmo, muito sangue, vermelho!', 'Carne')
ON DUPLICATE KEY UPDATE idCategory = 2;

INSERT INTO category VALUES(3, 'Causa diabetes, mata, assassina a alma bem rapido', 'Doce')
ON DUPLICATE KEY UPDATE idCategory = 3;
-- /CATEGORIES