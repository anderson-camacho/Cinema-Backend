insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());
insert into pelicula(titulo, director) values('Maria','Anderson');
insert into pelicula(titulo, director) values('Depre','Camacho');
insert into horario(idPelicula, fecha, cupos) values(1, now(), 60);
insert into horario(idPelicula, fecha, cupos) values(1, now(), 50);
insert into horario(idPelicula, fecha, cupos) values(1, now(), 80);