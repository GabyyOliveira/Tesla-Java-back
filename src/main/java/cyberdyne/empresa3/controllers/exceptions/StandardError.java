package cyberdyne.empresa3.controllers.exceptions;

//É ATRAVÉS DESTA CLASSE QUE DEFINIMOS OS TRIBUTOS QUE IRA RETORNAR
public class StandardError {
	
	//ATRIBUTOS
	private Long timesTempo;
	private Integer status;
	private String error;
	
	//CONSTRUCTOR
	public StandardError(Long timesTempo, Integer status, String error) {
		super();
		this.timesTempo = timesTempo;
		this.status = status;
		this.error = error;
	}

	//GETTERS AND SETTERS
	public Long getTimesTempo() {
		return timesTempo;
	}

	public void setTimesTempo(Long timesTempo) {
		this.timesTempo = timesTempo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	

}
