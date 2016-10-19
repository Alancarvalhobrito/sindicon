package sindcon.model.persistencia.repositorio;

import org.springframework.data.repository.CrudRepository;
import sindcon.model.persistencia.entidade.Pessoa;

public interface PessoaRepositorio extends CrudRepository<Pessoa, Integer> {

}