package br.edu.infnet.pb;

import java.util.List;

public class Administrador extends Funcionarios{

    
	private List<String> acessosParaLiberar;
	private List<String> acessosLiberados;
    private String[] idAdm = {"411", "558", "441"};

    public Administrador(String nome, String id, String email, String senha) {
		super(nome, id, email, senha);
	}
	
	public Administrador() {
	}
	
    public String[] getIdAdm() {
		return idAdm;
	}
	public void setIdAdm(String[] idAdm) {
		this.idAdm = idAdm;
	}
	
	public List<String> getAcessosParaLiberar() {
		return acessosParaLiberar;
	}
	public void setAcessosParaLiberar(List<String> acessosParaLiberar) {
		this.acessosParaLiberar = acessosParaLiberar;
	}
	public List<String> getAcessosLiberados() {
		return acessosLiberados;
	}
	public void setAcessosLiberados(List<String> acessosLiberados) {
		this.acessosLiberados = acessosLiberados;
	}
}
