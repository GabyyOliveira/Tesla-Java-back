package cyberdyne.empresa3.models;

public enum StatusBonificacao {

	PENDENTE("Pendente"),
	RECEBIDO("Recebido"),
	CANCELADO("Cancelado");
	
	private String descricao;
	
	StatusBonificacao(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
