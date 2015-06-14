package models;

public class FormGcm {

	private String apiKey;
	private String regId;
	private String titulo;
	private String mensagem;

	public FormGcm(String apiKey, String regId, String titulo, String mensagem) {
		super();
		this.apiKey = apiKey;
		this.regId = regId;
		this.titulo = titulo;
		this.mensagem = mensagem;
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getRegId() {
		return regId;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

}
