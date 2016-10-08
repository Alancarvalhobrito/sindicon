package sindicon.controller.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sindicon.model.persistencia.entidade.Veiculo;
import sindicon.model.servico.VeiculoServico;

/**
 * Created by Thiago on 08/10/2016.
 */
@RestController
@RequestMapping("/veiculo")
public class VeiculoControle {
    @Autowired
    VeiculoServico veiculoServico;

    //GET(Accesses)
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Veiculo> get() {
        return veiculoServico.consultarVeiculos();
    }

    //Post(Accesses)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody Veiculo veiculo) {
        veiculoServico.inserirVeiculo(veiculo);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    //PUT(Accesses)
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> put(@RequestBody Veiculo veiculo) {
        HttpHeaders httpHeaders = new HttpHeaders();
        try {
            veiculoServico.atualizarVeiculo(veiculo);
        } catch (Exception e) {
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    //DELETE(Accesses)
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody Veiculo veiculo) {
        veiculoServico.apagarVeiculo(veiculo);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
    }
}