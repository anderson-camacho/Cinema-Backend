--Datos de Pruebas

--Tabla Usuario
insert into usuario(nombre,clave,fecha_creacion) values('anderson','1234',now());--1
insert into usuario(nombre,clave,fecha_creacion) values('ana','1234',now());--2
insert into usuario(nombre,clave,fecha_creacion) values('maria','1234',now());--3
insert into usuario(nombre,clave,fecha_creacion) values('tatiana','1234',now());--4
insert into usuario(nombre,clave,fecha_creacion) values('mildrey','1234',now());--5
--Datos para eliminar :: no usar para otra cosa
----------------------------------------------------------------------------------------
insert into usuario(nombre,clave,fecha_creacion) values('golum','1234',now());--6
insert into usuario(nombre,clave,fecha_creacion) values('boldemord','1234',now());--7
insert into usuario(nombre,clave,fecha_creacion) values('miEx','1234',now());--8
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
insert into horario(idPelicula, fecha, cupos) values(1, now(), 60);--1
insert into horario(idPelicula, fecha, cupos) values(3, now(), 50);--2
insert into horario(idPelicula, fecha, cupos) values(2, now(), 80);--3
insert into horario(idPelicula, fecha, cupos) values(4, now(), 60);--4
insert into horario(idPelicula, fecha, cupos) values(5, now(), 50);--5
insert into horario(idPelicula, fecha, cupos) values(1, now(), 80);--6
--Datos para eliminar:: no usar para otra cosa
----------------------------------------------------------------------------------------
insert into horario(idPelicula, fecha, cupos) values(1, now(), 20);--7
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
insert into reserva(idUsuario, idHorario) values(2, 3);--8
--Datos para eliminar:: no usar para otra cosa
----------------------------------------------------------------------------------------
insert into reserva(idUsuario, idHorario) values(3, 3);--9
insert into reserva(idUsuario, idHorario) values(3, 2);--10
insert into reserva(idUsuario, idHorario) values(4, 4);--11
----------------------------------------------------------------------------------------

