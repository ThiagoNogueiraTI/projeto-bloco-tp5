package br.edu.infnet.pb;

import java.util.List;

public class EditorChefe extends Funcionarios{

    private List<Noticia> noticiasParaRevisar;
	private List<Noticia> noticiasPublicadas;
    private String[] idEditorChefe = {"151", "774", "937"};

    public EditorChefe(String nome, String id, String email, String senha) {
		super(nome, id, email, senha);
	}
	
	public EditorChefe() {
	}
    
    public void publicar(){

    }

    public List<Noticia> getNoticiasParaRevisar() {
        return noticiasParaRevisar;
    }

    public void setNoticiasParaRevisar(List<Noticia> noticiasParaRevisar) {
        this.noticiasParaRevisar = noticiasParaRevisar;
    }

    public List<Noticia> getNoticiasPublicadas() {
        return noticiasPublicadas;
    }

    public void setNoticiasPublicadas(List<Noticia> noticiasPublicadas) {
        this.noticiasPublicadas = noticiasPublicadas;
    }

    public String[] getIdEditorChefe() {
        return idEditorChefe;
    }

    public void setIdEditorChefe(String[] idEditorChefe) {
        this.idEditorChefe = idEditorChefe;
    }
}
