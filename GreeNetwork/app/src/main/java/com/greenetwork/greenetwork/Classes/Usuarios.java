package com.greenetwork.greenetwork.Classes;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.greenetwork.greenetwork.DAO.ConfiguracaoFirebase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Win10Moises on 27/10/2017.
 */

public class Usuarios {
    private String id;
    private String Email;
    private String Senha;
    private String nome;
    private String Apelido;
    private String cpf;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return Apelido;
    }

    public void setApelido(String apelido) {
        Apelido = apelido;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void Salvar(){
        DatabaseReference referenciaFirebase = ConfiguracaoFirebase.getFibase();
        referenciaFirebase.child("usuario").child(String.valueOf(getId())).setValue(this);
    }
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> hashMapUsuario = new HashMap<>();
        hashMapUsuario.put("id", getId());
        hashMapUsuario.put("nome", getNome());
        hashMapUsuario.put("Apelido", getApelido());
        hashMapUsuario.put("Email", getEmail());
        hashMapUsuario.put("Senha", getSenha());
        return hashMapUsuario;
    }


    public Usuarios() {
    }
}
