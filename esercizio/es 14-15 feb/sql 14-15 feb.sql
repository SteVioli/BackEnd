CREATE TABLE IF NOT EXISTS Evento (
    id_evento serial NOT NULL PRIMARY KEY,
    titolo_evento character varying NOT NULL,
    data_evento time with time zone NOT NULL DEFAULT 'NOW()',
    --tipo_evento character varying NOT NULL,
    tipo_evento character varying NOT null,
	descrizione_evento character varying NOT NULL,
    maxppl_evento integer NOT NULL
);

CREATE TABLE IF NOT EXISTS Persona(
    id serial NOT NULL PRIMARY KEY,
    nome character varying NOT NULL,
    cognome character varying NOT NULL,
    email character varying NOT NULL,
    data_nascita character varying NOT NULL,
    sesso character varying NOT NULL,
    lista_partecipazioni character varying NOT NULL
);
CREATE TABLE IF NOT EXISTS Luogo(
    id_location serial NOT NULL PRIMARY KEY ,
    nome character varying NOT NULL,
    citta character varying NOT NULL,
    CONSTRAINT id_location_FK FOREIGN KEY (id_location) REFERENCES Evento (id_evento)      
);

CREATE TABLE IF NOT EXISTS Partecipazione(
    id_partecipazione serial NOT NULL PRIMARY KEY,
    "Persona" character varying NOT NULL,
    "Evento" character varying NOT NULL,
    stato_partecipazione character varying NOT NULL,

  CONSTRAINT id_partecipazione_FK  FOREIGN KEY (id_partecipazione) REFERENCES Persona (id)
);


