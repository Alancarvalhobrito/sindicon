package sindcon.model.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sindcon.model.persistencia.entidade.Morador;
import sindcon.model.persistencia.repositorio.MoradorRepositorio;

@Service
public class MoradorServico {
    @Autowired
    MoradorRepositorio moradorRepositorio;

    //GET
    public Iterable<Morador> consultarMoradores() {
        return moradorRepositorio.findAll();
    }

    //Post
    public void inserirMorador(Morador morador) {
        moradorRepositorio.save(morador);
    }


    //PUT - (GetIdPessoa ou getIdMorador)
    public void atualizarMorador(Morador morador) throws Exception {
        if (morador.getIdPessoa() == null) {
            throw new Exception("Não foi possível atualizar um morador com Id nulo.");
        }
        moradorRepositorio.save(morador);
    }

    //DELETE
    public void apagarMorador(Integer idPessoa) {
        moradorRepositorio.delete(idPessoa);
    }
}
