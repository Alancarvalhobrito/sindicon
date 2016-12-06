package sindcon.model.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sindcon.model.persistencia.entidade.Endereco;
import sindcon.model.persistencia.repositorio.EnderecoRepositorio;

@Service
public class EnderecoServico {
    @Autowired
    EnderecoRepositorio enderecoRepositorio;

    //GET
    public Iterable<Endereco> consultarEnderecos() {
        return enderecoRepositorio.findAll();
    }

    //Post
    public void inserirEndereco(Endereco endereco) {
        enderecoRepositorio.save(endereco);
    }

    //PUT
    public void atualizarEndereco(Endereco endereco) throws Exception {
        if (endereco.getIdEndereco() == null) {
            throw new Exception("Não foi possível atualizar um endereco com Id nulo.");
        }
        enderecoRepositorio.save(endereco);
    }

    //DELETE
    public void apagarEndereco(Integer idEndereco) {
        enderecoRepositorio.delete(idEndereco);
    }
}