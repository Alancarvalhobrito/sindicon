package sindicon.model.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sindicon.model.persistencia.entidade.MoradorUnidade;
import sindicon.model.persistencia.repositorio.MoradorUnidadeRepositorio;

/**
 * Created by Thiago on 08/10/2016.
 */
@Service
public class MoradorUnidadeServico {
    @Autowired
    MoradorUnidadeRepositorio moradorUnidadeRepositorio;

    //GET
    public Iterable<MoradorUnidade> consultarMoradoresUnidades() {
        return moradorUnidadeRepositorio.findAll();
    }

    //Post
    public void inserirMoradorUnidade(MoradorUnidade moradorUnidade) {
        moradorUnidadeRepositorio.save(moradorUnidade);
    }

    //PUT
    public void atualizarMoradorUnidade(MoradorUnidade moradorUnidade) throws Exception {
        if (moradorUnidade.getIdMoradorUnidade() == null) {
            throw new Exception("Não foi possível atualizar um moradorUnidade com Id nulo.");
        }
        moradorUnidadeRepositorio.save(moradorUnidade);
    }

    //DELETE
    public void apagarMoradorUnidade(MoradorUnidade moradorUnidade) {
        moradorUnidadeRepositorio.delete(moradorUnidade);
    }
}