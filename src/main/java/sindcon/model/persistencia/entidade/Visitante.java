package sindcon.model.persistencia.entidade;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id_visitante", referencedColumnName = "id_pessoa")
public class Visitante extends Pessoa {
    private String observacao;

    //Gets e Sets:
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}