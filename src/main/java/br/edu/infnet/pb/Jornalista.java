package br.edu.infnet.pb;

import java.util.ArrayList;
import java.util.List;

public class Jornalista extends Funcionarios{

	private String[] idJornalistas = {"251", "546", "731"};
	private List<Noticia> noticiasProduzidas;

	public Jornalista(String nome, String id, String email, String senha) {
		super(nome, id, email, senha);
	}
	
	public Jornalista() {
	}
	
	public String[] getIdJornalistas() {
        return idJornalistas;
    }

    public void setIdJornalistas(String[] idJornalistas) {
        this.idJornalistas = idJornalistas;
    }
    
	public List<Noticia> getNoticiasProduzidas() {
		return noticiasProduzidas;
	}

	public void setNoticiasProduzidas(List<Noticia> noticiasProduzidas) {
		this.noticiasProduzidas = noticiasProduzidas;
	}

}
