CREATE TABLE CLUB (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    NOMBRE VARCHAR(20) NOT NULL,
    FECFUNDACION DATE,
    CONSTRAINT ID_CLUB_PK PRIMARY KEY (ID)
);

CREATE TABLE JUGADORES (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY, -- Id autonumérico
    NOMBRE VARCHAR(20) NOT NULL,
    APELLIDOS VARCHAR(40) NOT NULL,
    NACIONALIDAD VARCHAR (20),
    VALOR DECIMAL(7,2),
    FOTO VARCHAR (50),
    DISPONIBLE BOOLEAN,
    CLUB INTEGER NOT NULL,
    CONSTRAINT ID_JUGADORES_PK PRIMARY KEY (ID),
    CONSTRAINT CLUB_JUGADORES_FK FOREIGN KEY (CLUB) REFERENCES CLUB (ID)
);
