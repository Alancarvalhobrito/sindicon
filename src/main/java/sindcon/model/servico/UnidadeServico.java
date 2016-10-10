package sindcon.model.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sindcon.model.persistencia.entidade.Unidade;
import sindcon.model.persistencia.repositorio.UnidadeRepositorio;

/**
 * Created by Thiago on 08/10/2016.
 */
@Service
public class UnidadeServico {
    @Autowired
    UnidadeRepositorio unidadeRepositorio;

    //GET
    public Iterable<Unidade> consultarUnidades() {
        return unidadeRepositorio.findAll();
    }

    //Post
    public void inserirUnidade(Unidade unidade) {
        unidadeRepositorio.save(unidade);
    }

    //PUT
    public void atualizarUnidade(Unidade unidade) throws Exception {
        if (unidade.getIdUnidade() == null) {
            throw new Exception("Não foi possível atualizar um unidade com Id nulo.");
        }
        unidadeRepositorio.save(unidade);
    }

    //DELETE
    public void apagarUnidade(Unidade unidade) {
        unidadeRepositorio.delete(unidade);
    }
}