package sindcon.model.persistencia.repositorio;

import org.springframework.data.repository.CrudRepository;
import sindcon.model.persistencia.entidade.Morador;

public interface MoradorRepositorio extends CrudRepository<Morador, Integer> {

}