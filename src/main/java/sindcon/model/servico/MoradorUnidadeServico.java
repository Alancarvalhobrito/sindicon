package sindcon.model.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sindcon.model.persistencia.entidade.MoradorUnidade;
import sindcon.model.persistencia.repositorio.MoradorUnidadeRepositorio;

@Service
public class MoradorUnidadeServico {
    @Autowired
    MoradorUnidadeRepositorio moradorUnidadeRepositorio;

    //GET
    public Iterable<MoradorUnidade> consultarMoradoresUnidades() {
        return moradorUnidadeRepositorio.findAll();
    }

    //Post
    public void inserirMoradorUnidade(MoradorUnidade moradorUnidade) {
        moradorUnidadeRepositorio.save(moradorUnidade);
    }

    //PUT
    public void atualizarMoradorUnidade(MoradorUnidade moradorUnidade) throws Exception {
        if (moradorUnidade.getIdMoradorUnidade() == null) {
            throw new Exception("Não foi possível atualizar um moradorUnidade com Id nulo.");
        }
        moradorUnidadeRepositorio.save(moradorUnidade);
    }

    //DELETE
    public void apagarMoradorUnidade(MoradorUnidade moradorUnidade) {
        moradorUnidadeRepositorio.delete(moradorUnidade);
    }
}