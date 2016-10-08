package sindicon.controller.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sindicon.model.persistencia.entidade.MoradorUnidade;
import sindicon.model.servico.MoradorUnidadeServico;

/**
 * Created by Thiago on 08/10/2016.
 */
@RestController
@RequestMapping("/moradorUnidade")
public class MoradorUnidadeControle {
    @Autowired
    MoradorUnidadeServico moradorUnidadeServico;

    //GET(Accesses)
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<MoradorUnidade> get() {
        return moradorUnidadeServico.consultarMoradoresUnidades();
    }

    //Post(Accesses)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody MoradorUnidade moradorUnidade) {
        moradorUnidadeServico.inserirMoradorUnidade(moradorUnidade);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    //PUT(Accesses)
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> put(@RequestBody MoradorUnidade moradorUnidade) {
        HttpHeaders httpHeaders = new HttpHeaders();
        try {
            moradorUnidadeServico.atualizarMoradorUnidade(moradorUnidade);
        } catch (Exception e) {
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    //DELETE(Accesses)
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody MoradorUnidade moradorUnidade) {
        moradorUnidadeServico.apagarMoradorUnidade(moradorUnidade);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
    }
}