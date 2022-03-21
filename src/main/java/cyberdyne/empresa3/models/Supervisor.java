package cyberdyne.empresa3.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*@author Oliveira, Gaby*/
@Entity
public class Supervisor {
    
	/*id do supervisor*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_supervisor;

    /*nome do supervisor*/
    @Column(nullable = false, length = 60)
    private String su_nome;

    /*email do supervisor*/
    @Column(nullable = false)
    private String su_email;

    /*Ligação com a tabela de cargo, ONETOONE*/
    @OneToOne
    @JoinColumn(name = "id_cargo", unique = true)
    @JsonIgnore
    private Cargo cargo;

/*-----------------------------------GETTERS AND SETTERS0------------------------------*/
    

    public Cargo getCargo(){
        return cargo;
    }

    public void setCargo(Cargo cargo){
        this.cargo = cargo;
    }

	public Integer getId_supervisor() {
		return id_supervisor;
	}

	public void setId_supervisor(Integer id_supervisor) {
		this.id_supervisor = id_supervisor;
	}

	public String getSu_nome() {
		return su_nome;
	}

	public void setSu_nome(String su_nome) {
		this.su_nome = su_nome;
	}

	public String getSu_email() {
		return su_email;
	}

	public void setSu_email(String su_email) {
		this.su_email = su_email;
	}




}
