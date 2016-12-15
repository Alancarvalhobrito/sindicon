package sindcon.model.persistencia.repositorio;

import org.springframework.data.repository.CrudRepository;
import sindcon.model.persistencia.entidade.Visitante;

import java.util.List;

public interface VisitanteRepositorio extends CrudRepository<Visitante, Integer> {
    List<Visitante> findByNome (String nome);
}