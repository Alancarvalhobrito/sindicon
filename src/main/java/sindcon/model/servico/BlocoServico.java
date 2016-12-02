package sindcon.model.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sindcon.model.persistencia.entidade.Bloco;
import sindcon.model.persistencia.repositorio.BlocoRepositorio;

@Service
public class BlocoServico {
    @Autowired
    BlocoRepositorio blocoRepositorio;

    //GET
    public Iterable<Bloco> consultarBlocos() {
        return blocoRepositorio.findAll();
    }

    //Post
    public void inserirBloco(Bloco bloco) {
        blocoRepositorio.save(bloco);
    }

    //PUT
    public void atualizarBloco(Bloco bloco) throws Exception {
        if (bloco.getIdBloco() == null) {
            throw new Exception("Não foi possível atualizar um bloco com Id nulo.");
        }
        blocoRepositorio.save(bloco);
    }

    //DELETE
    public void apagarBloco(Integer idBloco) {
        blocoRepositorio.delete(idBloco);
    }
}