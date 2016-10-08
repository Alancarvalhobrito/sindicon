package sindicon.model.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sindicon.model.persistencia.entidade.Pessoa;
import sindicon.model.persistencia.repositorio.PessoaRepositorio;

/**
 * Created by Thiago on 08/10/2016.
 */
@Service
public class PessoaServico {
    @Autowired
    PessoaRepositorio pessoaRepositorio;

    //GET(Accesses)
    public Iterable<Pessoa> consultarPessoa() {
        return pessoaRepositorio.findAll();
    }

    //Post(Accesses)
    public void inserirPessoa(Pessoa pessoa) {
        pessoaRepositorio.save(pessoa);
    }

    //PUT(Accesses)
    public void atualizarPessoa(Pessoa pessoa) throws Exception {
        if (pessoa.getIdPessoa() == null) {
            throw new Exception("Não foi possível atualizar um pessoa com Id nulo.");
        }
        pessoaRepositorio.save(pessoa);
    }

    //DELETE(Accesses)
    public void apagarPessoa(Pessoa pessoa) {
        pessoaRepositorio.delete(pessoa);
    }
}