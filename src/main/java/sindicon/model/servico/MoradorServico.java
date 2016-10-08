package sindicon.model.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sindicon.model.persistencia.entidade.Morador;
import sindicon.model.persistencia.repositorio.MoradorRepositorio;

/**
 * Created by Thiago on 08/10/2016.
 */
@Service
public class MoradorServico {
    @Autowired
    MoradorRepositorio moradorRepositorio;

    //GET(Accesses)
    public Iterable<Morador> consultarMorador() {
        return moradorRepositorio.findAll();
    }

    //Post(Accesses)
    public void inserirMorador(Morador morador) {
        moradorRepositorio.save(morador);
    }


    //PUT(Accesses) - (GetIdPessoa ou getIdMorador)
    public void atualizarMorador(Morador morador) throws Exception {
        if (morador.getIdPessoa() == null) {
            throw new Exception("Não foi possível atualizar um morador com Id nulo.");
        }
        moradorRepositorio.save(morador);
    }

    //DELETE(Accesses)
    public void apagarMorador(Morador morador) {
        moradorRepositorio.delete(morador);
    }
}