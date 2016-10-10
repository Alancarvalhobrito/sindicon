package sindcon.model.persistencia.repositorio;

import org.springframework.data.repository.CrudRepository;
import sindcon.model.persistencia.entidade.Acesso;

/**
 * Created by Thiago on 24/09/2016.
 */
public interface AcessoRepositorio extends CrudRepository<Acesso, Integer> {

}