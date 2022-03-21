package cyberdyne.empresa3.models;

/*
 * @author Oliveira, Gaby
 * @version 1.0
 * 
 */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Bonificacao {
	
	/*id da bonificacao*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	/*descrição da bonificação*/
	@Column(nullable = false)
	private String bo_descricao;
	
	/*mes em que será depositado a bonificação*/
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(columnDefinition = "date", nullable = false)
	private Date bo_mes;
	
	/*valor*/
	@NumberFormat(pattern = "#.##0,00")
	@Column(nullable = false)
	private Double bo_valor;
	
	/*status do pagamento*/
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StatusBonificacao bo_status;
	
	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getBo_descricao() {
		return bo_descricao;
	}

	public void setBo_descricao(String bo_descricao) {
		this.bo_descricao = bo_descricao;
	}

	public Date getBo_mes() {
		return bo_mes;
	}

	public void setBo_mes(Date bo_mes) {
		this.bo_mes = bo_mes;
	}

	public Double getBo_valor() {
		return bo_valor;
	}

	public void setBo_valor(Double bo_valor) {
		this.bo_valor = bo_valor;
	}

	public StatusBonificacao getBo_status() {
		return bo_status;
	}

	public void setBo_status(StatusBonificacao bo_status) {
		this.bo_status = bo_status;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
}
