package sindicon.model.persistencia.entidade;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Thiago on 12/09/2016.
 */
@Entity
public class Acesso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_acesso")
    private Integer idAcesso;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_entrada")
    private Date dataEntrada;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_saida")
    private Date dataSaida;

    //Relacionamentos:
    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    //Gets e Sets:
    public Integer getIdAcesso() {
        return idAcesso;
    }
    public void setIdAcesso(Integer idAcesso) {
        this.idAcesso = idAcesso;
    }
    public Date getDataEntrada() {
        return dataEntrada;
    }
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    public Date getDataSaida() {
        return dataSaida;
    }
    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}