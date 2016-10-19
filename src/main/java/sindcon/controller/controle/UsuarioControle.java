package sindcon.controller.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sindcon.model.persistencia.entidade.Usuario;
import sindcon.model.servico.UsuarioServico;

@RestController
@RequestMapping("/usuario")
public class UsuarioControle {
    @Autowired
    UsuarioServico usuarioServico;

    //GET(Accesses)
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Usuario> get() {
        return usuarioServico.consultarUsuarios();
    }

    //Post(Accesses)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody Usuario usuario) {
        usuarioServico.inserirUsuario(usuario);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    //PUT(Accesses)
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> put(@RequestBody Usuario usuario) {
        HttpHeaders httpHeaders = new HttpHeaders();
        try {
            usuarioServico.atualizarUsuario(usuario);
        } catch (Exception e) {
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    //DELETE(Accesses)
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody Usuario usuario) {
        usuarioServico.apagarUsuario(usuario);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
    }
}