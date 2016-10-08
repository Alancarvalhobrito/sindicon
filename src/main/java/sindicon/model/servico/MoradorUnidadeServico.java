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

    //GET(Accesses)
    public Iterable<MoradorUnidade> consultarMoradorUnidade() {
        return moradorUnidadeRepositorio.findAll();
    }

    //Post(Accesses)
    public void inserirMoradorUnidade(MoradorUnidade moradorUnidade) {
        moradorUnidadeRepositorio.save(moradorUnidade);
    }

    //PUT(Accesses)
    public void atualizarMoradorUnidade(MoradorUnidade moradorUnidade) throws Exception {
        if (moradorUnidade.getIdMoradorUnidade() == null) {
            throw new Exception("Não foi possível atualizar um moradorUnidade com Id nulo.");
        }
        moradorUnidadeRepositorio.save(moradorUnidade);
    }

    //DELETE(Accesses)
    public void apagarMoradorUnidade(MoradorUnidade moradorUnidade) {
        moradorUnidadeRepositorio.delete(moradorUnidade);
    }
}