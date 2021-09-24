create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 fecha_creacion datetime null,
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

--Datos para Test

--Tabla Usuario
insert into usuario(nombre,fecha_creacion) values('anderson','2022-03-03');--1
insert into usuario(nombre,fecha_creacion) values('ana','2021-09-30');--2
insert into usuario(nombre,fecha_creacion) values('maria',now());--3
insert into usuario(nombre,fecha_creacion) values('tatiana',now());--4
insert into usuario(nombre,fecha_creacion) values('mildrey',now());--5
--Datos para eliminar :: no usar para otra cosa
----------------------------------------------------------------------------------------
insert into usuario(nombre,fecha_creacion) values('golum',now());--6
insert into usuario(nombre,fecha_creacion) values('boldemord',now());--7
insert into usuario(nombre,fecha_creacion) values('miEx',now());--8
----------------------------------------------------------------------------------------

--Tabla Pelicula
insert into pelicula(titulo, director) values('Matrix','Tom');--1
insert into pelicula(titulo, director) values('Lluvia de Hamburguesas','Juan');--2
insert into pelicula(titulo, director) values('Shaft','Carlos');--3
insert into pelicula(titulo, director) values('Gran Apuesta','Miriam');--4
insert into pelicula(titulo, director) values('Corto de alguien','Juliana');--5
--Datos para eliminar:: no usar para otra cosa
----------------------------------------------------------------------------------------
insert into pelicula(titulo, director) values('Rapido y Furioso 1','No se quien');--6
insert into pelicula(titulo, director) values('Rapido y Furioso 2','No se quien');--7
insert into pelicula(titulo, director) values('Rapido y Furioso 3','No se quien');--8
----------------------------------------------------------------------------------------

--Tabla Horario
insert into horario(idPelicula, fecha, cupos) values(1, '2021-10-10', 60);--1
insert into horario(idPelicula, fecha, cupos) values(3, '2021-10-10', 50);--2
insert into horario(idPelicula, fecha, cupos) values(2, '2021-10-10', 80);--3
insert into horario(idPelicula, fecha, cupos) values(4, '2021-10-10', 60);--4
insert into horario(idPelicula, fecha, cupos) values(5, '2021-10-10', 50);--5
insert into horario(idPelicula, fecha, cupos) values(1, '2021-09-24', 80);--6
--Datos para eliminar:: no usar para otra cosa
----------------------------------------------------------------------------------------
insert into horario(idPelicula, fecha, cupos) values(1, '2020-09-24', 20);--7
insert into horario(idPelicula, fecha, cupos) values(2, now(), 30);--8
insert into horario(idPelicula, fecha, cupos) values(3, now(), 80);--9
----------------------------------------------------------------------------------------


--Tabla Reserva
insert into reserva(idUsuario, idHorario) values(1, 1);--1
insert into reserva(idUsuario, idHorario) values(3, 2);--2
insert into reserva(idUsuario, idHorario) values(2, 3);--3
insert into reserva(idUsuario, idHorario) values(3, 4);--4
insert into reserva(idUsuario, idHorario) values(4, 5);--5
insert into reserva(idUsuario, idHorario) values(5, 6);--6
insert into reserva(idUsuario, idHorario) values(4, 1);--7
insert into reserva(idUsuario, idHorario) values(2, 7);--8
--Datos para eliminar:: no usar para otra cosa
----------------------------------------------------------------------------------------
insert into reserva(idUsuario, idHorario) values(3, 3);--9
insert into reserva(idUsuario, idHorario) values(3, 8);--10
insert into reserva(idUsuario, idHorario) values(4, 4);--11
----------------------------------------------------------------------------------------


