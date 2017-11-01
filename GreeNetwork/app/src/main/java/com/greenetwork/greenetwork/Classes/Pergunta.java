package com.greenetwork.greenetwork.Classes;

import java.util.List;

/**
 * Created by Win10Moises on 30/10/2017.
 */

public class Pergunta {
    private int idPergunta;
    private String descricaoPergunta;
    private int idAssunto;
    private String nivelPergunta;
    private List<Alternativa>listaDeAlternativas;

    public int getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(int idPergunta) {
        this.idPergunta = idPergunta;
    }

    public String getDescricaoPergunta() {
        return descricaoPergunta;
    }

    public void setDescricaoPergunta(String descricaoPergunta) {
        this.descricaoPergunta = descricaoPergunta;
    }

    public int getIdAssunto() {
        return idAssunto;
    }

    public void setIdAssunto(int idAssunto) {
        this.idAssunto = idAssunto;
    }

    public String getNivelPergunta() {
        return nivelPergunta;
    }

    public void setNivelPergunta(String nivelPergunta) {
        this.nivelPergunta = nivelPergunta;
    }

    public List<Alternativa> getListaDeAlternativas() {
        return listaDeAlternativas;
    }

    public void setListaDeAlternativas(List<Alternativa> listaDeAlternativas) {
        this.listaDeAlternativas = listaDeAlternativas;
    }

    public Pergunta() {
    }
}
