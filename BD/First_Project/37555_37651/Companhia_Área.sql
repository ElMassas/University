DROP TABLE Aviões CASCADE;

CREATE TABLE Aviões (
	Nome varchar(40) PRIMARY KEY,
	Marca varchar(40) NOT NULL,
	Modelo varchar(40) NOT NULL,
	Autonomia integer CHECK (Autonomia > 0),
	Num_Lugares integer CHECK( Num_Lugares > 0),
);



DROP TABLE Funcionários CASCADE;

CREATE TABLE Funcionários (
	Nome varchar(40) NOT NULL,
	BI integer PRIMARY KEY,
	Nif integer NOT NULL UNIQUE,
	Anos_Exp integer NOT NULL CHECK ( Anos_Exp > 0),
	Data_Nascimento varchar(20) NOT NULL,
);



DROP TABLE Administradores CASCADE;

CREATE TABLE Administradores (
	Nif integer NOT NULL,
	FOREIGN KEY ( Nif ) REFERENCES Funcionários,
);



DROP TABLE Pilotos CASCADE;

CREATE TABLE Pilotos (
	Num_Carta integer NOT NULL PRIMARY KEY,
	Nif integer NOT NULL,
    FOREIGN KEY ( Nif ) REFERENCES Funcionários,
);



DROP TABLE Assitentes_Bordo CASCADE;

CREATE TABLE Assitentes_Bordo (
	Peso integer NOT NULL,
	Altura integer NOT NULL,
	Genero varchar (10) NOT NULL,
	Nif integer NOT NULL,

	FOREIGN KEY ( Nif) REFERENCES Funcionários
); 



DROP TABLE Voos_Efetivos CASCADE;

CREATE TABLE Voos_Efetivos (
 	hora_Chegada varchar(20) NOT NULL,
 	hora_Partida varchar(20) NULL NULL,
 	num_Passageiros integer NOT NULL UNIQUE,
 	num_Voo integer NOT NULL,

 	FOREIGN KEY (num_Voo) REFERENCES Voos_Regulares,	
);



DROP TABLE Voos_Regulares CASCADE;

CREATE TABLE Voos_Regulares (
	Origem varchar(40) NOT NULL,
	Destino varchar(40) NOT NULL,
	num_Voo integer PRIMARY KEY,
	num_Km integer NOT NULL CHECK ( num_Km > 0),
	hora_Partida_Prevista varchar(20) NOT NULL,
	hora_Chegada_Prevista varchar(20) NOT NULL,
	Dia varchar(20) NOT NULL,
);


DROP TABLE Tripulação CASCADE;

CREATE TABLE Tripulação ( 
	Anos_Exp integer NOT NULL;
	Peso integer NOT NULL;
	Altura integer NOT NULL;
	Nif integer NOT NULL UNIQUE,
	FOREIGN KEY ( Nif ) REFERENCES Funcionários; 	
);
