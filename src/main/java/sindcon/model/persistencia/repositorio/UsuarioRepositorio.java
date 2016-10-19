package sindcon.model.persistencia.repositorio;

import org.springframework.data.repository.CrudRepository;
import sindcon.model.persistencia.entidade.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {

}