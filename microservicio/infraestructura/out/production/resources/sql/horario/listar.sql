select id,idPelicula,fecha, cupos
from horario
where fecha >= now()
ORDER BY id ASC