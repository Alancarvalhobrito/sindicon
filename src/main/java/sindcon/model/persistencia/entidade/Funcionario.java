package sindcon.model.persistencia.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Collection;

@Entity
@PrimaryKeyJoinColumn(name = "id_funcionario", referencedColumnName = "id_pessoa")
public class Funcionario extends Pessoa {
    private String cargo;
    private String matricula;

    //Relacionamentos:
    @OneToMany(mappedBy = "funcionario")
    @JsonIgnore
    private Collection<Usuario> usuarios;

    //Gets e Sets:
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
