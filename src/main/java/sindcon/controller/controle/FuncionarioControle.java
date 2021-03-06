package sindcon.controller.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sindcon.model.persistencia.entidade.Funcionario;
import sindcon.model.servico.FuncionarioServico;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioControle {
    @Autowired
    FuncionarioServico funcionarioServico;

    //GET(Accesses)
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Funcionario> get() {
        return funcionarioServico.consultarFuncionarios();
    }

    //Post(Accesses)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody Funcionario funcionario) {
        funcionarioServico.inserirFuncionario(funcionario);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    //PUT(Accesses)
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> put(@RequestBody Funcionario funcionario) {
        HttpHeaders httpHeaders = new HttpHeaders();
        try {
            funcionarioServico.atualizarFuncionario(funcionario);
        } catch (Exception e) {
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    //DELETE(Accesses)
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestParam Integer id) {
        funcionarioServico.apagarFuncionario(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
    }
}