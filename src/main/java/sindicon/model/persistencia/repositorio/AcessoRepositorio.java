package sindicon.model.persistencia.repositorio;

import org.springframework.data.repository.CrudRepository;
import sindicon.model.persistencia.entidade.Acesso;
import java.util.Date;
import java.util.List;

/**
 * Created by Thiago on 24/09/2016.
 */
public interface AcessoRepositorio extends CrudRepository<Acesso, Integer> {
    List<Acesso> findByDataEntrada(Date dataEntrada);
    List<Acesso> findByDataSaida(Date dataSaida);
}