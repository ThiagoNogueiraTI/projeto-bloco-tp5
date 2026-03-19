package br.edu.infnet.pb;

import java.sql.Date;
import java.util.List;

public class Noticia {
	
	private String idNoticia;
	private String titulo;
	private String conteudo;
	private Date data;
	private int curtidas = 0;
	private enum Tipo{Gratis, Paga};
	private Tipo tipo;
	//private String[] categorias;
	private List<String> comentarios;

	public List<String> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<String> comentarios) {
		this.comentarios = comentarios;
	}

	public int getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(int curtidas) {
		this.curtidas = curtidas;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public void gerarId(){
        int idGerado = (int) (Math.ceil(Math.random() * 1000));
        idNoticia = String.valueOf(idGerado);
    }
	
	/*public String[] getComentarios() {
		return comentarios;
	}

	public void setComentarios(String[] comentarios) {
		this.comentarios = comentarios;
	}*/
	
}
