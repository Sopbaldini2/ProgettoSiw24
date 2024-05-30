insert into evento (id, nome, tipologia, data, descrizione, prezzo) values(nextval('evento_seq'), 'Sinfonia delle Stelle', 'Festival', '10-08-2024' ,'concerto sotto il cielo stellato', 70);
insert into evento (id, nome, tipologia, data, descrizione, prezzo) values(nextval('evento_seq'), 'Serata enigmatica','Cena con spettacolo', '07-12-1022','un viaggio nel mistero', 50);
insert into evento (id, nome, tipologia, data, descrizione, prezzo) values(nextval('evento_seq'), 'Conferenza delle menti brillanti','Fiera', '24-02-2016','condivisione di conoscenze e idee innovative', 60);
insert into evento (id, nome, tipologia, data, descrizione, prezzo) values(nextval('evento_seq'), 'Avventura nelle nuvole','Sfide verticali', '18-06-2023','esperienza estrema di paracadutismo', 90);
insert into evento (id, nome, tipologia, data, descrizione, prezzo) values(nextval('evento_seq'), 'Mostra dei sapori del Mondo','Evento culinario', '27-04-2013', 'celebrazione delle diversità gastronomiche globali', 80);
insert into evento (id, nome, tipologia, data, descrizione, prezzo) values(nextval('evento_seq'), 'Giornata della Gioia','Festival', '01-01-2021','festa della musica e del benessere', 70);
insert into evento (id, nome, tipologia, data, descrizione, prezzo) values(nextval('evento_seq'), 'Notte dei Racconti Incantati','Evento sociale', '15-08-2024', 'serata di narrazioni e fantasia', 40);


insert into dipendente (id, nome, cognome, email, telefono) VALUES (nextval('dipendente_seq'), 'Alessandro', 'Abete', 'alessandroabete@gmail.com', '3335678902');
insert into dipendente (id, nome, cognome, email, telefono) values(nextval('dipendente_seq'), 'Martina', 'Bartolini', 'martinabartolini@gmail.com', '3456673498');
insert into dipendente (id, nome, cognome, email, telefono) values(nextval('dipendente_seq'), 'Asia', 'Bianchi', 'asiabianchi@gmail.com', '3485678879');
insert into dipendente (id, nome, cognome, email, telefono) values(nextval('dipendente_seq'), 'Rachele', 'Paddeo', 'rachelepaddeo@gmail.com', '3466568870');
insert into dipendente (id, nome, cognome, email, telefono) values(nextval('dipendente_seq'), 'Riccardo', 'gaffi', 'riccardogaffi@gmial.com', '3778900987');
insert into dipendente (id, nome, cognome, email, telefono) values(nextval('dipendente_seq'), 'Francesco', 'Bavaro', 'francescobavaro@gmail.com', '3890345234');
insert into dipendente (id, nome, cognome, email, telefono) values(nextval('dipendente_seq'), 'Sabrina', 'Mancini', 'sabrinamancini@gmail.com', '3875442134');

insert into servizio (id, nome, descrizione, prezzo) VALUES (nextval('servizio_seq'), 'Audio/Video', 'Installazione e gestione di attrezzature audio e video', 400);
insert into servizio (id, nome, descrizione, prezzo) values(nextval('servizio_seq'), 'Fotografia', 'Cattura di momenti speciali attraverso foto e video.', 300);
insert into servizio (id, nome, descrizione, prezzo) values(nextval('servizio_seq'), 'Intrattenimento', 'Artisti, musicisti, DJ, animatori e spettacoli per intrattenere gli ospiti.', 2000);
insert into servizio (id, nome, descrizione, prezzo) values(nextval('servizio_seq'), 'Catering e Ristorazione', 'Fornitura di cibo e bevande per gli ospiti.', 1500);
insert into servizio (id, nome, descrizione, prezzo) values(nextval('servizio_seq'), 'Allestimenti e Design', 'Creazione di ambienti, scenografie e allestimenti personalizzati per l’evento.', 1000);

INSERT INTO cliente (id, nome, cognome, email, telefono) VALUES (nextval('cliente_seq'), 'Mario', 'Rossi', 'mario.rossi@example.com', '1234567890');
INSERT INTO cliente (id, nome, cognome, email, telefono) VALUES (nextval('cliente_seq'), 'Giulia', 'Bianchi', 'giulia.bianchi@example.com', '0987654321');

INSERT INTO Recensione (id, commento, voto, cliente_id) VALUES (nextval('recensione_seq'), 'Ottimo evento!', 5, 1);
INSERT INTO Recensione (id, commento, voto, cliente_id) VALUES (nextval('recensione_seq'), 'Buona esperienza', 4, 51);
