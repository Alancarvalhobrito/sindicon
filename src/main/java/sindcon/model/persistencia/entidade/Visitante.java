package sindcon.model.persistencia.entidade;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id_visitante", referencedColumnName = "id_pessoa")
public class Visitante extends Pessoa {
    private String observação;

    //Gets e Sets:
    public String getObservação() {
        return observação;
    }
    public void setObservação(String observação) {
        this.observação = observação;
    }
}