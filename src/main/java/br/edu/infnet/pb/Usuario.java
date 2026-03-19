package br.edu.infnet.pb;

import java.util.List;

public class Usuario {

    private String nome;
    private String id;
    private String email;
    private String senha;
	private List<Noticia> noticiasCurtidas;
    private List<Noticia> comentarios;
	private List<Noticia> noticiaSalva;
    public enum Plano {Gratis, Pago};
    private Plano plano;

    public List<Noticia> getNoticiasCurtidas() {
		return noticiasCurtidas;
	}

	public void setNoticiasCurtidas(List<Noticia> noticiasCurtidas) {
		this.noticiasCurtidas = noticiasCurtidas;
	}

	public List<Noticia> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Noticia> comentarios) {
		this.comentarios = comentarios;
	}
    
    public List<Noticia> getNoticiaSalva() {
		return noticiaSalva;
	}

	public void setNoticiaSalva(List<Noticia> noticiaSalva) {
		this.noticiaSalva = noticiaSalva;
	}

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void gerarId(){
        int idGerado = (int) (Math.ceil(Math.random() * 1000));
        System.out.println(idGerado);
        id = String.valueOf(idGerado);
        //id = "411";
    }
    
    public void setPlano(Plano plano) {
    	this.plano = plano;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}