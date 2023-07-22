create database GoldenTicket;
use GoldenTicket;

#creazione tabella utenti
create table Utenti (
id int primary key auto_increment,
username varchar(50),
password varchar (16),
ruolo varchar (10)
);


INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('jtrusslove0', 'wU4\"%oplj', 'admin');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('gbignold1', 'dF6|Tua&hzmW', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('gdew2', 'qB6$oxg@Zc', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('cwhistlecraft1', 'nQ1`F_Ywk', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('alaskey5', 'xQ8~_xWj*', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('jwheaton9', 'iJ7(0~vxC', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('eingreeg', 'qB6oxg@Zc', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('ideverallo', 'iJ7(0~vxCcNu', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('sskylettn', 'dF6|Tua&hzmW', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('bdreakinc', '@1d7SL\\Iq', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('scoltarte', 'sW6#L\\Iq', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('debertzs', 'hI9.xHuKRF!<', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('fzamoranok', 'gA7,Hklpi', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('dblockm', 'wU4\"%h4)8$K', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('kdeavall5', 'HC,0q!yi', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('cdominichelli4', 'iJ7(0~vxCc', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('bnurcombe3', 'xQ8~_xWj*', 'admin');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('hwaltho8', 'qB6oxg@Z', 'admin');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('svamplew5', '7,HC,0q!', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('cwilbort', 'zB0(lpoa', 'admin');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('mferrilliog', 'xQ8~_xWj*', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('madicotr', 'zB0(W+Ny', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('cdonnellanm', 'B0W+Nywp', 'admin');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('psymsr', 'wU4\"h4)8l', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('tchadwickt', 'nQ1`F_YwSg*,', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('kleys0', 'zB0(W+Nyiopd', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('bskyppe8', 'dF6|Tua&hzmW', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('gocrowleyc', 'hI9.xKRF!<', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('sheliotj', 'iJ7(0xCcNu', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('mcreep', 'wU4\"%h4)8', 'loggato');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('alyless', 'nQ1_YwSg*,', 'admin');
INSERT INTO `GoldenTicket`.`Utenti` (`username`, `password`, `ruolo`) VALUES ('dbeeton3', '0(W+Nyosnd', 'loggato');


#creazione tabella localita
create table localita(
id int primary key auto_increment,
citta varchar(50),
zona varchar(20),
posti int,
indirizzo varchar (100));

drop table localita;


INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Ancona', 'Stadio del Conero', '22000', 'Via dei Rododendri 40');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Firenze', 'Teatro Verdi', '200', 'Via dei Tulipani 50');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Milano', 'Teatro la Scala', '400', 'Via dei Fiori 4');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Milano', 'Stadio San Siro', '70000', 'Via Garibaldi 50');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Roma', 'Stadio Olimpico', '50000', 'Via Tizio 2');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Genova', 'Museo del Mare', '1000', 'Via Boomer 5');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Verona', 'Museo Archeologico', '1000', 'Via Napoleone 13');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Verona', 'Stadio Bentegodi', '30000', 'Via Shakespeare 40');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Firenze', 'Teatro Puccini', '600', 'Via Ciro 7');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Venezia', 'Stadio Penzo', '10000', 'Via Esposito 7');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Como', 'Teatro sociale', '400', 'Via Rosario 8');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Lecco', 'Museo Archeologico', '800', 'Via Fiorello 80');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Catania', 'Museo Zoologia', '700', 'Via Nino Bixio 30');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Catania', 'Stadio Angelo', '19000', 'Via Bottiglia 10');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Palermo', 'Museo Palermo', '500', 'Via Borraccia 9');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Bari', 'Teatro Piccinni', '450', 'Via Matita 20');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Bologna', 'Teatro del Sole', '300', 'Via Portale 30');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Campobasso', 'Museo Misteri', '450', 'Via Mattone 9');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Brescia', 'Teatro Santa Chiara', '300', 'Via Garibaldi 12');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Brescia', 'Stadio Rigamonti', '10000', 'Via Napoleone 2');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Como', 'Museo della Seta', '250', 'Via Aristotele 20');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Cremona', 'Museo Civico', '300', 'Via Tutankhamon 50');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Perugia', 'Museo del Giocattolo', '350', 'Via Anassagora 8');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Assisi', 'Teatro Lyrick', '300', 'Via Anassimene 5');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Roma', 'Teatro Argentina', '400', 'Via Cilurzo 9');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Assisi', 'Museo Diocesano', '350', 'Via Breccia 8');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Como', 'Stadio Sinigaglia', '10000', 'Via Crostata 81');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Lecco', 'Stadio Rigamonti', '4000', 'Via Paolo Giovio 83');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Padova', 'Museo di Geografia', '300', 'Via Pino 49');
INSERT INTO `GoldenTicket`.`localita` (`citta`, `zona`, `posti`, `indirizzo`) VALUES ('Sondrio', 'Teatro sociale', '500', 'Via della Bresaola 58');



#tabella artisti
create table artisti (
id int primary key auto_increment,
nominativo varchar(100));

INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Vasco Rossi');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Fiorella Mannoia');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Rosario Fiorello');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Ultimo');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Milan');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Inter');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Juventus');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Como');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Lecco');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Max Angioni');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Pippo e Pluto');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Bugo');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('I Legnanesi');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Vanessa Incontrada');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Pio ed Amedeo');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Luca Ravenna');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Museo Archeologico');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Teatro sociale');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Teatro sociale');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Teatro del Sole');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Museo della Seta');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Museo Diocesano');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Museo di Geografia');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Museo Misteri');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Museo Palermo');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Museo Zoologia');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Museo Archeologico');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Museo del Mare');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Museo del Giocattolo');
INSERT INTO `GoldenTicket`.`artisti` (`nominativo`) VALUES ('Museo Civico');


