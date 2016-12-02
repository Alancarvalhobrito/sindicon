package sindcon.controller.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sindcon.model.persistencia.entidade.Endereco;
import sindcon.model.servico.EnderecoServico;

@RestController
@RequestMapping("/endereco")
public class EnderecoControle {
    @Autowired
    EnderecoServico enderecoServico;

    //GET(Accesses)
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Endereco> get() {
        return enderecoServico.consultarEnderecos();
    }

    //Post(Accesses)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody Endereco endereco) {
        enderecoServico.inserirEndereco(endereco);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    //PUT(Accesses)
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> put(@RequestBody Endereco endereco) {
        HttpHeaders httpHeaders = new HttpHeaders();
        try {
            enderecoServico.atualizarEndereco(endereco);
        } catch (Exception e) {
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    //DELETE(Accesses)
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestParam Integer id) {
        enderecoServico.apagarEndereco(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
    }
}