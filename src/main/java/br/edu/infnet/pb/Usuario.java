package br.edu.infnet.pb;

import javax.swing.text.html.parser.Parser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Usuario {

    private String nome;
    private String id;
    private String email;
    private String senha;
    private String[] noticiasSalvas;
    private String[] noticiasCurtidas;
    private String[] comentarios;

    public enum Plano {Gratis, Pago};
    private Plano plano;

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
        //id = String.valueOf(idGerado);
        id = "251";
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