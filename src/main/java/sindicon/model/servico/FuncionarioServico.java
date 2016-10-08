package sindicon.model.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sindicon.model.persistencia.entidade.Funcionario;
import sindicon.model.persistencia.repositorio.FuncionarioRepositorio;

/**
 * Created by Thiago on 08/10/2016.
 */
@Service
public class FuncionarioServico {
    @Autowired
    FuncionarioRepositorio funcionarioRepositorio;

    //GET(Accesses)
    public Iterable<Funcionario> consultarFuncionario() {
        return funcionarioRepositorio.findAll();
    }

    //Post(Accesses)
    public void inserirFuncionario(Funcionario funcionario) {
        funcionarioRepositorio.save(funcionario);
    }


    //PUT(Accesses) - (GetIdPessoa ou getIdFuncionario)
    public void atualizarFuncionario(Funcionario funcionario) throws Exception {
        if (funcionario.getIdPessoa() == null) {
            throw new Exception("Não foi possível atualizar um funcionario com Id nulo.");
        }
        funcionarioRepositorio.save(funcionario);
    }

    //DELETE(Accesses)
    public void apagarFuncionario(Funcionario funcionario) {
        funcionarioRepositorio.delete(funcionario);
    }
}