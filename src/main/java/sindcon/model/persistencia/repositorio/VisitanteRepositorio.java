package sindcon.model.persistencia.repositorio;

import org.springframework.data.repository.CrudRepository;
import sindcon.model.persistencia.entidade.Visitante;

public interface VisitanteRepositorio extends CrudRepository<Visitante, Integer> {

}