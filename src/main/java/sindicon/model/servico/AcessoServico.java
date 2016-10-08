package sindicon.model.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sindicon.model.persistencia.entidade.Acesso;
import sindicon.model.persistencia.repositorio.AcessoRepositorio;

/**
 * Created by Thiago on 08/10/2016.
 */
@Service
public class AcessoServico {
    @Autowired
    AcessoRepositorio acessoRepositorio;

    //GET(Accesses)
    public Iterable<Acesso> consultarAcesso() {
        return acessoRepositorio.findAll();
    }

    //Post(Accesses)
    public void inserirAcesso(Acesso acesso) {
        acessoRepositorio.save(acesso);
    }

    //PUT(Accesses)
    public void atualizarAcesso(Acesso acesso) throws Exception {
        if (acesso.getIdAcesso() == null) {
            throw new Exception("Não foi possível atualizar um acesso com Id nulo.");
        }
        acessoRepositorio.save(acesso);
    }

    //DELETE(Accesses)
    public void apagarAcesso(Acesso acesso) {
        acessoRepositorio.delete(acesso);
    }
}