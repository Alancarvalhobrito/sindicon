package sindcon.model.persistencia.entidade;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "id_morador", referencedColumnName = "id_pessoa")
public class Morador extends Pessoa {
    //Relacionamentos:

    @ManyToOne
    @JoinColumn(name = "unidade_id_unidade")
    private Unidade unidade;

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }
}