#table eventi
create table eventi (
id int primary key AUTO_INCREMENT,
tipologia varchar(40),
genere varchar(30),
data date,
ora varchar(10),
giornoSettimana varchar (30),
locandina varchar (300),
idLocalita int,
foreign key (idLocalita) references localita(id) on update cascade on delete cascade);

#table associativa
create table associativa (
id int primary key auto_increment,
idArtista int,
idEvento int,
foreign key (idArtista) references artisti(id) on update cascade on delete cascade,
foreign key (idEvento) references eventi(id) on update cascade on delete cascade
);

INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Sport', 'Calcio', '2024-09-07', '20:30', 'Lunedì', 'https://cdn.skuola.net/news_foto/image-grabber/image-64621625e9ba2.jpg', '1');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Spettacolo', 'Commedia', '2024-07-26', '21:30', 'Domenica', 'https://www.studiarapido.it/wp-content/uploads/2016/04/commedia.jpg', '25');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Spettacolo', 'Commedia', '2024-11-13', '21:30', 'Mercoledì', 'https://www.studiarapido.it/wp-content/uploads/2016/04/commedia.jpg', '24');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Spettacolo', 'Commedia', '2024-09-07', '21:30', 'Lunedì', 'https://www.studiarapido.it/wp-content/uploads/2016/04/commedia.jpg', '3');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Visita guidata', 'Storico', '2024-11-13', '14:30', 'Lunedì', 'https://www.museoliberazione.it/media/filer_public_thumbnails/filer_public/9a/a8/9aa897bc-c7dd-40c5-a828-8c49c644cfbc/cella_1_fosse_ardeatine_risultato.jpg__3240x2160_q85_subsampling-2.jpg', '6');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Visita guidata', 'Storico', '2023-07-24', '14:30', 'Sabato', 'https://www.museoliberazione.it/media/filer_public_thumbnails/filer_public/9a/a8/9aa897bc-c7dd-40c5-a828-8c49c644cfbc/cella_1_fosse_ardeatine_risultato.jpg__3240x2160_q85_subsampling-2.jpg', '6');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Sport', 'Calcio', '2023-12-06', '14:30', 'Giovedì', 'https://cdn.skuola.net/news_foto/image-grabber/image-64621625e9ba2.jpg', '1');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Visita guidata', 'Storico', '2023-07-24', '14:30', 'Sabato', 'https://www.museoliberazione.it/media/filer_public_thumbnails/filer_public/9a/a8/9aa897bc-c7dd-40c5-a828-8c49c644cfbc/cella_1_fosse_ardeatine_risultato.jpg__3240x2160_q85_subsampling-2.jpg', '7');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Visita guidata', 'Storico', '2023-12-06', '13:30', 'Giovedì', 'https://www.museoliberazione.it/media/filer_public_thumbnails/filer_public/9a/a8/9aa897bc-c7dd-40c5-a828-8c49c644cfbc/cella_1_fosse_ardeatine_risultato.jpg__3240x2160_q85_subsampling-2.jpg', '12');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Visita guidata', 'Scientifico', '2023-12-06', '14:30', 'Giovedì', 'https://www.focusjunior.it/content/uploads/2022/06/musei-scientifici.jpg', '13');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Visita libera', 'Svago', '2023-07-24', '17:30', 'Sabato', 'https://www.artribune.com/wp-content/uploads/2020/06/Museo-del-Prado-sala-24.jpg', '15');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Visita libera', 'Svago', '2023-12-05', '17:30', 'Domenica', 'https://www.artribune.com/wp-content/uploads/2020/06/Museo-del-Prado-sala-24.jpg', '18');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Visita guidata', 'Storico', '2023-07-24', '13:30', 'Sabato', 'https://www.comune.pinerolo.to.it/web/images/immagini/pagine/turismo/Musei/Museo_Arma_Cav.jpg', '21');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Visita guidata', 'Storico', '2023-12-05', '17:30', 'Mercoledì', 'https://www.artribune.com/wp-content/uploads/2020/06/Museo-del-Prado-sala-24.jpg', '29');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Sport', 'Basket', '2023-08-17', '17:30', 'Martedì', 'https://i0.wp.com/www.linkiesta.it/wp-content/uploads/2020/03/c0633fee-21aa-47e6-b89e-de45d31d95a9_large.jpg?fit=1200%2C638&ssl=1', '1');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Sport', 'Pallavolo', '2023-08-17', '13:30', 'Sabato', 'https://www.uliveto.it/wp-content/uploads/2020/12/Uliveto-Articolo-Dec-Volleyred.png', '4');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Sport', 'Calcio', '2024-07-26', '13:30', 'Sabato', 'https://cdn.skuola.net/news_foto/image-grabber/image-64621625e9ba2.jpg', '5');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Sport', 'Basket', '2023-07-24', '17:30', 'Lunedì', 'https://i0.wp.com/www.linkiesta.it/wp-content/uploads/2020/03/c0633fee-21aa-47e6-b89e-de45d31d95a9_large.jpg?fit=1200%2C638&ssl=1', '14');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Sport', 'Pallavolo', '2024-07-26', '17:30', 'Martedì', 'https://www.uliveto.it/wp-content/uploads/2020/12/Uliveto-Articolo-Dec-Volleyred.png', '28');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Sport', 'Basket', '2024-07-26', '13:30', 'Sabato', 'https://i0.wp.com/www.linkiesta.it/wp-content/uploads/2020/03/c0633fee-21aa-47e6-b89e-de45d31d95a9_large.jpg?fit=1200%2C638&ssl=1', '27');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Sport', 'Pallavolo', '2024-11-13', '17:30', 'Mercoledì', 'https://www.uliveto.it/wp-content/uploads/2020/12/Uliveto-Articolo-Dec-Volleyred.png', '27');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Sport', 'Calcio', '2024-11-13', '11:30', 'Mercoledì', 'https://cdn.skuola.net/news_foto/image-grabber/image-64621625e9ba2.jpg', '1');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Sport', 'Calcio', '2023-12-06', '11:30', 'Giovedì', 'https://cdn.skuola.net/news_foto/image-grabber/image-64621625e9ba2.jpg', '10');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Spettacolo', 'Commedia', '2023-12-05', '19:30', 'Mercoledì', 'https://www.studiarapido.it/wp-content/uploads/2016/04/commedia.jpg', '2');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Spettacolo', 'Cabaret', '2023-12-06', '19:30', 'Lunedì', 'https://images.squarespace-cdn.com/content/v1/5dc085fcdab5d85fc866faec/7ebb852a-c145-4b6f-8472-850a53e80e3f/Cabaret+Face+Landscape+psd+copy+%281%29.png', '19');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Spettacolo', 'Cabaret', '2024-09-07', '19:30', 'Lunedì', 'https://images.squarespace-cdn.com/content/v1/5dc085fcdab5d85fc866faec/7ebb852a-c145-4b6f-8472-850a53e80e3f/Cabaret+Face+Landscape+psd+copy+%281%29.png', '9');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Spettacolo', 'Cabaret', '2023-07-24', '19:30', 'Sabato', 'https://images.squarespace-cdn.com/content/v1/5dc085fcdab5d85fc866faec/7ebb852a-c145-4b6f-8472-850a53e80e3f/Cabaret+Face+Landscape+psd+copy+%281%29.png', '11');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Spettacolo', 'Commedia', '2023-12-06', '19:30', 'Domenica', 'https://www.studiarapido.it/wp-content/uploads/2016/04/commedia.jpg', '16');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Concerto', 'Rock', '2023-07-24', '22:00', 'Domenica', 'https://www.virginradio.it/resizer/1200/720/true/1522324821926_1522324836.jpg--assistere_a_un_concerto_ogni_quindici_giorni_allunga_la_vita_di_nove_anni__scopri_i_risultati_della_ricerca_.jpg?1522324837541', '17');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Concerto', 'Pop', '2024-11-13', '22:00', 'Mercoledì', 'https://flawless.life/wp-content/uploads/2022/04/I-Concerti-da-non-perdere-in-primavera-a-Milano-cover.jpg', '30');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Concerto', 'Rock', '2023-12-06', '21:00', 'Giovedì', 'https://www.artribune.com/wp-content/uploads/2020/06/Museo-del-Prado-sala-24.jpg', '30');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Concerto', 'Rock', '2023-08-17', '20:00', 'Domenica', 'https://www.artribune.com/wp-content/uploads/2020/06/Museo-del-Prado-sala-24.jpg', '19');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Concerto', 'Pop', '2023-07-24', '22:00', 'Sabato', 'https://flawless.life/wp-content/uploads/2022/04/I-Concerti-da-non-perdere-in-primavera-a-Milano-cover.jpg', '17');
INSERT INTO `GoldenTicket`.`eventi` (`tipologia`, `genere`, `data`, `ora`, `giornoSettimana`, `locandina`, `idLocalita`) VALUES ('Concerto', 'Pop', '2024-09-07', '21:00', 'Lunedì', 'https://flawless.life/wp-content/uploads/2022/04/I-Concerti-da-non-perdere-in-primavera-a-Milano-cover.jpg', '30');


INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('1', '29');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('2', '30');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('4', '31');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('12', '32');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('1', '33');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('12', '34');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('5', '15');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('6', '15');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('5', '17');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('7', '17');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('7', '18');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('5', '18');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('6', '21');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('6', '22');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('5', '23');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('7', '7');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('6', '7');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('6', '16');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('5', '19');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('7', '20');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('7', '22');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('6', '23');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('5', '16');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('6', '1');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('5', '1');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('21', '5');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('21', '6');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('22', '8');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('23', '9');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('24', '10');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('25', '11');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('26', '12');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('27', '13');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('28', '14');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('29', '14');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('30', '10');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('10', '2');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('11', '3');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('13', '4');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('14', '2');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('15', '3');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('16', '4');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('20', '24');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('19', '25');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('18', '26');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('2', '27');
INSERT INTO `GoldenTicket`.`associativa` (`idArtista`, `idEvento`) VALUES ('4', '28');


#biglietti acquistati
create table bigliettiacquistati (
id int primary key AUTO_INCREMENT,
fila varchar(2),
posto int,
prezzo double,
dataEmissione date,
idUser int,
idEvento int,
foreign key (idUser) references utenti(id) on delete cascade on update cascade,
foreign key (idEvento) references eventi(id) on delete cascade on update cascade);


INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('B', '10', '100.50', '2022-03-16', '1', '29');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('B', '20', '200.99', '2022-03-20', '1', '34');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('B', '10', '100.0', '2022-03-18', '2', '28');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('A', '2', '400', '2022-03-16', '3', '29');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('A', '9', '23.0', '2022-05-22', '4', '5');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('C', '29', '80.99', '2022-03-16', '5', '24');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('C', '27', '80.99', '2022-06-20', '6', '2');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('A', '12', '49.0', '2022-03-16', '7', '6');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('A', '8', '49.0', '2022-03-05', '8', '6');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('C', '24', '80.99', '2022-06-08', '9', '15');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('A', '4', '80.99', '2022-10-08', '10', '21');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('C', '24', '80.99', '2022-06-08', '15', '21');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('C', '22', '100.80', '2022-12-08', '17', '4');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('A', '15', '49.0', '2022-06-15', '18', '14');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('C', '21', '70.88', '2022-05-19', '19', '23');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('B', '12', '49.0', '2022-04-20', '29', '8');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('B', '11', '80.99', '2022-03-19', '22', '7');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('C', '21', '80.99', '2022-02-15', '30', '1');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('D', '30', '80.99', '2022-01-03', '32', '18');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('D', '35', '120.90', '2022-10-19', '2', '19');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('C', '21', '80.09', '2022-07-16', '16', '20');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('A', '37', '49.0', '2022-07-17', '19', '12');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('C', '21', '59.99', '2022-03-19', '21', '28');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('F', '80', '150.0', '2022-02-07', '24', '29');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('F', '80', '150.0', '2022-09-04', '25', '34');
INSERT INTO `GoldenTicket`.`bigliettiacquistati` (`fila`, `posto`, `prezzo`, `dataEmissione`, `idUser`, `idEvento`) VALUES ('F', '80', '150.0', '2022-09-04', '27', '31');


