DROP TABLE clienti;
DROP TABLE fatture;
DROP TABLE prodotti;
DROP TABLE fornitori;

CREATE TABLE IF NOT EXISTS clienti (
	numeroCliente SERIAL,
	nome VARCHAR NOT NULL,
	cognome VARCHAR NOT NULL,
	datanascita int8 NOT NULL,
	regioneresidenza VARCHAR NOT NULL,
	CONSTRAINT client_pk PRIMARY KEY (numeroCliente)
);

CREATE TABLE IF NOT EXISTS fatture(
	numerofattura SERIAL,
	tipologia VARCHAR NOT NULL,
	importo int8 NOT NULL,
	iva int8 NOT NULL,
	idcliente int8 NOT NULL,
	datafattura int8 NOT NULL,
	numerofornitore int8 not NULL,
	CONSTRAINT clienti_fk FOREIGN KEY (idcliente) REFERENCES clienti(numerocliente),
	CONSTRAINT fornitori_fk FOREIGN KEY (numerofornitore) REFERENCES fornitori(numerofornitore),
	CONSTRAINT fatture_pk PRIMARY KEY (numerofattura)
);
CREATE TABLE IF NOT EXISTS prodotti(
	idprodotto SERIAL,
	descrizione VARCHAR NOT NULL,
	inproduzione BOOLEAN NOT NULL,
	incommercio BOOLEAN NOT NULL,
	dataattivazione int8 NOT NULL,
	datadisattivazione int8 NOT NULL,
	CONSTRAINT prodotti_pk PRIMARY KEY (idprodotto)
);
CREATE TABLE IF NOT EXISTS fornitori(
	numerofornitore SERIAL,
	denominazione VARCHAR NOT NULL,
	regioneresidenza VARCHAR NOT NULL,
	CONSTRAINT fornitori_pk PRIMARY KEY (numerofornitore)
);

INSERT INTO fornitori (denominazione,regioneresidenza) VALUES ('Decathlon','Bologna');
INSERT INTO fornitori (denominazione,regioneresidenza) VALUES ('Amazon','Piacenza');
INSERT INTO fornitori (denominazione,regioneresidenza) VALUES ('Coop','Modena');
INSERT INTO fornitori (denominazione,regioneresidenza) VALUES ('Conad','Imola');
INSERT INTO fornitori (denominazione,regioneresidenza) VALUES ('Lego','Milano');
INSERT INTO fornitori (denominazione,regioneresidenza) VALUES ('MangaWorld','Torino');


INSERT INTO prodotti (descrizione,inproduzione,incommercio,dataattivazione,datadisattivazione) VALUES ('Palla Calcio',TRUE,TRUE,1950,2030);
INSERT INTO prodotti (descrizione,inproduzione,incommercio,dataattivazione,datadisattivazione) VALUES ('Computer',TRUE,TRUE,2000,2030);
INSERT INTO prodotti (descrizione,inproduzione,incommercio,dataattivazione,datadisattivazione) VALUES ('Sdraio mare',FALSE,TRUE,1930,2025);
INSERT INTO prodotti (descrizione,inproduzione,incommercio,dataattivazione,datadisattivazione) VALUES ('Giacca',TRUE,TRUE,1980,2030);
INSERT INTO prodotti (descrizione,inproduzione,incommercio,dataattivazione,datadisattivazione) VALUES ('Tastiera PC',TRUE,TRUE,1990,2040);
INSERT INTO prodotti (descrizione,inproduzione,incommercio,dataattivazione,datadisattivazione) VALUES ('Bicicletta',TRUE,FALSE,2020,2040);
INSERT INTO prodotti (descrizione,inproduzione,incommercio,dataattivazione,datadisattivazione) VALUES ('LEGO CASUAL',TRUE,TRUE,2027,2040);

INSERT INTO clienti (nome,cognome,datanascita,regioneresidenza) VALUES ('Stefano','Violi',1987,'Emilia-Romagna');
INSERT INTO clienti (nome,cognome,datanascita,regioneresidenza) VALUES ('Fabio','Violi',1984,'Emilia-Romagna');
INSERT INTO clienti (nome,cognome,datanascita,regioneresidenza) VALUES ('Giulia','Bullo',1987,'Lombardia');
INSERT INTO clienti (nome,cognome,datanascita,regioneresidenza) VALUES ('Marco','Rossi',1999,'Toscana');
INSERT INTO clienti (nome,cognome,datanascita,regioneresidenza) VALUES ('Mirco','Pippo',1997,'Emilia-Romagna');
INSERT INTO clienti (nome,cognome,datanascita,regioneresidenza) VALUES ('Luca','Pippetti',1980,'Liguria');
INSERT INTO clienti (nome,cognome,datanascita,regioneresidenza) VALUES ('Mirco','Paperino',1974,'Toscana');


INSERT INTO fatture (numerofattura,tipologia,importo,iva,idcliente,datafattura,numerofornitore) VALUES (1,'Pagata',500,20,1,2000,1);
INSERT INTO fatture (numerofattura,tipologia,importo,iva,idcliente,datafattura,numerofornitore) VALUES (2,'A',300,20,2,2030,3);
INSERT INTO fatture (numerofattura,tipologia,importo,iva,idcliente,datafattura,numerofornitore) VALUES (3,'B',45,20,3,2025,1);
INSERT INTO fatture (numerofattura,tipologia,importo,iva,idcliente,datafattura,numerofornitore) VALUES (5,'A',200,20,4,2020,3);
INSERT INTO fatture (numerofattura,tipologia,importo,iva,idcliente,datafattura,numerofornitore) VALUES (6,'C',30,20,1,2015,2);
INSERT INTO fatture (numerofattura,tipologia,importo,iva,idcliente,datafattura,numerofornitore) VALUES (4,'A',10,20,2,2010,4);

SELECT nome,cognome FROM clienti WHERE datanascita > 1982;
SELECT numerofattura FROM fatture WHERE iva >= 20; 
SELECT COUNT (fatture.numerofattura) FROM fatture where iva >= 20;
--SELECT fatture.numerofattura, COUNT (fatture.importo) FROM fatture ORDER BY datafattura ASC;

SELECT descrizione , incommercio FROM prodotti  WHERE dataattivazione >= 2017;


