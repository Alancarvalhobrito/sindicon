package sindicon.model.servico;

/**
 * Created by Thiago on 08/10/2016.
 */

import org.springframework.stereotype.Service;
import sindicon.model.persistencia.entidade.Endereco;
import sindicon.model.persistencia.repositorio.EnderecoRepositorio;

@Service
public class EnderecoServico {
    EnderecoRepositorio enderecoRepositorio;

    //GET(Adresses)
    public Iterable<Endereco> consultarEndereco() {
        return enderecoRepositorio.findAll();
    }

    //Post(Adresses)
    public void inserirEndereco(Endereco endereco) {
        enderecoRepositorio.save(endereco);
    }

    //PUT(Adresses)
    public void atualizarEndereco(Endereco endereco) throws Exception {
        if (endereco.getIdEndereco() == null) {
            throw new Exception("Não foi possível atualizar um endereco com Id nulo.");
        }
        enderecoRepositorio.save(endereco);
    }

    //DELETE(Adresses)
    public void apagarEndereco(Endereco endereco) {
        enderecoRepositorio.delete(endereco);
    }
}