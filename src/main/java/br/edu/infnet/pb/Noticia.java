package br.edu.infnet.pb;

import java.sql.Date;

public class Noticia {

	private String idNoticia;
	private String titulo;
	private String conteudo;
	private Date data;
	private int curtidas;
	private String[] comentarios;
	private enum Tipo{Gratis, Paga};
	private Tipo tipo;
	private String[] categorias;
	
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
}
