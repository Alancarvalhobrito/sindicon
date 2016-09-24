package sindicon.model.persistencia.entidade;

import javax.persistence.*;

/**
 * Created by Thiago on 23/09/2016.
 */
@Entity
public class MoradorUnidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Integer idMoradorUnidade;

    //Relacionamentos:
    @ManyToOne
    @JoinColumn(name = "id_morador")
    private Morador morador;

    @ManyToOne
    @JoinColumn(name = "id_unidade")
    private Unidade unidade;

    //Gets e Sets
    public Integer getIdMoradorUnidade() {
        return idMoradorUnidade;
    }
    public void setIdMoradorUnidade(Integer idMoradorUnidade) {
        this.idMoradorUnidade = idMoradorUnidade;
    }
    public Morador getMorador() {
        return morador;
    }
    public void setMorador(Morador morador) {
        this.morador = morador;
    }
    public Unidade getUnidade() {
        return unidade;
    }
    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }
}
