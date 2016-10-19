package sindcon.model.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sindcon.model.persistencia.entidade.Acesso;
import sindcon.model.persistencia.repositorio.AcessoRepositorio;

@Service
public class AcessoServico {
    @Autowired
    AcessoRepositorio acessoRepositorio;

    //GET
    public Iterable<Acesso> consultarAcessos() {
        return acessoRepositorio.findAll();
    }

    //Post
    public void inserirAcesso(Acesso acesso) {
        acessoRepositorio.save(acesso);
    }

    //PUT
    public void atualizarAcesso(Acesso acesso) throws Exception {
        if (acesso.getIdAcesso() == null) {
            throw new Exception("Não foi possível atualizar um acesso com Id nulo.");
        }
        acessoRepositorio.save(acesso);
    }

    //DELETE
    public void apagarAcesso(Acesso acesso) {
        acessoRepositorio.delete(acesso);
    }
}