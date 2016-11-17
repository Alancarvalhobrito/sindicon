package sindcon.model.persistencia.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by marconi.junior on 16/11/2016.
 */
@Entity
public class Bloco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_bloco")
    private Integer idBloco;
    @OneToMany(mappedBy = "bloco")
    @JsonIgnore
    private Collection<Unidade> unidades;
    @Column(name = "letra_bloco", unique = true)
    private String letraBloco;

    public Collection<Unidade> getUnidades() {
        return unidades;
    }

    public void setUnidades(Collection<Unidade> unidades) {
        this.unidades = unidades;
    }

    public String getLetraBloco() {
        return letraBloco;
    }

    public void setLetraBloco(String letraBloco) {
        this.letraBloco = letraBloco;
    }

    public Integer getIdBloco() {
        return idBloco;
    }

    public void setIdBloco(Integer idBloco) {
        this.idBloco = idBloco;
    }
}
