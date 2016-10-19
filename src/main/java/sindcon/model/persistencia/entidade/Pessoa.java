package sindcon.model.persistencia.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa")
    private Long idPessoa;
    private String nome;
    private Integer rg;
    private String ufRg;
    private String cpf;
    private Byte foto;
    @Column(name = "telefone_fixo")
    private String telefoneFixo;
    @Column(name = "telefone_movel")
    private String telefoneMovel;
    private String email;
    @Column(name = "tipo_pessoa")
    private char tipoPessoa;


    //Relacionamentos:
    @OneToMany(mappedBy = "pessoa")
    @JsonIgnore
    private Collection<Acesso> acessos;

    @OneToMany(mappedBy = "pessoa")
    @JsonIgnore
    private Collection<Veiculo> veiculos;

    @OneToMany(mappedBy = "pessoa")
    @JsonIgnore
    private Collection<Endereco> enderecos;

    //QRCODE(ZXING):

    //Gets e Sets:
    public Long getIdPessoa() {
        return idPessoa;
    }
    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getRg() {
        return rg;
    }
    public void setRg(Integer rg) {
        this.rg = rg;
    }
    public String getUfRg() {
        return ufRg;
    }
    public void setUfRg(String ufRg) {
        this.ufRg = ufRg;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Byte getFoto() {
        return foto;
    }
    public void setFoto(Byte foto) {
        this.foto = foto;
    }
    public String getTelefoneFixo() {
        return telefoneFixo;
    }
    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }
    public String getTelefoneMovel() {
        return telefoneMovel;
    }
    public void setTelefoneMovel(String telefoneMovel) {
        this.telefoneMovel = telefoneMovel;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public char getTipoPessoa() {
        return tipoPessoa;
    }
    public void setTipoPessoa(char tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
    public Collection<Acesso> getAcessos() {
        return acessos;
    }
    public void setAcessos(Collection<Acesso> acessos) {
        this.acessos = acessos;
    }
    public Collection<Veiculo> getVeiculos() {
        return veiculos;
    }
    public void setVeiculos(Collection<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
    public Collection<Endereco> getEnderecos() {
        return enderecos;
    }
    public void setEnderecos(Collection<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
