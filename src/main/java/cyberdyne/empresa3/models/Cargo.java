package cyberdyne.empresa3.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

/*@author Oliveira, Gaby*/

@Entity
public class Cargo {
	
	/*id do cargo*/
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_cargo;
	
	/*nome do cargo*/
	@Column(nullable = false, length = 100)
	private String car_nome;
	
	/*atribuição do cargo*/
	@Column(nullable = false, length = 70)
	private String car_atribuicao;
	
	/*Lista de funcionarios*/
	@OneToMany(mappedBy = "cargo")
	private List<Funcionario> funcionario = new ArrayList<>();

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "id_supervisor", unique = true)
	private Supervisor supervisor;
	
	/*GETTERS AND SETTERS*/
	public Integer getId_cargo() {
		return id_cargo;
	}

	public void setId_cargo(Integer id_cargo) {
		this.id_cargo = id_cargo;
	}

	public String getCar_nome() {
		return car_nome;
	}

	public void setCar_nome(String car_nome) {
		this.car_nome = car_nome;
	}

	public String getCar_atribuicao() {
		return car_atribuicao;
	}

	public void setCar_atribuicao(String car_atribuicao) {
		this.car_atribuicao = car_atribuicao;
	}

	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}
	
	public Supervisor getSupervisor(){
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor){
		this.supervisor = supervisor;
	}
	
}
