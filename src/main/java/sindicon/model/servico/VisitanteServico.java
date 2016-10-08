package sindicon.model.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sindicon.model.persistencia.entidade.Visitante;
import sindicon.model.persistencia.repositorio.VisitanteRepositorio;

/**
 * Created by Thiago on 08/10/2016.
 */
@Service
public class VisitanteServico {
    @Autowired
    VisitanteRepositorio visitanteRepositorio;

    //GET
    public Iterable<Visitante> consultarVisitantes() {
        return visitanteRepositorio.findAll();
    }

    //Post
    public void inserirVisitante(Visitante visitante) {
        visitanteRepositorio.save(visitante);
    }


    //PUT - (GetIdPessoa ou getIdVisitante)
    public void atualizarVisitante(Visitante visitante) throws Exception {
        if (visitante.getIdPessoa() == null) {
            throw new Exception("Não foi possível atualizar um visitante com Id nulo.");
        }
        visitanteRepositorio.save(visitante);
    }

    //DELETE
    public void apagarVisitante(Visitante visitante) {
        visitanteRepositorio.delete(visitante);
    }
}