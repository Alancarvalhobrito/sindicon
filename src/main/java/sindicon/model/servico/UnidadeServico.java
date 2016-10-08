package sindicon.model.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sindicon.model.persistencia.entidade.Unidade;
import sindicon.model.persistencia.repositorio.UnidadeRepositorio;

/**
 * Created by Thiago on 08/10/2016.
 */
@Service
public class UnidadeServico {
    @Autowired
    UnidadeRepositorio unidadeRepositorio;

    //GET(Accesses)
    public Iterable<Unidade> consultarUnidade() {
        return unidadeRepositorio.findAll();
    }

    //Post(Accesses)
    public void inserirUnidade(Unidade unidade) {
        unidadeRepositorio.save(unidade);
    }

    //PUT(Accesses)
    public void atualizarUnidade(Unidade unidade) throws Exception {
        if (unidade.getIdUnidade() == null) {
            throw new Exception("Não foi possível atualizar um unidade com Id nulo.");
        }
        unidadeRepositorio.save(unidade);
    }

    //DELETE(Accesses)
    public void apagarUnidade(Unidade unidade) {
        unidadeRepositorio.delete(unidade);
    }
}