package com.greenetwork.greenetwork.Model;

/**
 * Created by Win10Moises on 30/10/2017.
 */

public class Alternativa {
    private int idAlternativa;
    private String descricaoAlternativa;
    private Pergunta perguntaAlternativa;

    public int getAlternativaCerta() {
        return alternativaCerta;
    }

    public void setAlternativaCerta(int alternativaCerta) {
        this.alternativaCerta = alternativaCerta;
    }

    private int alternativaCerta;

    public int getIdAlternativa() {
        return idAlternativa;
    }

    public void setIdAlternativa(int idAlternativa) {
        this.idAlternativa = idAlternativa;
    }

    public String getDescricaoAlternativa() {
        return descricaoAlternativa;
    }

    public void setDescricaoAlternativa(String descricaoAlternativa) {
        this.descricaoAlternativa = descricaoAlternativa;
    }

    public Pergunta getPerguntaAlternativa() {
        return perguntaAlternativa;
    }

    public void setPerguntaAlternativa(Pergunta perguntaAlternativa) {
        this.perguntaAlternativa = perguntaAlternativa;
    }

    public Alternativa() {
    }
}
