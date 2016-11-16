package sindcon.model.persistencia.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Unidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_unidade")
    private Integer idUnidade;

    @Column(name = "numero_casa")
    private Integer numeroCasa;

    @ManyToOne
    @JoinColumn(name = "letra_bloco")
    private Bloco bloco;

    //Relacionamentos:
    @OneToMany(mappedBy = "unidade")
    @JsonIgnore
    private Collection<Morador> moradores;

    //Gets e Sets:
    public Integer getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }

    public Integer getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(Integer numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public Collection<Morador> getMoradores() {
        return moradores;
    }

    public void setMoradores(Collection<Morador> moradores) {
        this.moradores = moradores;
    }
}
