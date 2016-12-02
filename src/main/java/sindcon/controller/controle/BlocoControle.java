package sindcon.controller.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sindcon.model.persistencia.entidade.Bloco;
import sindcon.model.servico.BlocoServico;

@RestController
@RequestMapping("/bloco")
public class BlocoControle {
    @Autowired
    BlocoServico blocoServico;

    //GET(Accesses)
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Bloco> get() {
        return blocoServico.consultarBlocos();
    }

    //Post(Accesses)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody Bloco bloco) {
        blocoServico.inserirBloco(bloco);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    //PUT(Accesses)
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> put(@RequestBody Bloco bloco) {
        HttpHeaders httpHeaders = new HttpHeaders();
        try {
            blocoServico.atualizarBloco(bloco);
        } catch (Exception e) {
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    //DELETE(Accesses)
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestParam Integer id) {
        blocoServico.apagarBloco(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
    }
}