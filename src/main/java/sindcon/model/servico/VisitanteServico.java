package sindcon.model.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sindcon.model.persistencia.entidade.Visitante;
import sindcon.model.persistencia.repositorio.VisitanteRepositorio;

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
    public void apagarVisitante(Integer idVisitante) {
        visitanteRepositorio.delete(idVisitante);
    }
}