#carrello
create table carrello (
id int primary key AUTO_INCREMENT,
fila varchar(2),
posto int,
prezzo double,
idUser int,
idEvento int,
foreign key (idUser) references utenti(id) on delete cascade on update cascade,
foreign key (idEvento) references eventi(id) on delete cascade on update cascade);


INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('D', '31', '100.00', '1', '29');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('F', '42', '50.88', '1', '4');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('G', '51', '100.00', '11', '2');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('G', '59', '100.00', '16', '2');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('F', '44', '50.88', '4', '3');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('F', '45', '120.00', '5', '23');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('H', '67', '100.99', '25', '32');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('H', '69', '110.00', '28', '32');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('H', '64', '105.00', '29', '33');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('D', '35', '120.00', '2', '29');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('H', '62', '130.00', '2', '33');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('F', '45', '50.88', '8', '28');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('A', '9', '30.99', '5', '9');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('A', '8', '30.99', '30', '9');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('A', '5', '30.99', '21', '10');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('A', '4', '30.99', '29', '11');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('A', '2', '30.99', '24', '12');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('F', '46', '100.30', '7', '28');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('G', '54', '99.10', '31', '28');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('A', '7', '90.0', '27', '12');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('F', '48', '30.90', '9', '25');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('G', '55', '40.99', '22', '8');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('G', '52', '40.99', '24', '8');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('A', '3', '30.99', '21', '12');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('F', '40', '110.99', '10', '24');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('D', '36', '100.00', '3', '28');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('G', '57', '80.79', '25', '28');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('A', '42', '70.99', '22', '7');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('B', '20', '99.99', '29', '23');
INSERT INTO `GoldenTicket`.`carrello` (`fila`, `posto`, `prezzo`, `idUser`, `idEvento`) VALUES ('B', '23', '50.88', '1', '8');
