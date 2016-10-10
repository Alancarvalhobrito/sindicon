package sindcon.model.persistencia.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Thiago on 11/09/2016.
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_morador", referencedColumnName = "id_pessoa")
public class Morador extends Pessoa {

    //Relacionamentos:
    @OneToMany(mappedBy = "morador")
    @JsonIgnore
    private Collection<MoradorUnidade> moradoresUnidades;

    //Gets e Sets:
    public Collection<MoradorUnidade> getMoradoresUnidades() {
        return moradoresUnidades;
    }
    public void setMoradoresUnidades(Collection<MoradorUnidade> moradoresUnidades) {
        this.moradoresUnidades = moradoresUnidades;
    }
}