package sindicon.model.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sindicon.model.persistencia.entidade.Usuario;
import sindicon.model.persistencia.repositorio.UsuarioRepositorio;

/**
 * Created by Thiago on 08/10/2016.
 */
@Service
public class UsuarioServico {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    //GET
    public Iterable<Usuario> consultarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    //Post
    public void inserirUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    //PUT
    public void atualizarUsuario(Usuario usuario) throws Exception {
        if (usuario.getIdUsuario() == null) {
            throw new Exception("Não foi possível atualizar um usuario com Id nulo.");
        }
        usuarioRepositorio.save(usuario);
    }

    //DELETE
    public void apagarUsuario(Usuario usuario) {
        usuarioRepositorio.delete(usuario);
    }
}