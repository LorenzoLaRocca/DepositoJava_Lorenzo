CREATE DATABASE IF NOT EXISTS hoteldb;
USE hoteldb;

CREATE TABLE utenti (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    cognome VARCHAR(50)
);

CREATE TABLE camere (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero INT,
    tipo VARCHAR(20)
);

CREATE TABLE prenotazioni (
    id INT AUTO_INCREMENT PRIMARY KEY,
    utente_id INT,
    camera_id INT,
    data_prenotazione DATE,
    FOREIGN KEY (utente_id) REFERENCES utenti(id),
    FOREIGN KEY (camera_id) REFERENCES camere(id)
);

INSERT INTO camere (numero, tipo) VALUES (101, 'Singola');
INSERT INTO camere (numero, tipo) VALUES (102, 'Doppia');
INSERT INTO camere (numero, tipo) VALUES (103, 'Matrimoniale');
INSERT INTO camere (numero, tipo) VALUES (104, 'Suite');
INSERT INTO camere (numero, tipo) VALUES (105, 'Doppia');