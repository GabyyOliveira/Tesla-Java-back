package cyberdyne.empresa3.models;

/*@author Oliveira, Gaby*/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Funcionario {
	
	/*id do funcionario*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_funcionario;
	
	/*nome do funcionario*/
	@Column(nullable = false, length = 60)
	private String func_nome;

	/*email do funcionario*/
	@Column(nullable = false, length = 60)
	private String func_email;

	/*telefone do funcionario*/
	@Column(nullable = false, length = 15)
	private String func_telefone;
	
	/*cidade do funcionario*/
	@Column(nullable = false, length = 30)
	private String func_cidade;

	/*foto do funcionario*/
	@Column(nullable = true)
	private String func_foto;
	
	/*ligação com a tabela de cargo*/
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_cargo")
	private Cargo cargo;
	
	/*GETTERS AND SETTERS*/
	public Integer getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(Integer id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public String getFunc_nome() {
		return func_nome;
	}

	public void setFunc_nome(String func_nome) {
		this.func_nome = func_nome;
	}

	public String getFunc_email(){
		return func_email;
	}

	public void setFunc_email(String func_email){
		this.func_email = func_email;
	}

	public String getFunc_telefone(){
		return func_telefone;
	}

	public void setFunc_telefone(String func_telefone){
		this.func_telefone = func_telefone;
	}

	public String getFunc_cidade() {
		return func_cidade;
	}

	public void setFunc_cidade(String func_cidade) {
		this.func_cidade = func_cidade;
	}
	
	public String getFunc_foto() {
		return func_foto;
	}

	public void setFunc_foto(String func_foto) {
		this.func_foto = func_foto;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	
	
}

