package models;

public class Payload {

    private final String titulo;
    private final String mensagem;

    public Payload(String titulo, String mensagem) {
        this.titulo = titulo;
        this.mensagem = mensagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

}
