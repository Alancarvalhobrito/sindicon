package sindcon.model.persistencia.repositorio;

import org.springframework.data.repository.CrudRepository;
import sindcon.model.persistencia.entidade.Morador;

import java.util.List;

public interface MoradorRepositorio extends CrudRepository<Morador, Integer> {
  List<Morador> findByNome (String nome);
}
