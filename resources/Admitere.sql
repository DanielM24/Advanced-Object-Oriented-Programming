CREATE TABLE `Facultati` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(45) DEFAULT NULL,
  `adresa` varchar(45) DEFAULT NULL,
  `numar_total_locuri` int(11) DEFAULT NULL,
  `numar_specializari` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--- insert facultate

INSERT INTO `admitere`.`facultati`
(
`nume`,
`adresa`,
`numar_total_locuri`,
`numar_specializari`)
VALUES
(
'Limbi-Străine',
'Pitar-Mos',
'35',
'2');

