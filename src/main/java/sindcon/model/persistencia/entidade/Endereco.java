package sindcon.model.persistencia.entidade;

import javax.persistence.*;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_endereco")
    private Integer idEndereco;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    //Relacionamentos:
    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    //Gets e Sets:
    public Integer getIdEndereco() {
        return idEndereco;
    }
    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}