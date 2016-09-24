package sindicon.model.persistencia.repositorio;

import org.springframework.data.repository.CrudRepository;
import sindicon.model.persistencia.entidade.Usuario;

/**
 * Created by Thiago on 24/09/2016.
 */
public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {

}