
create database if not exists employees_management;

create table if not exists nazioni(
	iso varchar(3) not null,
	description varchar(20) not null,
	primary key (iso)
);

create table if not exists regioni(
	id_region int(7) auto_increment,
	description varchar(20) not null,
	iso_coun varchar(3),
	primary key (id_region),
	foreign key (iso_coun) references nazioni (iso)
);

create table if not exists province(
	id_prov varchar(3) not null,
	description varchar(20) not null,
	id_region int(7) not null,
	primary key (id_prov),
	foreign key (id_region) references regioni (id_region)
);

create table if not exists citta(
	id_city int(7) not null,
	description varchar(20) not null,
	id_prov varchar(3) not null,
	primary key (id_city),
	foreign key (id_prov) references province (id_prov)
);

create table if not exists dipendenti(
	id int(7) auto_increment,
	name varchar(15) not null,
	surname varchar(15) not null,
	taxcode varchar(15) not null,
	gender varchar(1) not null,
	address varchar(20) not null,
	city int(7) not null, 
	primary key (id),
	foreign key (city) references citta (id_city)
);

create table if not exists utente (
	name varchar(50) not null,
	password varchar(50) not null,
    role varchar(40),
    config json DEFAULT null,
    PRIMARY KEY (name)
);

use employees_management;
INSERT INTO `nazioni` VALUES ('FR','France'),('IT','Italy'),('US','USA');
INSERT INTO `regioni` VALUES (1,'Texas','US'),(4,'Alsazia','FR'),(5,'Campania','IT'),(6,'Veneto','IT');
INSERT INTO `province` VALUES ('NA','Napoli',5),('PD','Padova',6),('VI','Vicenza',6);
INSERT INTO `citta` VALUES (35043,'Monselice','PD'),(36100,'Vicenza','VI');
INSERT INTO `dipendenti` VALUES (null,'Pissio','Tullio','ABCGAYH131FIUSD','M','Via gigi 35',36100);
INSERT INTO `utente` values ('kappa', 'admin', 'admin');
