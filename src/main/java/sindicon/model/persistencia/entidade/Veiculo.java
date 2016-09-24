package sindicon.model.persistencia.entidade;

import javax.persistence.*;

/**
 * Created by Thiago on 11/09/2016.
 */
@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_veiculo")
    private Integer idVeiculo;
    private String modelo;
    private String placa;

    //Relacionamentos:
    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    //Gets e Sets:
    public Integer getIdVeiculo() {
        return idVeiculo;
    }
    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}