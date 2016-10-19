package sindcon.model.persistencia.repositorio;

import org.springframework.data.repository.CrudRepository;
import sindcon.model.persistencia.entidade.Funcionario;

public interface FuncionarioRepositorio extends CrudRepository<Funcionario, Integer> {

}