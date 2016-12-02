package sindcon.controller.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sindcon.model.persistencia.entidade.Visitante;
import sindcon.model.servico.VisitanteServico;

@RestController
@RequestMapping("/visitante")
public class VisitanteControle {
    @Autowired
    VisitanteServico visitanteServico;

    //GET(Accesses)
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Visitante> get() {
        return visitanteServico.consultarVisitantes();
    }

    //Post(Accesses)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody Visitante visitante) {
        visitanteServico.inserirVisitante(visitante);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    //PUT(Accesses)
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> put(@RequestBody Visitante visitante) {
        HttpHeaders httpHeaders = new HttpHeaders();
        try {
            visitanteServico.atualizarVisitante(visitante);
        } catch (Exception e) {
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    //DELETE(Accesses)
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestParam Integer id) {
        visitanteServico.apagarVisitante(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
    }
}