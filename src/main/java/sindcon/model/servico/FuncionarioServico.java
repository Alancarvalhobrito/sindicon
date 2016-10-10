package sindcon.model.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sindcon.model.persistencia.entidade.Funcionario;
import sindcon.model.persistencia.repositorio.FuncionarioRepositorio;

/**
 * Created by Thiago on 08/10/2016.
 */
@Service
public class FuncionarioServico {
    @Autowired
    FuncionarioRepositorio funcionarioRepositorio;

    //GET
    public Iterable<Funcionario> consultarFuncionarios() {
        return funcionarioRepositorio.findAll();
    }

    //Post
    public void inserirFuncionario(Funcionario funcionario) {
        funcionarioRepositorio.save(funcionario);
    }


    //PUT - (GetIdPessoa ou getIdFuncionario)
    public void atualizarFuncionario(Funcionario funcionario) throws Exception {
        if (funcionario.getIdPessoa() == null) {
            throw new Exception("Não foi possível atualizar um funcionario com Id nulo.");
        }
        funcionarioRepositorio.save(funcionario);
    }

    //DELETE
    public void apagarFuncionario(Funcionario funcionario) {
        funcionarioRepositorio.delete(funcionario);
    }
}