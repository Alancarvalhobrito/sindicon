package sindicon.model.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sindicon.model.persistencia.entidade.Veiculo;
import sindicon.model.persistencia.repositorio.VeiculoRepositorio;

/**
 * Created by Thiago on 08/10/2016.
 */
@Service
public class VeiculoServico {
    @Autowired
    VeiculoRepositorio veiculoRepositorio;

    //GET(Accesses)
    public Iterable<Veiculo> consultarVeiculo() {
        return veiculoRepositorio.findAll();
    }

    //Post(Accesses)
    public void inserirVeiculo(Veiculo veiculo) {
        veiculoRepositorio.save(veiculo);
    }

    //PUT(Accesses)
    public void atualizarVeiculo(Veiculo veiculo) throws Exception {
        if (veiculo.getIdVeiculo() == null) {
            throw new Exception("Não foi possível atualizar um veiculo com Id nulo.");
        }
        veiculoRepositorio.save(veiculo);
    }

    //DELETE(Accesses)
    public void apagarVeiculo(Veiculo veiculo) {
        veiculoRepositorio.delete(veiculo);
    }
}