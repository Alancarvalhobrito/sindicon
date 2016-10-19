package sindcon.model.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sindcon.model.persistencia.entidade.Pessoa;
import sindcon.model.persistencia.repositorio.PessoaRepositorio;

@Service
public class PessoaServico {
    @Autowired
    PessoaRepositorio pessoaRepositorio;

    //GET
    public Iterable<Pessoa> consultarPessoas() {
        return pessoaRepositorio.findAll();
    }

    //Post
    public void inserirPessoa(Pessoa pessoa) {
        pessoaRepositorio.save(pessoa);
    }

    //PUT
    public void atualizarPessoa(Pessoa pessoa) throws Exception {
        if (pessoa.getIdPessoa() == null) {
            throw new Exception("Não foi possível atualizar um pessoa com Id nulo.");
        }
        pessoaRepositorio.save(pessoa);
    }

    //DELETE
    public void apagarPessoa(Pessoa pessoa) {
        pessoaRepositorio.delete(pessoa);
    }
}