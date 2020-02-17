
drop table Especie cascade;

Create table Especie ( 
	NomeE varchar(30),
	Classe varchar(20), 

	primary key (NomeE)
);


insert into Especie values ('Foca', 'Mamifero');
insert into Especie values ('Leão Marinho', 'Mamifero');
insert into Especie values ('Lontra', 'Mamifero');
insert into Especie values ('Tigre', 'Mamifero');
insert into Especie values ('Tartaruga', 'Reptil');
insert into Especie values ('Lagartixa', 'Reptil');
insert into Especie values ('Lagarto', 'Reptil');
insert into Especie values ('Papagaio', 'Ave');
insert into Especie values ('Arara', 'Ave');		
insert into Especie values ('Crocodilo', 'Reptil');
insert into Especie values ('Girafa', 'Mamifero');
insert into Especie values ('Elefante', 'Mamifero');
insert into Especie values ('Kiwi', 'Ave');



drop table Animal cascade;

Create table Animal ( 
	 NomeA varchar(15),
	 Genero varchar(10),
	 NomeE varchar(30),

	 primary key (NomeA),
	 foreign key (NomeE) references Especie on delete restrict
);

insert into Animal values ('Kiki', 'Feminino', 'Foca');
insert into Animal values ('Lola', 'Feminino', 'Foca');
insert into Animal values ('Anibal', 'Masculino', 'Leão Marinho');
insert into Animal values ('Amelia', 'Feminino', 'Lontra');
insert into Animal values ('Eusebio', 'Masculino', 'Lontra');
insert into Animal values ('Jau', 'Masculino', 'Tigre');
insert into Animal values ('Princesa', 'Feminino', 'Tigre');	
insert into Animal values ('Huga', 'Feminino', 'Tartaruga');
insert into Animal values ('Luna', 'Feminino', 'Tartaruga');
insert into Animal values ('Brava', 'Feminino', 'Lagartixa');
insert into Animal values ('Raul', 'Masculino', 'Lagarto');
insert into Animal values ('Pirata', 'Masculino', 'Papagaio');
insert into Animal values ('Bela', 'Feminino', 'Papagaio');
insert into Animal values ('Joia', 'Feminino', 'Arara');
insert into Animal values ('Brutus', 'Masculino', 'Crocodilo');
insert into Animal values ('Brutina', 'Feminino', 'Crocodilo');
insert into Animal values ('Cesar', 'Masculino', 'Crocodilo');
insert into Animal values ('Antonieta', 'Feminino', 'Girafa');
insert into Animal values ('Artyom', 'Masculino', 'Girafa');
insert into Animal values ('Vlad', 'Masculino', 'Elefante');
insert into Animal values ('Kumigango', 'Masculino', 'Elefante');
insert into Animal values ('Chimichanga', 'Feminino', 'Elefante');
insert into Animal values ('Castanha', 'Feminino', 'Kiwi');


drop table Compartimento cascade;

Create table Compartimento (
	 IdComp char(10),
	 Tipo varchar(10),

	 primary key (IdComp)
);

insert into Compartimento values ('23','charco');
insert into Compartimento values ('10', 'selva');
insert into Compartimento values ('8', 'pantano');
insert into Compartimento values ('15', 'gaiola');
insert into Compartimento values ('6', 'Savana');
insert into Compartimento values ('12', 'Rio');

drop table Tratador cascade;
 
Create table Tratador (
	NCC char(10),
	NomeT varchar(15),
	Salario integer,
	NCCChefe char(10),

	primary key (NCC)
);

insert into Tratador values ('123', 'Manuel', 750, 'Luís');
insert into Tratador values ('124', 'Luís', 850, Null);
insert into Tratador values ('125', 'Maria', 850, 'Luís');
insert into Tratador values ('126', 'Massas', 1950, Null);
insert into Tratador values ('127', 'Ana', 2000, Null);

drop table Alojado cascade;

Create table Alojado (
	 NomeA varchar(15),
	 IdComp char(10),

	 foreign key (NomeA) references Animal on delete restrict,
	 foreign key (IdComp) references Compartimento on delete restrict
);

insert into Alojado values ('Kiki', '23');
insert into Alojado values ('Lola', '23');
insert into Alojado values ('Anibal', '23');
insert into Alojado values ('Amelia', '23');
insert into Alojado values ('Eusebio', '23');
insert into Alojado values ('Jau', '10');
insert into Alojado values ('Princesa', '10');
insert into Alojado values ('Huga', '8');
insert into Alojado values ('Luna', '8');
insert into Alojado values ('Brava', '8');
insert into Alojado values ('Raul', '8');
insert into Alojado values ('Pirata', '15');
insert into Alojado values ('Bela', '15');
insert into Alojado values ('Joia', '15');
insert into Alojado values ('Brutus', '12');
insert into Alojado values ('Brutina', '12');
insert into Alojado values ('Cesar', '12');
insert into Alojado values ('Antonieta','6');
insert into Alojado values ('Artyom', '6');
insert into Alojado values ('Vlad', '6');
insert into Alojado values ('Kumigango', '6');
insert into Alojado values ('Chimichanga', '6');
insert into Alojado values ('Castanha', '15');


drop table Trata cascade;

Create table Trata (
	 IdComp char(10),
	 NCC char(10),


	 foreign key (IdComp) references Compartimento on delete restrict,
	 foreign key (NCC) references Tratador on delete restrict
);

insert into Trata values ('23', '123');
insert into Trata values ('10', '123');
insert into Trata values ('10', '124');
insert into Trata values ('8', '124');
insert into Trata values ('15', '125');
insert into Trata values ('8', '125');
insert into Trata values ('6', '127');
insert into Trata values ('12', '126');

