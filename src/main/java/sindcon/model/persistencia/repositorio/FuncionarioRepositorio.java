package sindcon.model.persistencia.repositorio;

import org.springframework.data.repository.CrudRepository;
import sindcon.model.persistencia.entidade.Funcionario;
import sindcon.model.persistencia.entidade.Morador;

import java.util.List;

public interface FuncionarioRepositorio extends CrudRepository<Funcionario, Integer> {
    List<Funcionario> findByNome (String nome);
}