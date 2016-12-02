package sindcon.controller.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sindcon.model.persistencia.entidade.Pessoa;
import sindcon.model.servico.PessoaServico;

@RestController
@RequestMapping("/pessoa")
public class PessoaControle {
    @Autowired
    PessoaServico pessoaServico;

    //GET(Accesses)
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Pessoa> get() {
        return pessoaServico.consultarPessoas();
    }

    //Post(Accesses)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody Pessoa pessoa) {
        pessoaServico.inserirPessoa(pessoa);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    //PUT(Accesses)
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> put(@RequestBody Pessoa pessoa) {
        HttpHeaders httpHeaders = new HttpHeaders();
        try {
            pessoaServico.atualizarPessoa(pessoa);
        } catch (Exception e) {
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    //DELETE(Accesses)
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestParam Integer id) {
        pessoaServico.apagarPessoa(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
    }
}