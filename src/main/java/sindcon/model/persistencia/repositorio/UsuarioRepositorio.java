package sindcon.model.persistencia.repositorio;

import org.springframework.data.repository.CrudRepository;
import sindcon.model.persistencia.entidade.Usuario;

/**
 * Created by Thiago on 24/09/2016.
 */
public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {

}