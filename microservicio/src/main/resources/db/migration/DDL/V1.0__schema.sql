create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 fecha_creacion DATE not null,
 primary key (id)
);

create table pelicula (
 id int(11) not null auto_increment,
 titulo varchar(255) not null,
 director varchar(255) not null,
 primary key (id)
);

create table horario (
 id int(11) not null auto_increment,
 idPelicula int(11) not null,
 fecha DATE not null,
 cupos int(50) not null,
 primary key (id),
 foreign key (idPelicula) references pelicula (id)
);

create table reserva (
 id int(11) not null auto_increment,
 idHorario int(11) not null,
 idUsuario int(11) not null,
 primary key (id),
 foreign key (idHorario) references horario (id),
 foreign key (idUsuario) references usuario (id)
);





