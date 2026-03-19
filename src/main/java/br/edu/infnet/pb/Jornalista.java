package br.edu.infnet.pb;

import java.util.ArrayList;
import java.util.List;

public class Jornalista extends Funcionarios{

	private String[] noticiasProduzidas;
	private String[] idJornalistas = {"251", "546", "731"};

    public String[] getIdJornalistas() {
        return idJornalistas;
    }

    public void setIdJornalistas(String[] idJornalistas) {
        this.idJornalistas = idJornalistas;
    }
}
