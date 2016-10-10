package sindcon.model.persistencia.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Thiago on 23/09/2016.
 */
@Entity
public class Unidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_unidade")
    private Integer idUnidade;
    private char bloco;
    @Column(name = "numero_casa")
    private Integer numeroCasa;

    //Relacionamentos:
    @OneToMany(mappedBy = "unidade")
    @JsonIgnore
    private Collection<MoradorUnidade> moradoresUnidades;

    //Gets e Sets:
    public Integer getIdUnidade() {
        return idUnidade;
    }
    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }
    public char getBloco() {
        return bloco;
    }
    public void setBloco(char bloco) {
        this.bloco = bloco;
    }
    public Integer getNumeroCasa() {
        return numeroCasa;
    }
    public void setNumeroCasa(Integer numeroCasa) {
        this.numeroCasa = numeroCasa;
    }
    public Collection<MoradorUnidade> getMoradoresUnidades() {
        return moradoresUnidades;
    }
    public void setMoradoresUnidades(Collection<MoradorUnidade> moradoresUnidades) {
        this.moradoresUnidades = moradoresUnidades;
    }
}
