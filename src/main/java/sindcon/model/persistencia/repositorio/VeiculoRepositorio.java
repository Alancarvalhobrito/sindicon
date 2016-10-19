package sindcon.model.persistencia.repositorio;

import org.springframework.data.repository.CrudRepository;
import sindcon.model.persistencia.entidade.Veiculo;

public interface VeiculoRepositorio extends CrudRepository<Veiculo, Integer> {

}